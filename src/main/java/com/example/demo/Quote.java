package com.example.demo;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Quote {

    @Size(max = 35)
    private String quote;

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
