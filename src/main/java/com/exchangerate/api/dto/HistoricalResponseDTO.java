package com.exchangerate.api.dto;

/**
 * @author yusufaltun
 */

public class HistoricalResponseDTO extends BaseDTO
{

    private String date;
    private double amount;

    public HistoricalResponseDTO(String from, String to) {
        super(from, to);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
