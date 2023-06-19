package com.example.JavaColloquium.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

// DTO отвечающий за валюту
public class CurrencyDto {
    @NotBlank(message = "Cannot be blank")
    private String name;
    @Min(value = 0, message = "Should be a positive number")
    private BigDecimal rate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
