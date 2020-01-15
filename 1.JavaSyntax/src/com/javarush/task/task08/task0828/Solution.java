package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: "May is the 5 month".
Используйте коллекции.


Требования:
1. Программа должна считывать одно значение с клавиатуры.
2. Программа должна выводить текст на экран.
3. Программа должна использовать коллекции.
4. Программа должна считывать с клавиатуры имя месяца и выводить его номер на экран по заданному шаблону.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код

        Map<Integer, String> months = new HashMap<Integer, String>(){
            {
                put(1, "january");
                put(2, "february");
                put(3, "march");
                put(4, "april");
                put(5, "may");
                put(6, "june");
                put(7, "july");
                put(8, "august");
                put(9, "september");
                put(10, "october");
                put(11, "november");
                put(12, "december");
            }
        };

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String month = bufferedReader.readLine();
        int numberMonth = 0;
        for(Map.Entry<Integer, String> pair : months.entrySet()){
            if(pair.getValue().equals(month.toLowerCase())){
                numberMonth = pair.getKey();
            }
        }

        if(numberMonth != 0)
            System.out.println(month + " is the " + numberMonth + " month");

    }
}
