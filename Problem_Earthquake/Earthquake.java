package Problem_Earthquake;

import java.io.*;
import java.util.*;
import java.util.stream.*;    // Required for Stream and Collectors
import java.nio.file.*;  

public class Earthquake {
    public static void main(String[] args) {
        String filename = "yourfile.dat";
        List<String> lines = readDatFile(filename);
        System.out.println("Lines read: " + lines.size());
    
        for (int i = 1; i < lines.size(); i++) {
            System.out.println("LINE: [" + lines.get(i) + "]");
            System.out.println("Most frequent: " + mostFrequentMagnitude(lines.get(i)));
        }
    }

    public static String mostFrequentMagnitude(String line) {
        // Map: key = magnitude as text like "3.5", value = how many times it appears
        Map<String, Integer> freq = new HashMap<>();
    
        // Split the line into elements wherever there are (whitespace)
        String[] parts = line.trim().split(" ");
    
        // Add new magnitude to start count or add +1 one already in map
        for (String p : parts) {
            freq.put(p, freq.getOrDefault(p, 0) + 1);
        }

        // Variables to Track the magnitude with the highest count
        String bestMag = "";
        int bestCount = -1;
        // Iterate to find the entry with the biggest count
        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            String magnitude = e.getKey();
            int count = e.getValue();
    
            if (count > bestCount) {
                bestCount = count;
                bestMag = magnitude;
            }
        }
    
        return bestMag;
    }


    public static List<String> readDatFile(String filename) {
        // Use try-with-resources to ensure the file stream is closed
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            return stream.collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("readDatFile error: " + e.getMessage());
            return List.of(); // Return empty list instead of null for safety
        }
    }
}