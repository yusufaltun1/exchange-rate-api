package com.exchangerate.api.dto;

/**
 * @author yusufaltun
 */

public class LatestResponseDTO extends BaseDTO
{
    private double amount;

    public LatestResponseDTO(String from, String to) {
        super(from, to);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
