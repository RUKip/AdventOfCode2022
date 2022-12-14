import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Challenge1 {

    /**
     * Returns number of the highest amount of calories
     *
     * @return int
     */
    public int solve() {
        File myObj = new File("src/input.txt");
        Scanner myReader;
        try {
            myReader = new Scanner(myObj);

            int highest_calories = 0;
            int total_calories = 0;
            while (myReader.hasNextLine()) {
                String calory_string = myReader.nextLine();
                if (calory_string.isEmpty()) {
                    if (total_calories > highest_calories) {
                        highest_calories = total_calories;
                    }
                    total_calories = 0;
                } else {
                    int calories = Integer.parseInt(calory_string);
                    total_calories += calories;
                }
            }
            myReader.close();
            return highest_calories;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int solvePart2() {
        File myObj = new File("src/input.txt");
        Scanner myReader;
        try {
            myReader = new Scanner(myObj);

            int total_calories = 0;
            int elf = 1;
            HashMap<Integer, Integer> calories_per_elf = new HashMap<Integer, Integer>();
            while (myReader.hasNextLine()) {
                String calory_string = myReader.nextLine();
                if (calory_string.isEmpty()) {
                    calories_per_elf.put(elf, total_calories);
                    total_calories = 0;
                    elf++;
                } else {
                    int calories = Integer.parseInt(calory_string);
                    total_calories += calories;
                }
            }
            myReader.close();
            int highest_3 = calories_per_elf
                    .values()
                    .stream()
                    .sorted(Comparator.reverseOrder())
                    .limit(3)
                    .reduce(0, Integer::sum);
            return highest_3;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
