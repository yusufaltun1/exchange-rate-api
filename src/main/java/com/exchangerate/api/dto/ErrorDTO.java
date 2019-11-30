package com.exchangerate.api.dto;

/**
 * @author yusufaltun
 */

public class ErrorDTO
{
    private String error;
    private int code;

    public ErrorDTO(String error, int code) {
        this.error = error;
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
