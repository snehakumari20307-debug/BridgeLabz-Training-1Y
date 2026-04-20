package com.gla.StreamAPI;
import java.util.*;

public class StockPriceLogger {
    public static void main(String[] args) {
        // Simulating a live feed of stock updates
        Map<String, Double> liveStockFeed = new LinkedHashMap<>();
        liveStockFeed.put("AAPL", 175.40);
        liveStockFeed.put("TSLA", 202.15);
        liveStockFeed.put("GOOGL", 142.80);
        liveStockFeed.put("MSFT", 405.60);
        liveStockFeed.put("NVDA", 875.25);

        System.out.println("--- Live Stock Price Feed ---");

        // Using forEach with a BiConsumer lambda (Key, Value)
        liveStockFeed.forEach((ticker, price) ->
                System.out.printf("TICKER: %-6s | PRICE: $%,.2f%n", ticker, price));
    }
}
