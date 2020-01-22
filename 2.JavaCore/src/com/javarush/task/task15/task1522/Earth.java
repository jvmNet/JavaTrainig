package com.javarush.task.task15.task1522;

public class Earth implements Planet {

    private static final Object obj = new Object();
    private static Earth instance = null;

    private Earth () {}

    public static Earth getInstance() {
        if(instance == null)
            synchronized (obj) {
                if(instance == null)
                    instance = new Earth();
            }
        return instance;
    }

}
