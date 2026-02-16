import java.io.*;
import java.util.*;

public class Earthquake {
    public static void main(String[] args) {
        String filename = "yourfile.dat";
        System.out.println("Trying to read: " + filename);
        System.out.println("Working folder: " + new File(".").getAbsolutePath());
    
        List<String> lines = readDatFile(filename);
        System.out.println("Lines read: " + lines.size());
    
        for (String line : lines) {
            System.out.println("LINE: [" + line + "]");
            System.out.println("Most frequent: " + mostFrequentMagnitude(line));
        }
    }

    public static String mostFrequentMagnitude(String line) {
        // Map: key = magnitude as text like "3.5", value = how many times it appears
        Map<String, Integer> freq = new HashMap<>();
    
        // Split the line into tokens wherever there are spaces/tabs (whitespace)
        String[] parts = line.trim().split(" ");
    
        // Count each magnitude
        for (String p : parts) {
            freq.put(p, freq.getOrDefault(p, 0) + 1);
        }
    
        // Track the magnitude with the highest count
        String bestMag = "";
        int bestCount = -1;
    
        // Find the entry with the biggest count
        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            String mag = e.getKey();
            int count = e.getValue();
    
            if (count > bestCount) {
                bestCount = count;
                bestMag = mag;
            } else if (count == bestCount) {
                // Tie-break: pick the smaller magnitude number
                if (Double.parseDouble(mag) < Double.parseDouble(bestMag)) {
                    bestMag = mag;
                }
            }
        }
    
        return bestMag;
    }


    public static List<String> readDatFile(String filename) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("There was an error in readDatFile(): " + e.getMessage());
            e.printStackTrace();
        }
        return lines;
    }
}