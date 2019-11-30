package com.exchangerate.api.exception;

/**
 * @author yusufaltun
 */

public class UnexpectedException extends RuntimeException
{
    public UnexpectedException() {
        super("Unexpected Error");
    }
}
