package com.javarush.task.task14.task1409;

public class WaterBridge implements Bridge {

    private static final int COUNT = 1500;

    @Override
    public int getCarsCount() {
        return WaterBridge.COUNT;
    }
}
