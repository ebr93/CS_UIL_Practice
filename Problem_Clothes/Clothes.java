package Problem_Clothes;
import java.io.*;
import java.util.*;
import java.nio.file.*;  

public class Clothes {
    public static void main(String[] args) {
        List<String> lines = readDatFile("clothes.dat");
        // skip index 0 as first line is a single digit
        for (int i = 1; i < lines.size(); i++) {
            System.out.println(addNumbers(lines.get(i)));
        }
    }

    // Sums all integer sequences in the string: "a12b3" -> 15
    public static int addNumbers(String sentence) {
        int sum = 0;
        int current = 0;
        boolean inNumber = false;

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            // if c is Digit then we keep forming number within current variable
            // add complete number to sum if Char is not Digit
            if (Character.isDigit(c)) {
                inNumber = true;
                current = current * 10 + (c - '0');
            } else {
                if (inNumber) {
                    sum += current;
                    current = 0;
                    inNumber = false;
                }
            }
        }
        // line ends with a number, we add it to our sum
        if (inNumber) sum += current;

        return sum;
    }

    public static List<String> readDatFile(String filename) {
        try {
            return Files.readAllLines(Path.of(filename));
        } catch (IOException e) {
            System.err.println("readDatFile error: " + e.getMessage());
            return List.of();
        }
    }
}
