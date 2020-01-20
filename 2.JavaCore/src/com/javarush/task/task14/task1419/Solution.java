package com.javarush.task.task14.task1419;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Нашествие исключений
Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.


Требования:
1. Список exceptions должен содержать 10 элементов.
2. Все элементы списка exceptions должны быть исключениями(потомками класса Throwable).
3. Все элементы списка exceptions должны быть уникальны.
4. Метод initExceptions должен быть статическим.
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

        try {
            int[] array = new int[10];
            int x = array[11];

        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            ArrayList<Integer> list = new ArrayList<>(10);
            list.get(11);

        } catch (IndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            String digit = "";
            int n = Integer.parseInt(digit);

        } catch (NumberFormatException e) {
            exceptions.add(e);
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("");

        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }

        try {
            Object obj = new Object();
            obj.notify();

        } catch (IllegalMonitorStateException e) {
            exceptions.add(e);
        }

        try {
            List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3"));
            for(String str : list){
                list.remove(0);
                list.add(0,"5");
            }
        } catch (ConcurrentModificationException e) {
            exceptions.add(e);
        }

        try {
            new Solution().clone();
        } catch (CloneNotSupportedException e) {
            exceptions.add(e);
        }

        try {
            Object obj = new Object();
            Solution solution = (Solution) obj;

        } catch (ClassCastException e) {
            exceptions.add(e);
        }

        try {
            Date date = new Date("89");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            simpleDateFormat.parse(date.toString());

        } catch (ParseException e) {
            exceptions.add(e);
        } catch (IllegalArgumentException e) {
            exceptions.add(e);
        }

    }
}
