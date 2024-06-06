package com.prueba.tipocambio.client;

import com.prueba.tipocambio.domain.model.ExchangeRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "exchange-client", url = "https://open.er-api.com/v6")
public interface ExchangeClient {
    @GetMapping("/latest/USD")
    ExchangeRateResponse getExchangeRates();
}