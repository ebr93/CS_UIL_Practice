import java.io.*;
import java.util.*;

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

        return returnStr;
    }

    public static List<String> readDatFile(String filename) 
    {
        List<String> lines = new ArrayList<>();
    
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) 
        {
            String line;
            int count = 0;
    
            while ((line = reader.readLine()) != null) 
            {
                lines.add(line);
                count++;
            }
        } catch (IOException e) {
            System.err.println("readDatFile error: " + e.getMessage());
        }
        return lines;
    }
}