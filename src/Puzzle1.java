import java.util.ArrayList;

/*
* Puzzle 1 of Advent of Code
* Question: How many sums are larger than the previous sum?
* @see https://adventofcode.com/2021/day/1
*
* @author Nina Tietje
*/
public class Puzzle1 {

    private final int result;

    public Puzzle1() {
        //read input file and parse into Integer
        String filepath = "inputs/input_1.txt";
        TxtReader reader = new TxtReader();
        ArrayList<Integer> numbers = reader.toIntegerList(reader.read(filepath));
        //count increasing of numbers
        int increased = 0;
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i-1) < numbers.get(i)) {
                increased++;
            }
        }
        result = increased;
    }

    public void printResult() {
        System.out.println("Increased " + result + " times.");
    }
}
