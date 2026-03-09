import java.io.*;
import java.util.*;
import java.nio.file.*; 

public class Repetition {
    public static void main(String[] args)
    {
        
    }

    public static String removeRepeatedLetter(String row)
    {
        StringBuilder returnStr;
        String[] letters = row.split("");
        for (int i = 1; i < letters.length; i++)
        {
            if (i)
        }

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