package com.exchangerate.api.validation;

import com.exchangerate.api.dto.LatestRequestDTO;
import com.exchangerate.api.exception.ValidationException;
import org.springframework.util.StringUtils;

/**
 * @author yusufaltun
 */

public class LatestDTOValidator implements Validator<LatestRequestDTO>
{
    @Override
    public void validate(LatestRequestDTO dto)
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
