package com.wajahat.stock.service.stockservice.controller;

import com.wajahat.stock.service.stockservice.domain.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * stock-service - Controller
 *
 * @author Wajahat Siddiqui
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String DB_SERVICE = "http://db-service/stock/quotes/";

    @GetMapping("/{userName}")
    public ResponseEntity<List<Quote>> getStocks(@PathVariable("userName") String userName) throws IOException {
        ResponseEntity<List<String>> responseEntity = restTemplate.exchange(DB_SERVICE+userName, HttpMethod.GET
                , null, new ParameterizedTypeReference<List<String>>() {});
        List<String> quotes = responseEntity.getBody();
        return ResponseEntity.ok(quotes.stream()
                .map(q -> Quote.builder().name(q).price(getStockPrice(q)).build())
                .collect(Collectors.toList()));
    }

    private BigDecimal getStockPrice(String quote) {
        Stock stock = getStock(quote);
        return stock.getQuote() == null ? BigDecimal.valueOf(0) : stock.getQuote().getPrice();
    }

    private Stock getStock(String quote) {
        /*try {
            return YahooFinance.get(quote);
        } catch (IOException e) {
            return new Stock(quote);
        }*/
        return new Stock(quote);
    }
}
