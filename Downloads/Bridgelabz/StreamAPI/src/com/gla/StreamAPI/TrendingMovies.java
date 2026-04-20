package com.gla.StreamAPI;
import java.util.*;
import java.util.stream.Collectors;

record Movie(String title, int releaseYear, double rating) {}

public class TrendingMovies {
    public static void main(String[] args) {
        List<Movie> movieList = Arrays.asList(
                new Movie("Interstellar", 2014, 8.7),
                new Movie("Dune: Part Two", 2024, 8.8),
                new Movie("Oppenheimer", 2023, 8.4),
                new Movie("The Godfather", 1972, 9.2),
                new Movie("Spider-Man: Across the Spider-Verse", 2023, 8.6),
                new Movie("Poor Things", 2023, 8.0),
                new Movie("Parasite", 2019, 8.5),
                new Movie("Anatomy of a Fall", 2023, 7.8)
        );

        // Define the current year for filtering
        int currentYear = 2024;

        List<Movie> topTrending = movieList.stream()
                // 1. Filter: Only movies from the last 10 years
                .filter(m -> m.releaseYear() >= (currentYear - 10))
                // 2. Sort: Highest Rating first, then newest Release Year
                .sorted(Comparator.comparing(Movie::rating).reversed()
                        .thenComparing(Comparator.comparing(Movie::releaseYear).reversed()))
                // 3. Limit: Only take the top 5 results
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("--- Top 5 Trending Movies ---");
        topTrending.forEach(m ->
                System.out.println(m.rating() + " | " + m.releaseYear() + " | " + m.title()));
    }
}

