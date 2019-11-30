package com.exchangerate.api.validation;

import com.exchangerate.api.dto.CalculateRequestDTO;
import com.exchangerate.api.exception.ValidationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author yusufaltun
 */
@Component
public class CalculateDTOValidator implements Validator<CalculateRequestDTO>
{
    @Override
    public void validate(CalculateRequestDTO dto)
    {
        if(StringUtils.isEmpty(dto.getFrom()))
        {
            throw new ValidationException("From paramater must not be null");
        }
        if(StringUtils.isEmpty(dto.getTo()))
        {
            throw new ValidationException("To Parameter must not be null");
        }
    }
}
