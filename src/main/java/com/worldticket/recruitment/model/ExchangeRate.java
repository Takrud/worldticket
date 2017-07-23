package com.worldticket.recruitment.model;

public class ExchangeRate {
    private String currency;
    private int denomination;
    private double buying;
    private double selling;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getDenomination() {
        return denomination;
    }

    public void setDenomination(int denomination) {
        this.denomination = denomination;
    }

    public double getBuying() {
        return buying;
    }

    public void setBuying(double buying) {
        this.buying = buying;
    }

    public double getSelling() {
        return selling;
    }

    public void setSelling(double selling) {
        this.selling = selling;
    }
}
