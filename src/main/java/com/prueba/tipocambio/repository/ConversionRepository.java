package com.prueba.tipocambio.repository;


import com.prueba.tipocambio.domain.model.ConversionRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class ConversionRepository {
    private List<ConversionRecord> conversions = new ArrayList<>();

    public void save(ConversionRequest request, double convertedAmount, double exchangeRate) {
        ConversionRecord record = new ConversionRecord(
                request.getMonto(),
                convertedAmount,
                request.getMonedaOrigen(),
                request.getMonedaDestino(),
                exchangeRate
        );
        conversions.add(record);
    }

    public List<ConversionRecord> getAllConversions() {
        return conversions;
    }
}
