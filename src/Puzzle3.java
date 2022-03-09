import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

/*
 * Puzzle 3 of Advent of Code
 * Questions:
 * Part1: What is the power consumption of the submarine?
 * Part2: What is the life support rating of the submarine?
 * @see https://adventofcode.com/2021/day/2
 *
 * @author Nina Tietje
 */
public class Puzzle3 {

    private int power;
    private int lifeSupport;

    public Puzzle3(ArrayList<String> lines) {
        int length = lines.get(0).length(); //length of the binary strings
        firstPart(lines, length);
        secondPart(lines, length);
    }

    public void printResult() {
        System.out.println("The power (gamma rate * epsilon rate) is: " + power);
        System.out.println("The life support rating (oxygen rating * co2 rating) is: " + lifeSupport);
    }

    /*
     * calculation to answer the first question
     *
     * @param lines - text you want to parse to Integers
     * @param length - length of the strings
     * */
    private void firstPart(@NotNull ArrayList<String> lines, int length) {
        int[] frequency0 = new int[length];
        int[] frequency1 = new int[length];
        //count frequency of 0 and 1 for every column
        for (String line : lines) {
            for (int i = 0; i < length; i++) {
                String s = line.substring(i, i + 1);
                if (s.equals("0")) {
                    frequency0[i]++;
                } else {
                    frequency1[i]++;
                }
            }
        }
        int gammaRate = 0b0;
        int epsilonRate = 0b0;
        //compare frequencies and calculate the associated rate with binaries and shifting
        for (int i = 0; i < length; i++) {
            gammaRate = gammaRate << 1;
            epsilonRate = epsilonRate << 1;
            if (frequency0[i] > frequency1[i]) {
                gammaRate += 0b0;
                epsilonRate += 0b1;
            } else {
                gammaRate += 0b1;
                epsilonRate += 0b0;
            }
        }
        power = gammaRate * epsilonRate;
    }

    /*
     * calculation to answer the second question
     *
     * @param lines - text you want to parse to Integers
     * @param length - length of the strings
     * */
    private void secondPart(ArrayList<String> lines, int length) {
        int oxygen = Integer.parseInt(getSearchedBinary(lines, length, true), 2);
        int co2 = Integer.parseInt(getSearchedBinary(lines, length, false), 2);
        lifeSupport = oxygen * co2;
    }

    /*
     * search the binary string for oxygen (most) or co2 (least)
     *
     * @param lines - text you want to parse to Integers
     * @param length - length of the strings
     * @param searchMost - true: take the most found bit, false: take the least found bit
     * */
    private String getSearchedBinary(ArrayList<String> lines, int length, boolean searchMost) {
        ArrayList<String> binaryStrings = new ArrayList<>(lines);
        //search in every column of the input
        for (int i = 0; i < length; i++) {
            int frequency0 = 0;
            int frequency1 = 0;
            ArrayList<String> toRemove;
            ArrayList<String> binaries0 = new ArrayList<>();
            ArrayList<String> binaries1 = new ArrayList<>();
            //count frequencies and add temp binary to matching list
            for (String binary : binaryStrings) {
                String b = binary.substring(i, i + 1);
                if (b.equals("0")) {
                    frequency0++;
                    binaries0.add(binary);
                } else {
                    frequency1++;
                    binaries1.add(binary);
                }
            }
            //check which binary list should be removed
            if (frequency0 > frequency1) {
                toRemove = binaries1;
                if (!searchMost) {
                    toRemove = binaries0;
                }
            } else {
                toRemove = binaries0;
                if (!searchMost) {
                    toRemove = binaries1;
                }
            }
            //remove binary list from (for) loop list
            if (binaryStrings.size() > 1) {
                binaryStrings.removeAll(toRemove);
            }
            binaries0.clear();
            binaries1.clear();
        }
        return binaryStrings.get(0);
    }

}
