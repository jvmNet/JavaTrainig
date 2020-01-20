package com.javarush.task.task14.task1417;

public class USD extends Money implements CurrencyName {
    public USD(double amount) {
        super(amount);
    }

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public String getCurrencyName() {
        return CurrencyName.USD;
    }
}
