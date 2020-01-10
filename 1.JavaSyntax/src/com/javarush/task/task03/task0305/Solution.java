package com.javarush.task.task03.task0305;

/* 
Я так давно родился
*/


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String dateBirthday = "12/7/1985";

        Date d = new Date(dateBirthday);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);

        System.out.println(simpleDateFormat.format(d).toUpperCase());

    }
}
