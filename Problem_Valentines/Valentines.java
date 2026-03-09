package Problem_Valentines;

import java.io.*;
import java.util.*;
import java.nio.file.*;  

public class Valentines {
    public static void main(String[] args)
    {
        List<String> fileRows = readDatFile("valentines_file.dat");
        // skip index 0 because it's just an int
        for (int i = 1; i < fileRows.size(); i++)
        {
            printCost(fileRows.get(i));
        }
    }

    // prints out costs for each costumer
    public static void printCost(String row)
    {
        String[] parts = row.trim().split(" ");

        // indexes of parts are the same due to format: 
        // name  s  m  l purchases
        String name = parts[0];
        // calculate price for each size
        double small = Double.valueOf(parts[1]) * .05;
        double medium = Double.valueOf(parts[2]) * .07;
        double large = Double.valueOf(parts[3]) * .09;
        
        double total = small + medium + large;

        // String format sets up 2 decimal points
        String fTotal = String.format("%.2f", total);
        // ANSWER in desired output
        System.out.println(name + " $" + fTotal);
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

