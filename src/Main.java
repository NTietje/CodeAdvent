import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //read input file
        String filepath = "inputs/input_3.txt";
        TxtReader reader = new TxtReader();
        ArrayList<String> lines = reader.read(filepath);
        //create (and calculate) puzzle
        Puzzle3 puzzle = new Puzzle3(lines);
        puzzle.printResult();
    }

}

