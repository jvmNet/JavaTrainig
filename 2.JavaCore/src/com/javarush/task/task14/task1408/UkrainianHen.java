package com.javarush.task.task14.task1408;

class UkrainianHen extends Hen {

    @Override
    public int getCountOfEggsPerMonth() {
        return Country.UKRAINE_COUNT_EGGS;
    }

    @Override
    public String getDescription() {
        return super.getDescription()
                + " Моя страна - " + Country.UKRAINE + "."
                + " Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
