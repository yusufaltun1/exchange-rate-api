package com.exchangerate.api.request;

/**
 * @author yusufaltun
 */

public class LatestRequest implements Request
{
    private String url;

    @Override
    public String getURL() {
        return url;
    }

    public LatestRequest(String url) {
        this.url = url;
    }
}
