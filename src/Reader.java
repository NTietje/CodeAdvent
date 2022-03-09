import java.util.ArrayList;
/*
 * abstract reader class for the Advent of Code inputs
 *
 * @author Nina Tietje
 */
public abstract class Reader {

    public Reader() {
    }

    abstract ArrayList<String> read(String filepath);

    /*
    * method for parsing a String ArrayList into Integer
    *
    * @param input - text you want to parse to Integers
    * @return numbers - parsed Integers in an ArrayList
    */
    public ArrayList<Integer> toIntegerList(ArrayList<String> input){
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String numberString : input) {
            Integer number = Integer.parseInt(numberString);
            numbers.add(number);
        }
        return numbers;
    }


}
