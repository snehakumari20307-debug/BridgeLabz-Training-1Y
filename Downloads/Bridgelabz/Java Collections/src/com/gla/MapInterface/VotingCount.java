package com.gla.MapInterface;
import java.util.*;

public class VotingCount {

    private Map<String, Integer> votes = new HashMap<>();

    // Cast a vote
    public void castVote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        System.out.println("Vote casted for: " + candidate);
    }

    // Print all vote counts
    public void printResults() {
        System.out.println("\n--- Election Results ---");

        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    // Find winner
    public void findWinner() {
        String winner = null;
        int maxVotes = 0;

        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        System.out.println("\n🏆 Winner: " + winner + " with " + maxVotes + " votes");
    }

    public static void main(String[] args) {
        VotingCount election = new VotingCount();

        // Simulating 10 votes for 3 candidates
        String[] simulatedVotes = {
                "Amit", "Riya", "Rahul", "Amit", "Riya",
                "Amit", "Neha", "Rahul", "Amit", "Riya"
        };

        for (String vote : simulatedVotes) {
            election.castVote(vote);
        }

        // Show results
        election.printResults();

        // Find winner
        election.findWinner();
    }
}

