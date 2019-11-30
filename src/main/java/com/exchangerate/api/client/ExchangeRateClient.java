package com.exchangerate.api.client;

import com.exchangerate.api.exception.UnexpectedException;
import com.exchangerate.api.model.ExchangeRateResponse;
import com.exchangerate.api.request.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author yusufaltun
 */
@Component
public class ExchangeRateClient
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeRateClient.class);

    private RestTemplate restTemplate;

    public ExchangeRateResponse makeRequest(Request req)
    {
        try {
            ResponseEntity<ExchangeRateResponse> res = getRestTemplate().getForEntity(req.getURL(), ExchangeRateResponse.class);
            if(!res.getBody().getSuccess().booleanValue())
            {
                throw new UnexpectedException();
            }

            return res.getBody();
        }
        catch (Exception e)
        {
            LOGGER.error("Exception while getting exchance rate data ", e);
            throw new UnexpectedException();
        }
    }

    public RestTemplate getRestTemplate()
    {
        if(restTemplate == null)
        {
            restTemplate = new RestTemplate();
        }

        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
