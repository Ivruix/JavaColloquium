package com.example.JavaColloquium.controller;

import com.example.JavaColloquium.dto.CurrencyDto;
import com.example.JavaColloquium.dto.ExchangeDto;
import com.example.JavaColloquium.exception.InvalidIdException;
import com.example.JavaColloquium.exception.InvalidNameException;
import com.example.JavaColloquium.service.CurrencyExchangeService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/")
@Validated
public class CurrencyExchangeController {
    private final CurrencyExchangeService currencyExchangeService;

    public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }

    // Метод для получения всех валют
    @GetMapping("/rates")
    public ResponseEntity<List<CurrencyDto>> getCurrency() {
        try {
            List<CurrencyDto> currencies =  currencyExchangeService.getCurrencies();
            return ResponseEntity.ok(currencies);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    // Метод для добавления валюты
    @PostMapping("/rates")
    public ResponseEntity<String> addCurrency(@Validated @RequestBody final CurrencyDto currencyDto) {
        try {
            currencyExchangeService.addCurrency(currencyDto);
            return ResponseEntity.ok("Currency added successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Метод для получения валюты по id
    @GetMapping("/rates/{id}")
    public ResponseEntity<?> getCurrency(@PathVariable("id") final Long id) {
        try {
            CurrencyDto currency =  currencyExchangeService.getCurrency(id);
            return ResponseEntity.ok(currency);
        } catch (InvalidIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Метод для обновления валюты по id
    @PutMapping("/rates/{id}")
    public ResponseEntity<String> updateCurrency(@PathVariable("id") final Long id, @Validated @RequestBody final CurrencyDto currencyDto) {
        try {
            currencyExchangeService.updateCurrency(id, currencyDto);
            return ResponseEntity.ok("Currency updated successfully.");
        } catch (InvalidIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Метод для удаления валюты по id
    @DeleteMapping("/rates/{id}")
    public ResponseEntity<String> deleteCurrency(@PathVariable("id") final Long id) {
        try {
            currencyExchangeService.deleteCurrency(id);
            return ResponseEntity.ok("Currency deleted successfully.");
        } catch (InvalidIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Метод для обмена валюты
    @PostMapping("/exchange")
    public ResponseEntity<?> exchange(@Validated @RequestBody final ExchangeDto exchangeDto) {
        try {
            BigDecimal result = currencyExchangeService.exchange(exchangeDto);
            return ResponseEntity.ok(result);
        } catch (InvalidNameException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

