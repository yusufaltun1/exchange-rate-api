package com.exchangerate.api.controller;

import com.exchangerate.api.dto.*;
import com.exchangerate.api.exception.ValidationException;
import com.exchangerate.api.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author yusufaltun
 */

@RestController
@RequestMapping("/api")
public class ExchangeRateController
{
    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping("/latest/{from}/{to}")
    public ResponseEntity<LatestResponseDTO> getLatest(@PathVariable String from, @PathVariable String to)
    {
        LatestResponseDTO dto = (LatestResponseDTO) exchangeRateService.makeRequest(LatestRequestDTO.of(from, to));
        return ResponseEntity.of(Optional.of(dto));
    }

    @GetMapping("/historical/{from}/{to}/{date}")
    public ResponseEntity<HistoricalResponseDTO> getHistorical(@PathVariable String from, @PathVariable String to, @PathVariable String date)
    {
        HistoricalResponseDTO dto = (HistoricalResponseDTO) exchangeRateService.makeRequest(HistoricalRequestDTO.of(from, to, date));
        return ResponseEntity.of(Optional.of(dto));
    }
    @GetMapping("/calc/{from}/{to}/{amount}")
    public ResponseEntity<CalculateResponseDTO> getCalculated(@PathVariable String from, @PathVariable String to, @PathVariable String amount)
    {
        double amountOfDouble = 0d;

        try {
            amountOfDouble = Double.parseDouble(amount);
        }catch (Exception e)
        {
            throw new ValidationException("Amount must be double");
        }
        CalculateResponseDTO dto = (CalculateResponseDTO) exchangeRateService.makeRequest(CalculateRequestDTO.of(from, to,"", amountOfDouble));
        return ResponseEntity.of(Optional.of(dto));
    }
}
