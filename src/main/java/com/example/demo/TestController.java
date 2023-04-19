package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    private int id = 5;
    private Map<Integer, String> quotes = new HashMap<>();

    {
        quotes.put(0, "Ті, що сплять, не роблять помилок.");
        quotes.put(1, "Дія не завжди приведе до щастя, але до щастя привести може лише дія.");
        quotes.put(2, "Досконалість – це не тоді, коли не має чого додати, а тоді, коли нема чого забрати.");
        quotes.put(3, "Є багато речей, на які розумна людина не хотіла б звертати уваги.");
        quotes.put(4, "У світі не має обмежень крім тих, яки ти сам для себе встановлюєш.");
    }
    @GetMapping("/quote")
    public String getQuote(HttpServletRequest httpServletRequest) {
        var id = Integer.parseInt(httpServletRequest.getParameter("id"));
        return quotes.get(id);
    }
    // http://localhost:8080/quote?id=2

    @GetMapping("/quoteX")
    public String getQuote(@RequestParam Integer id) {
        return quotes.get(id);
    }
    // http://localhost:8080/quoteX?id=3

    @GetMapping("/quote/{id}")
    public String getMyQuote(@PathVariable Integer id) {
        return quotes.get(id);
    }
    // http://localhost:8080/quote/4

    @GetMapping("/quotes")
    public Map<Integer, String> getQuotes() {
        return quotes;
    }
    // http://localhost:8080/quotes

    @GetMapping("/quotesX")
    public Collection<String> getMyQuotes() {
        return quotes.values();
    }
    // http://localhost:8080/quotesX

    @PostMapping("/quotes")
    public void postQuote(@RequestBody Quote quote) {
        quotes.put(id++, quote.getQuote());
    }
    // http://localhost:8080/quotes   {"quote": "My new quote"}

    @PostMapping("/quotesX")
    public ResourceIdHolder postMyQuote(@RequestBody @Validated Quote quote) {
        var response = new ResourceIdHolder(id++);
        quotes.put(response.getId(), quote.getQuote());
        return response;
    }
    // http://localhost:8080/quotesX   {"quote": "My new quote"}

    @DeleteMapping("/quote/{id}")
    public void deleteQuote(@PathVariable Integer id) {
        quotes.remove(id);
    }
    // http://localhost:8080/quote/1

    @PutMapping("/quote/{id}")
    public void putQuote(@PathVariable Integer id, @RequestBody Quote quote) {
        quotes.put(id, quote.getQuote());
    }
    // http://localhost:8080/quote/0   {"quote": "My new quote"}
}

