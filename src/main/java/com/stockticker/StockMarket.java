package com.stockticker;

import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class StockMarket {
    private List<Stock> stocks;

    public StockMarket(List<Stock> stocks) {
        this.stocks = stocks;
    }

    // Getter method for stocks
    public List<Stock> getStocks() {
        return stocks;
    }

    public void startTicker() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (Stock stock : stocks) {
                    stock.updatePrice();
                    System.out.println(stock.getSymbol() + ": $" + stock.getPrice());
                }
                System.out.println("----------");
            }
        }, 0, 2000); // Updates every 2 seconds
    }

    // Main method for terminal-based ticker
    public static void main(String[] args) {
        // Initialize some sample stocks
        List<Stock> stocks = Arrays.asList(
                new Stock("AAPL", 150.0),
                new Stock("GOOG", 2800.0),
                new Stock("AMZN", 3400.0)
        );

        // Create StockMarket and start ticker
        StockMarket stockMarket = new StockMarket(stocks);
        stockMarket.startTicker();


    }
}
