package com.example.JavaColloquium.service;

import com.example.JavaColloquium.dto.CurrencyDto;
import com.example.JavaColloquium.dto.ExchangeDto;
import com.example.JavaColloquium.exception.InvalidIdException;
import com.example.JavaColloquium.exception.InvalidNameException;
import com.example.JavaColloquium.model.Currency;
import com.example.JavaColloquium.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyExchangeService {
    private final CurrencyRepository currencyRepository;

    public CurrencyExchangeService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    // Добавляет новую валюту
    public void addCurrency(CurrencyDto currencyDto) {
        Currency currency = new Currency();

        currency.setName(currencyDto.getName());
        currency.setRate(currencyDto.getRate());

        currencyRepository.save(currency);
    }

    // Возвращает все валюты
    public List<CurrencyDto> getCurrencies() {
        List<CurrencyDto> currencies = new ArrayList<>();

        for (Currency currency : currencyRepository.findAll()) {
            CurrencyDto currencyDto = new CurrencyDto();

            currencyDto.setName(currency.getName());
            currencyDto.setRate(currency.getRate());

            currencies.add(currencyDto);
        }

        return currencies;
    }

    // Возвращает валюту по id
    public CurrencyDto getCurrency(Long id) throws InvalidIdException {
        Currency currency = currencyRepository.findById(id).orElseThrow(
                () -> new InvalidIdException("Invalid id."));

        CurrencyDto currencyDto = new CurrencyDto();

        currencyDto.setName(currency.getName());
        currencyDto.setRate(currency.getRate());

        return currencyDto;
    }

    // Обновляет валюту по id
    public void updateCurrency(Long id, CurrencyDto currencyDto) throws InvalidIdException {
        Currency currency = currencyRepository.findById(id).orElseThrow(
                () -> new InvalidIdException("Invalid id."));

        currency.setName(currencyDto.getName());
        currency.setRate(currencyDto.getRate());

        currencyRepository.save(currency);
    }

    // Удаляет валюту по id
    public void deleteCurrency(Long id) throws InvalidIdException {
        Currency currency = currencyRepository.findById(id).orElseThrow(
                () -> new InvalidIdException("Invalid id."));

        currencyRepository.delete(currency);
    }

    // Вычисляет обмен валют
    public BigDecimal exchange(ExchangeDto exchangeDto) throws InvalidNameException {
        Currency currencyFrom = currencyRepository.findCurrencyByName(exchangeDto.getFrom()).orElseThrow(
                () -> new InvalidNameException("Invalid currency name."));
        Currency currencyTo = currencyRepository.findCurrencyByName(exchangeDto.getTo()).orElseThrow(
                () -> new InvalidNameException("Invalid currency name."));

        BigDecimal amount = exchangeDto.getAmount();

        return amount.multiply(currencyFrom.getRate()).divide(currencyTo.getRate(), 2, RoundingMode.DOWN);
    }
}
