package com.stockticker;

public class Stock {
    private final String symbol;
    private double price;
    public Stock(String symbol, double initialPrice) {
        this.symbol = symbol;
        this.price = initialPrice;
    }
    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
    public void updatePrice() { this.price += (Math.random() - 0.5) * 5; }
}