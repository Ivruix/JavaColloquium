package com.example.JavaColloquium.repository;

import com.example.JavaColloquium.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Репозиторий валют
@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Optional<Currency> findCurrencyByName(String name);
}
