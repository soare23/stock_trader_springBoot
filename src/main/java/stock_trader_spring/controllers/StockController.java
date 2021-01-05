package stock_trader_spring.controllers;
import org.springframework.web.client.RestTemplate;
import stock_trader_spring.model.Stock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class StockController {

    private String apiPath = "https://run.mocky.io/v3/9e14e086-84c2-4f98-9e36-54928830c980?stock=%s";


    @GetMapping("/buy/{stock}/{price}")
    public String buyStockAtPrice(@PathVariable("stock") String stock,@PathVariable("price") int price) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(apiPath, stock);
        Stock response = restTemplate.getForObject(url, Stock.class);
        if(response.getSymbol().contains(stock.toUpperCase())){
            if(price >= response.getPrice()){
                return response.getSymbol() + " was bought at " + response.getPrice();
            } else {
                return "Bid for " + response.getSymbol() + " was $" + price + " but the stock price is $" + response.getPrice() + ", no purchase was made.";
            }
        } else {
            return "Symbol does not exists";
        }

    }
}
