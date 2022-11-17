import java.io.*;
// import java.math.*;
// import java.security.*;
// import java.text.*;
import java.util.*;
// import java.util.concurrent.*;
// import java.util.function.*;
// import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

enum Direction {
    Right,
    Down
}

class Slot {
    public Direction orientation;
    public int startRow;
    public int startCol;
    public int size;
}

class Result {

    /*
     * Complete the 'crosswordPuzzle' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY crossword
     *  2. STRING words
     */

    private static final int numRows = 10;
    private static final int numCols = 10;

    public static List<String> crosswordPuzzle(List<String> crossword, String words) {
        System.out.println("crossword input:");
        printCrossword(crossword);
        System.out.println("word list:");
        System.out.println(words);
        
        char[][] grid = makeGrid(crossword);
        List<Slot> slots = makeSlots(grid);
        List<String> output = makeOutput(grid);

        System.out.println("list of slots:");
        printSlots(slots);
        System.out.println("crossword output:");
        printCrossword(output);

        return output;
    }

    private static void printCrossword(List<String> crossword) {
        for (String line : crossword) {
            System.out.println(line);
        }
    }

    private static void printSlots(List<Slot> slots) {
        for (Slot slot : slots) {
            System.out.println("orientation = " + slot.orientation);
            System.out.println("startRow = " + slot.startRow);
            System.out.println("startCol = " + slot.startCol);
            System.out.println("size = " + slot.size);
        }
    }

    private static char[][] makeGrid(List<String> crossword) {
        char[][] grid = new char[numRows][numCols];
        int row = 0;
        for (String line : crossword) {
            for (int col = 0; col < numCols; col++) {
                grid[row][col] = col < line.length() ? line.charAt(col) : '+';
                // System.out.print(grid[row][col]);
            }
            // System.out.println();
            row++;
        }
        return grid;
    }

    private static List<Slot> makeSlots(char[][] grid) {
        List<Slot> slots = new ArrayList<Slot>();

        // scan top to bottom, left to right, looking for places to start walk of grid to make slots
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                char c = grid[row][col];
                // cell not part of a slot
                if (c == '+') continue;
                // cell part of one or more slots
                if (c == '-') {
                    // traverse right
                    Slot rightSlot = new Slot();
                    rightSlot.orientation = Direction.Right;
                    rightSlot.startRow = row;
                    rightSlot.startCol = col;
                    rightSlot.size = 1;
                    walkGrid(grid, row, col, Direction.Right, rightSlot, slots);

                    // traverse down
                    Slot downSlot = new Slot();
                    downSlot.orientation = Direction.Down;
                    downSlot.startRow = row;
                    downSlot.startCol = col;
                    downSlot.size = 1;
                    walkGrid(grid, row, col, Direction.Down, downSlot, slots);

                    continue;
                }
            }
        }

        // TODO: prune list of slots, for case of 2 of them with same start coordinates, size of 1

        return slots;
    }

    private static List<String> makeOutput(char[][] grid) {
        List<String> output = new ArrayList<String>();
        for (int row = 0; row < numRows; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < numCols; col++) {
                sb.append(grid[row][col]);
                // System.out.print(grid[row][col]);
            }
            // System.out.println();
            output.add(sb.toString());
        }
        // System.out.println(output);
        return output;
    }

    private static void walkGrid(char[][] grid, int row, int col, Direction dir, Slot slot, List<Slot> slots) {
        // remember parental cell value, adjust row and column for direction
        char parent = grid[row][col];
        row += (dir == Direction.Down) ? 1 : 0;
        col += (dir == Direction.Right) ? 1 : 0;

        // range checks for going off the grid, also check to stop walk on cell not part of any slot
        if (row >= numRows || col >= numCols || grid[row][col] == '+') {
            slots.add(slot);
            return;
        }

        // stop walk on cell already traversed, with parent already traversed (not just an intersection)
        if (parent == '=' && grid[row][col] == '=') return;

        // mark cell as already traversed, increase size of current slot
        grid[row][col] = '=';
        slot.size += 1;

        // traverse right, traverse down
        Slot newSlot = new Slot();
        newSlot.orientation = (dir == Direction.Right) ? Direction.Down : Direction.Right;
        newSlot.startRow = row;
        newSlot.startCol = col;
        newSlot.size = 1;
        walkGrid(grid, row, col, Direction.Right, (dir == Direction.Right) ? slot : newSlot, slots);
        walkGrid(grid, row, col, Direction.Down, (dir == Direction.Down) ? slot : newSlot, slots);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input1.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<String> crossword = IntStream.range(0, 10).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        String words = bufferedReader.readLine();

        List<String> result = Result.crosswordPuzzle(crossword, words);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
