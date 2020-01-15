package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* 
Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true,
если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате FEBRUARY 1 2013
Не забудьте учесть первый день года.

Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false


Требования:
1. Программа должна выводить текст на экран.
2. Класс Solution должен содержать два метода.
3. Метод isDateOdd() должен возвращать true, если количество дней с начала года - нечетное число, иначе false.
4. Метод main() должен вызывать метод isDateOdd().
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("JANUARY 1 2000"));
    }

    public static boolean isDateOdd(String date) {

        Date d = new Date(date);

        Calendar currentDay = Calendar.getInstance();
        currentDay.setTime(d);

        Calendar firstDay = Calendar.getInstance();
        firstDay.set(currentDay.get(Calendar.YEAR), Calendar.JANUARY, 1);

        Calendar amountDayCalendar = Calendar.getInstance();
        amountDayCalendar.setTimeInMillis(currentDay.getTimeInMillis() - firstDay.getTimeInMillis());

        int amountDay = amountDayCalendar.get(Calendar.DAY_OF_YEAR);

        if(amountDay == 365 || amountDay == 366)
            return true;
        else
            return amountDay%2 == 0;
    }
}
