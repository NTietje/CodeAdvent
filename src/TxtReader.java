import java.io.*;
import java.util.ArrayList;
/*
 * reader for txt files
 *
 * @author Nina Tietje
 */
public class TxtReader extends Reader{

    /*
     * reads the txt file with an BufferedReader and FileReader
     *
     * @param filepath      input location with .txt ending
     * @return text         reading input, as ArrayList
     * */
    @Override
    ArrayList<String> read(String filepath) {
        ArrayList<String> text = new ArrayList<>();
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader(filepath));
            String currentLine;
            while ((currentLine = bufReader.readLine()) != null) {
                text.add(currentLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Reading error");
            e.printStackTrace();
        }
        return text;
    }

    @Override
    public ArrayList<Integer> toIntegerList(ArrayList<String> input) {
        return super.toIntegerList(input);
    }
}
