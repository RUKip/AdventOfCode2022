import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Challenge2 {

    public int solve()
    {
        File myObj = new File("src/input2.txt");
        Scanner myReader;
        int total_sum = 0;
        try {
            myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String hand = myReader.nextLine();
                total_sum += this.calculateScore(hand);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return total_sum;
    }

    public int solvePart2()
    {
        File myObj = new File("src/input2.txt");
        Scanner myReader;
        int total_sum = 0;
        try {
            myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String hand = myReader.nextLine();
                total_sum += this.calculateScorePart2(hand);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return total_sum;
    }

    private int calculateScore(String input) {
        switch (input) {
            case "A X":
                return 3 + 1;
            case "A Y":
                return 6 + 2;
            case "A Z":
                return 0 + 3;
            case "B X":
                return 0 + 1;
            case "B Y":
                return 3 + 2;
            case "B Z":
                return 6 + 3;
            case "C X":
                return 6 + 1;
            case "C Y":
                return 0 + 2;
            case "C Z":
                return 3 + 3;
            default:
                throw new RuntimeException("Could not match input");
        }
    }

    private int calculateScorePart2(String input) {
        switch (input) {
            case "A X":
                return 3 + 0;
            case "A Y":
                return 1 + 3;
            case "A Z":
                return 2 + 6;
            case "B X":
                return 1 + 0;
            case "B Y":
                return 2 + 3;
            case "B Z":
                return 3 + 6;
            case "C X":
                return 2 + 0;
            case "C Y":
                return 3 + 3;
            case "C Z":
                return 1 + 6;
            default:
                throw new RuntimeException("Could not match input");
        }
    }

}
