package org.example;

public class StockInfo {
    private  final  String  ticker;
    private final  double price;

    public StockInfo(final String ticker, final double price){
        this.ticker = ticker;
        this.price = price;
    }

    public String toString(){
        return String.format("ticker : %s, price: %g ",ticker,price);
    }
}
