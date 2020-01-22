package com.javarush.task.task15.task1522;

public class Sun implements Planet {

    private static final Object obj = new Object();
    private static Sun instance = null;

    private Sun () {}

    public static Sun getInstance() {
        if(instance == null)
            synchronized (obj) {
                if(instance == null)
                    instance = new Sun();
            }
        return instance;
    }

}
