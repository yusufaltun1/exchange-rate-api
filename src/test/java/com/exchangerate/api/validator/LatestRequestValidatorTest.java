package com.exchangerate.api.validator;

import com.exchangerate.api.dto.LatestRequestDTO;
import com.exchangerate.api.exception.ValidationException;
import com.exchangerate.api.validation.LatestDTOValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yusufaltun
 */

public class LatestRequestValidatorTest
{
    @Test
    public void should_return_nothing_if_params_valid()
    {
        LatestRequestDTO dto = LatestRequestDTO.of("EUR", "USD");

        LatestDTOValidator dtoValidator = new LatestDTOValidator();
        dtoValidator.validate(dto);
    }

    @Test
    public void should_thrown_validationexception_if_to_param_is_empty()
    {
        LatestRequestDTO dto = LatestRequestDTO.of("EUR", "");

        LatestDTOValidator dtoValidator = new LatestDTOValidator();
        Assertions.assertThrows(ValidationException.class, () -> {
            dtoValidator.validate(dto);
        });
    }

    @Test
    public void should_thrown_validationexception_if_from_param_is_empty()
    {
        LatestRequestDTO dto = LatestRequestDTO.of("", "USD");

        LatestDTOValidator dtoValidator = new LatestDTOValidator();
        Assertions.assertThrows(ValidationException.class, () -> {
            dtoValidator.validate(dto);
        });
    }
}
