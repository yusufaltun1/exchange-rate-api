package com.exchangerate.api.validation;

import com.exchangerate.api.dto.HistoricalRequestDTO;
import com.exchangerate.api.exception.ValidationException;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author yusufaltun
 */

public class HistoricalDTOValidator implements Validator<HistoricalRequestDTO>
{
    @Override
    public void validate(HistoricalRequestDTO dto)
    {
        if(dto.getDate() == null || !isValidDate(dto.getDate()))
        {
            throw new ValidationException("Date must not be null or format is yyyy-MM-dd");
        }
        if(StringUtils.isEmpty(dto.getFrom()))
        {
            throw new ValidationException("From paramater must not be null");
        }
        if(StringUtils.isEmpty(dto.getTo()))
        {
            throw new ValidationException("To Parameter must not be null");
        }
    }

    boolean isValidDate(String input) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            format.parse(input);
        } catch (ParseException e) {
            return false;
        }
        return true;

    }
}
