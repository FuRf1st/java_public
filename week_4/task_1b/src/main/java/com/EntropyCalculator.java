package com;

public class EntropyCalculator {

    public static double calculateEntropy(String input) {
        String sanitizedInput = input.replaceAll("\\s+", "");

        if (sanitizedInput.isEmpty()) {
            return 0.0;
        }

        int[] frequency = new int[256]; 
        int totalCharacters = sanitizedInput.length();

        for (char c : sanitizedInput.toCharArray()) {
            frequency[c]++;
        }

        double entropy = 0.0;

        for (int freq : frequency) {
            if (freq > 0) {
                double probability = (double) freq / totalCharacters;
                entropy -= probability * (Math.log(probability) / Math.log(2));
            }
        }

        return entropy;
    }
}
