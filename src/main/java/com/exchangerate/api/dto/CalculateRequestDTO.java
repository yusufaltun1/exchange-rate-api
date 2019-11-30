package com.exchangerate.api.dto;

/**
 * @author yusufaltun
 */

public class CalculateRequestDTO extends BaseDTO
{
    private String date;
    private Double amount;

    private CalculateRequestDTO(String from, String to, String date, double amount) {
        super(from, to);
        this.date = date;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public static CalculateRequestDTO of(String from, String to, String date, double amount)
    {
        return new CalculateRequestDTO(from, to, date, amount);
    }
}
