package com.stockticker;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StockTickerGUI extends JFrame {
    private JTable table;
    private StockMarket stockMarket;
    private StockTableModel tableModel;

    public StockTickerGUI(StockMarket stockMarket) {
        this.stockMarket = stockMarket;
        this.tableModel = new StockTableModel(stockMarket.getStocks());

        setTitle("Stock Ticker");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Update GUI every 2 seconds
        new Timer(2000, e -> refreshTable()).start();
    }

    private void refreshTable() {
        tableModel.fireTableDataChanged();
    }

    public static void main(String[] args) {
        // Initialize some sample stocks
        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("AAPL", 150.0));
        stocks.add(new Stock("GOOGL", 2800.0));
        stocks.add(new Stock("AMZN", 3300.0));

        // Create the stock market and GUI
        StockMarket stockMarket = new StockMarket(stocks);
        SwingUtilities.invokeLater(() -> {
            StockTickerGUI gui = new StockTickerGUI(stockMarket);
            gui.setVisible(true);
        });

        // Start the ticker in a background thread
        new Thread(stockMarket::startTicker).start();
    }
}
