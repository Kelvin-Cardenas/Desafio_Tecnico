package com.prueba.tipocambio.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConversionRecord {
    private double amount;
    private double convertedAmount;
    private String sourceCurrency;
    private String targetCurrency;
    private double exchangeRate;


}
