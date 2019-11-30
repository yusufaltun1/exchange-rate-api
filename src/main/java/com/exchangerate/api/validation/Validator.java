package com.exchangerate.api.validation;

import com.exchangerate.api.dto.BaseDTO;

/**
 * @author yusufaltun
 */

public interface Validator<TYPE extends BaseDTO>
{
    void validate(TYPE dto);
}
