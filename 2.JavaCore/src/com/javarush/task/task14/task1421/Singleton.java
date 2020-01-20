package com.javarush.task.task14.task1421;

public class Singleton {

    private static final Object obj = new Object();
    private static Singleton instance = null;

    private Singleton() { }

    public static Singleton getInstance() {
        if(instance == null)
            synchronized (obj) {
                if(instance == null)
                    instance = new Singleton();
            }
        return instance;
    }

}
