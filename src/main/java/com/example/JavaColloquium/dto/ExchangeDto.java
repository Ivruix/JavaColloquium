package com.example.JavaColloquium.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

// DTO отвечающий за обмен валютами
public class ExchangeDto {
    @NotBlank(message = "Cannot be blank")
    private String from;
    @NotBlank(message = "Cannot be blank")
    private String to;
    @Min(value = 0, message = "Should be a positive number")
    private BigDecimal amount;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
