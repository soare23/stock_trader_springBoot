package stock_trader_spring.model;

public class Stock {
    private String symbol;
    private int price;

    public Stock() {
    }

    public Stock(String symbol, int price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String name) {
        this.symbol = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
