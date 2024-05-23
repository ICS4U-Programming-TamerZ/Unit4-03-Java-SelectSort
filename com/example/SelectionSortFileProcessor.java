package com.example;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This program reads lines from an input file, sorts each line using the Selection Sort algorithm,
 * and writes the sorted lines to an output file.
 *
 * Developed by: Tamer Zreg
 */
public class SelectionSortFileProcessor {

    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            // Read each line from the input file
            while ((line = reader.readLine()) != null) {
                // Sort the line using Selection Sort algorithm
                String sortedLine = sortLineUsingSelectionSort(line);
                // Write the sorted line to the output file
                writer.write(sortedLine);
                writer.newLine();
            }

            System.out.println("Processing complete. Output written to " + outputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sorts a line of space-separated numbers using Selection Sort algorithm.
     *
     * @param line the line of numbers to be sorted
     * @return the sorted line of numbers
     */
    private static String sortLineUsingSelectionSort(String line) {
        String[] numbers = line.split("\\s+");  // Split the line into an array of numbers
        int n = numbers.length;

        // Perform Selection Sort on the array of numbers
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (numbers[j].compareTo(numbers[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            String temp = numbers[minIndex];
            numbers[minIndex] = numbers[i];
            numbers[i] = temp;
        }

        return String.join(" ", numbers);  // Join the sorted numbers back into a single string
    }
}
