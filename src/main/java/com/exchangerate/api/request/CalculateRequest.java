package com.exchangerate.api.request;

/**
 * @author yusufaltun
 */

public class CalculateRequest implements Request
{
    private String url;

    @Override
    public String getURL() {
        return url;
    }

    public CalculateRequest(String url) {
        this.url = url;
    }
}
