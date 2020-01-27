package com.javarush.task.task17.task1707;


public class IMF {

    private static final Object obj = new Object();
    private static IMF imf;

    public static IMF getFund() {
        //add your code here - добавь код тут

        if(imf == null)
            synchronized (obj) {
                if(imf == null)
                    imf = new IMF();
        }
        return imf;
    }

    private IMF() {
    }
}
