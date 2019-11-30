package com.exchangerate.api.builder;

import com.exchangerate.api.dto.BaseDTO;
import com.exchangerate.api.request.Request;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author yusufaltun
 */

public abstract class Builder<TARGET extends Request, SOURCE extends BaseDTO>
{
    @Value("${exchangerate.access.key}")
    private String accessToken;

    @Value("${exchangerate.url}")
    private String url;


    public abstract TARGET build(SOURCE dto);

    protected String getAccessToken()
    {
        return accessToken;
    }

    protected String getUrl()
    {
        return url;
    }
}
