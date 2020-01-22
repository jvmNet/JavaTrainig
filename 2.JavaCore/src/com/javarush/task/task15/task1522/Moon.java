package com.javarush.task.task15.task1522;

public class Moon implements Planet {

    private static final Object obj = new Object();
    private static Moon instance = null;

    private Moon () {}

    public static Moon getInstance() {
        if(instance == null)
            synchronized (obj) {
                if(instance == null)
                    instance = new Moon();
            }
        return instance;
    }

}
