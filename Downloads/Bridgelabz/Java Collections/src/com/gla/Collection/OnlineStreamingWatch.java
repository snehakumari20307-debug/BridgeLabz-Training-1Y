package com.gla.Collection;
import java.util.*;
class Movie {
    String title;
    String genre;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return title + " (" + genre + ")";
    }
}


 class StreamingSystem {

    // All available movies
    private List<Movie> allMovies = new ArrayList<>();

    // Recently watched (history)
    private Stack<Movie> watchHistory = new Stack<>();

    // Unique genres watched
    private Set<String> genreSet = new HashSet<>();

    // Up next queue
    private Queue<Movie> upNextQueue = new LinkedList<>();

    // Recommended list (derived)
    private List<Movie> recommendations = new ArrayList<>();

    // -------------------------------
    // 1. Add Movie to Library
    // -------------------------------
    public void addMovie(String title, String genre) {
        allMovies.add(new Movie(title, genre));
    }

    // -------------------------------
    // Add to "Up Next"
    // -------------------------------
    public void addToUpNext(Movie m) {
        upNextQueue.add(m);
        System.out.println("Added to Up Next: " + m);
    }

    // -------------------------------
    // 2. Watch Next Movie
    // -------------------------------
    public void watchNext() {
        if (upNextQueue.isEmpty()) {
            System.out.println("No movies in Up Next.");
            return;
        }

        Movie current = upNextQueue.poll();
        System.out.println("Watching: " + current);

        // Move to history stack
        watchHistory.push(current);

        // Track genre
        genreSet.add(current.genre);
    }

    // -------------------------------
    // 3. Show Watch History
    // -------------------------------
    public void showHistory() {
        System.out.println("\nWatch History:");
        for (Movie m : watchHistory) {
            System.out.println(m);
        }
    }

    // -------------------------------
    // 4. Generate Recommendations
    // -------------------------------
    public void generateRecommendations() {
        recommendations.clear();

        for (Movie m : allMovies) {
            if (genreSet.contains(m.genre) && !watchHistory.contains(m)) {
                recommendations.add(m);
            }
        }

        System.out.println("\nRecommended Movies:");
        for (Movie m : recommendations) {
            System.out.println(m);
        }
    }
}
public class OnlineStreamingWatch{
    public static void main(String[] args) {

        StreamingSystem system = new StreamingSystem();

        // Add movies to library
        system.addMovie("Inception", "Sci-Fi");
        system.addMovie("Interstellar", "Sci-Fi");
        system.addMovie("Titanic", "Romance");
        system.addMovie("The Notebook", "Romance");
        system.addMovie("Avengers", "Action");

        // Add to Up Next queue
        system.addToUpNext(new Movie("Inception", "Sci-Fi"));
        system.addToUpNext(new Movie("Titanic", "Romance"));
        system.addToUpNext(new Movie("Avengers", "Action"));

        // Watch movies
        system.watchNext();
        system.watchNext();

        // History
        system.showHistory();

        // Recommendations based on watched genres
        system.generateRecommendations();
    }
}
