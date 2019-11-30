package com.exchangerate.api.validator;

import com.exchangerate.api.dto.HistoricalRequestDTO;
import com.exchangerate.api.exception.ValidationException;
import com.exchangerate.api.validation.HistoricalDTOValidator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author yusufaltun
 */
@ContextConfiguration(initializers = ConfigFileApplicationContextInitializer.class)
public class HistoricalValidatorTest
{
    @Test
    public void should_return_nothing_if_params_valid()
    {
        HistoricalRequestDTO dto = HistoricalRequestDTO.of("EUR", "USD", "2019-11-10");

        HistoricalDTOValidator dtoValidator = new HistoricalDTOValidator();
        dtoValidator.validate(dto);
    }

    @Test
    public void should_thrown_validationexception_if_date_null()
    {
        HistoricalRequestDTO dto = HistoricalRequestDTO.of("EUR", "USD", null);

        HistoricalDTOValidator dtoValidator = new HistoricalDTOValidator();

        Assertions.assertThrows(ValidationException.class, () -> {
            dtoValidator.validate(dto);
        });
    }

    @Test
    public void should_thrown_validationexception_if_date_empty()
    {
        HistoricalRequestDTO dto = HistoricalRequestDTO.of("EUR", "USD", "");

        HistoricalDTOValidator dtoValidator = new HistoricalDTOValidator();
        Assertions.assertThrows(ValidationException.class, () -> {
            dtoValidator.validate(dto);
        });
    }

    @Test
    public void should_thrown_validationexception_if_date_wrong_format()
    {
        HistoricalRequestDTO dto = HistoricalRequestDTO.of("EUR", "USD", "dd/MM-yyyy");

        HistoricalDTOValidator dtoValidator = new HistoricalDTOValidator();

        Assertions.assertThrows(ValidationException.class, () -> {
            dtoValidator.validate(dto);
        });
    }

    @Test
    public void should_thrown_validationexception_if_to_param_is_empty()
    {
        HistoricalRequestDTO dto = HistoricalRequestDTO.of("EUR", "", "2019-10-10");

        HistoricalDTOValidator dtoValidator = new HistoricalDTOValidator();
        Assertions.assertThrows(ValidationException.class, () -> {
            dtoValidator.validate(dto);
        });
    }

    @Test
    public void should_thrown_validationexception_if_from_param_is_empty()
    {
        HistoricalRequestDTO dto = HistoricalRequestDTO.of("", "USD", "2019-10-10");

        HistoricalDTOValidator dtoValidator = new HistoricalDTOValidator();
        Assertions.assertThrows(ValidationException.class, () -> {
            dtoValidator.validate(dto);
        });
    }
}
