package com.exchangerate.api.dto;

/**
 * @author yusufaltun
 */

public class BaseDTO
{
    private String from;
    private String to;

    public BaseDTO(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
