package com.prueba.tipocambio.controller;

import com.prueba.tipocambio.domain.model.ConversionRequest;
import com.prueba.tipocambio.domain.model.ConversionResponse;
import com.prueba.tipocambio.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ConversionController {
    @Autowired
    private ConversionService conversionService;

    @PostMapping("/convert")
    public ResponseEntity<ConversionResponse> convert(@RequestBody ConversionRequest request) {
        ConversionResponse response = conversionService.applyConversion(request);
        return ResponseEntity.ok(response);
    }
}
