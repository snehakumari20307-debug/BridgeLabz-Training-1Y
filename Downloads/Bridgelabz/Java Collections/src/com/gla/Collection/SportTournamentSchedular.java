package com.gla.Collection;
import java.util.*;

public class SportTournamentSchedular {

    // ===== Data Models =====
    static class Team {
        String name;
        int points;

        Team(String name) {
            this.name = name;
            this.points = 0;
        }

        @Override
        public String toString() {
            return name + " | Points: " + points;
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Team)) return false;
            return this.name.equals(((Team) obj).name);
        }
    }

    static class Match {
        Team a, b;

        Match(Team a, Team b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return a.name + " vs " + b.name;
        }
    }

    static class Result {
        Match match;
        Team winner;

        Result(Match match, Team winner) {
            this.match = match;
            this.winner = winner;
        }

        @Override
        public String toString() {
            return match + " -> Winner: " + winner.name;
        }
    }

    // ===== Collections =====
    private Set<Team> teams = new HashSet<>();
    private Queue<Match> matchQueue = new LinkedList<>();
    private List<Result> results = new ArrayList<>();

    // TreeSet for leaderboard (sorted by points DESC)
    private TreeSet<Team> leaderboard = new TreeSet<>(
            (t1, t2) -> {
                if (t2.points != t1.points)
                    return t2.points - t1.points;
                return t1.name.compareTo(t2.name);
            }
    );

    // ===== 1. Register Team =====
    public void registerTeam(String name) {
        Team t = new Team(name);

        if (teams.add(t)) {
            leaderboard.add(t);
            System.out.println("Team registered: " + name);
        } else {
            System.out.println("Duplicate team ignored: " + name);
        }
    }

    // Helper to find team by name
    private Team findTeam(String name) {
        for (Team t : teams) {
            if (t.name.equals(name)) return t;
        }
        return null;
    }

    // ===== 2. Schedule Match =====
    public void scheduleMatch(String a, String b) {
        Team t1 = findTeam(a);
        Team t2 = findTeam(b);

        if (t1 == null || t2 == null) {
            System.out.println("Teams not found.");
            return;
        }

        matchQueue.add(new Match(t1, t2));
        System.out.println("Match scheduled: " + a + " vs " + b);
    }

    // ===== 3. Process Match =====
    public void processMatch(String winnerName) {

        if (matchQueue.isEmpty()) {
            System.out.println("No matches to process.");
            return;
        }

        Match m = matchQueue.poll();

        Team winner = null;

        if (m.a.name.equals(winnerName)) winner = m.a;
        else if (m.b.name.equals(winnerName)) winner = m.b;
        else {
            System.out.println("Invalid winner.");
            return;
        }

        // Update points
        winner.points += 2;

        // Update leaderboard (reinsert for sorting update)
        leaderboard.remove(m.a);
        leaderboard.remove(m.b);

        leaderboard.add(m.a);
        leaderboard.add(m.b);

        // Store result
        results.add(new Result(m, winner));

        System.out.println("Match completed: " + m + " Winner: " + winner.name);
    }

    // ===== 4. Show Leaderboard =====
    public void showLeaderboard() {
        System.out.println("\nLeaderboard:");
        for (Team t : leaderboard) {
            System.out.println(t);
        }
    }

    // ===== 5. Show Results =====
    public void showResults() {
        System.out.println("\nMatch Results:");
        for (Result r : results) {
            System.out.println(r);
        }
    }

    // ===== MAIN METHOD =====
    public static void main(String[] args) {

        SportTournamentSchedular system = new SportTournamentSchedular();

        system.registerTeam("India");
        system.registerTeam("Australia");
        system.registerTeam("England");
        system.registerTeam("India"); // duplicate

        system.scheduleMatch("India", "Australia");
        system.scheduleMatch("Australia", "England");

        system.processMatch("India");
        system.processMatch("England");

        system.showResults();
        system.showLeaderboard();
    }
}

