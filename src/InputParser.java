import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputParser {

    public ArrayList<ArrayList<Integer>> parseAs2DMatrix(String input_file) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        File myObj = new File(input_file);
        Scanner myReader;
        try {
            myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String input = myReader.nextLine();
                ArrayList<Integer> result = input.chars()
                        .map(character -> Integer.parseInt(Character.toString((char) character)))
                        .boxed()
                        .collect(Collectors.toCollection(ArrayList::new));

                matrix.add(result);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return matrix;
    }
}
