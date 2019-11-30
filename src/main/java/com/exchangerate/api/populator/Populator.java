package com.exchangerate.api.populator;

import com.exchangerate.api.dto.BaseDTO;
import com.exchangerate.api.model.ExchangeRateResponse;

/**
 * @author yusufaltun
 */

public interface Populator<T extends BaseDTO>
{
    T populate(ExchangeRateResponse res);
}
