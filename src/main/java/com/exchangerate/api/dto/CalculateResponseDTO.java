package com.exchangerate.api.dto;

/**
 * @author yusufaltun
 */

public class CalculateResponseDTO extends BaseDTO {

    private double amount;
    private double calculatedAmount;

    public CalculateResponseDTO(String from, String to) {
        super(from, to);
    }

    public double getAmount() {
        return amount;
    }

    public double getCalculatedAmount() {
        return calculatedAmount;
    }

    public void setCalculatedAmount(double calculatedAmount) {
        this.calculatedAmount = calculatedAmount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
