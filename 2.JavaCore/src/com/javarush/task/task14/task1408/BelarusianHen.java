package com.javarush.task.task14.task1408;

class BelarusianHen extends Hen {

    @Override
    public int getCountOfEggsPerMonth() {
        return Country.BELARUS_COUNT_EGGS;
    }

    @Override
    public String getDescription() {
        return super.getDescription()
                + " Моя страна - " + Country.BELARUS + "."
                + " Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
