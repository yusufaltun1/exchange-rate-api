package com.exchangerate.api.service;

import com.exchangerate.api.dto.BaseDTO;
import com.exchangerate.api.dto.CalculateRequestDTO;
import com.exchangerate.api.dto.HistoricalRequestDTO;
import com.exchangerate.api.dto.LatestRequestDTO;
import com.exchangerate.api.validation.CalculateDTOValidator;
import com.exchangerate.api.validation.HistoricalDTOValidator;
import com.exchangerate.api.validation.LatestDTOValidator;
import com.exchangerate.api.validation.Validator;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author yusufaltun
 */

@Service
public class ValidationService
{
    private HashMap<Class<? extends BaseDTO>, Validator> validators = new HashMap<>();

    {
        validators.put( LatestRequestDTO.class, new LatestDTOValidator());
        validators.put( HistoricalRequestDTO.class, new HistoricalDTOValidator());
        validators.put( CalculateRequestDTO.class, new CalculateDTOValidator());
    }

    public void validate(BaseDTO dto)
    {
        validators.get(dto.getClass()).validate(dto);
    }
}
