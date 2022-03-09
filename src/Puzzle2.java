import java.util.ArrayList;

/*
* Puzzle 2 of Advent of Code
* Question: What do you get if you multiply your final horizontal position by your final depth?
* @see https://adventofcode.com/2021/day/2
*
* @author Nina Tietje
*/
public class Puzzle2 {

    private final int result;

    public Puzzle2() {
        //read input file
        String filepath = "inputs/input_2.txt";
        TxtReader reader = new TxtReader();
        ArrayList<String> lines = reader.read(filepath);

        //split the lines and check command for math operation
        int depth = 0;
        int forward = 0;
        int aim = 0;
        for (String line : lines) {
            String command = line.split(" ")[0];
            int value = Integer.parseInt(line.split(" ")[1]);
            //check command string
            if (command.equals("forward")) {
                forward += value;
                depth += aim * value;
            }
            else if (command.equals("down")) {
                aim += value;
            }
            else {
                aim -= value;
            }
        }
        result = depth * forward;
    }

    public void printResult() {
        System.out.println("With Aim: Horizontal position * depth = " + result);
    }
}
