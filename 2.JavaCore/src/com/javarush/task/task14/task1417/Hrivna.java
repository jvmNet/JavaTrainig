package com.javarush.task.task14.task1417;

public class Hrivna extends Money implements CurrencyName{
    public Hrivna(double amount) {
        super(amount);
    }

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public String getCurrencyName() {
        return CurrencyName.UAH;
    }
}
