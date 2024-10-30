package com.stockticker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class StockTest {
    @Test public void testPriceUpdate() {
        Stock stock = new Stock("AAPL", 150.0);
        stock.updatePrice();
        assertNotEquals(150.0, stock.getPrice());
    }
}