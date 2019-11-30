package com.exchangerate.api;

import com.exchangerate.api.controller.ExchangeRateController;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExchangeRateApiApplicationTests {

    @Autowired
    private ExchangeRateController exchangeRateController;

    @Test
    public void contexLoads() throws Exception {
        AssertionsForClassTypes.assertThat(exchangeRateController).isNotNull();
    }
}
