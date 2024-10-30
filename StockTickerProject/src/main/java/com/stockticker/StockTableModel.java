package com.stockticker;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class StockTableModel extends AbstractTableModel {
    private List<Stock> stocks;
    private final String[] columnNames = {"Symbol", "Price"};

    public StockTableModel(List<Stock> stocks) {
        this.stocks = stocks;
    }

    @Override
    public int getRowCount() {
        return stocks.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Stock stock = stocks.get(rowIndex);
        switch (columnIndex) {
            case 0: return stock.getSymbol();
            case 1: return String.format("$%.2f", stock.getPrice());
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
