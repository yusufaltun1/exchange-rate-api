package com.exchangerate.api.exception;

/**
 * @author yusufaltun
 */

public class ValidationException extends RuntimeException
{
    public ValidationException(String message) {
        super(message);
    }
}
