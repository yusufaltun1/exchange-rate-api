package com.exchangerate.api.dto;

/**
 * @author yusufaltun
 */

public class LatestRequestDTO extends BaseDTO
{
    private LatestRequestDTO(String from, String to) {
        super(from, to);
    }

    public static LatestRequestDTO of(String from, String to)
    {
        return new LatestRequestDTO(from, to);
    }
}
