package com.exchangerate.api.request;

/**
 * @author yusufaltun
 */

public class HistoricalRequest implements Request
{
    private String url;

    @Override
    public String getURL() {
        return url;
    }

    public HistoricalRequest(String url) {
        this.url = url;
    }
}
