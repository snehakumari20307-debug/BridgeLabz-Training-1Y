package com.gla.wrapperclasses;
public class GameScoreboard {

    public static void main(String[] args) {

        // Array of player scores (Integer objects)
        Integer[] scores = {50, null, 75, 100, null, 30};

        int notPlayedCount = 0;
        int totalScore = 0;

        for (Integer score : scores) {
            if (score == null) {
                notPlayedCount++; // Count players who haven't played
            } else {
                totalScore += score; // Auto-unboxing Integer -> int
            }
        }

        System.out.println("Number of players who haven't played: " + notPlayedCount);
        System.out.println("Total of valid scores: " + totalScore);
    }
}

