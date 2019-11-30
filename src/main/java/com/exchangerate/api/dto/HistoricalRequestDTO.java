package com.exchangerate.api.dto;

/**
 * @author yusufaltun
 */

public class HistoricalRequestDTO extends BaseDTO
{
    private String date;

    private HistoricalRequestDTO(String from, String to, String date)
    {
        super(from, to);
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public static HistoricalRequestDTO of(String from, String to, String date)
    {
        return new HistoricalRequestDTO(from, to, date);
    }
}
