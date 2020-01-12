package com.javarush.task.task05.task0531;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Совершенствуем функциональность
Текущая реализация: Программа вводит два числа с клавиатуры и выводит минимальное из них на экран.
Новая задача: Программа вводит пять чисел с клавиатуры и выводит минимальное из них на экран.


Требования:
1. Программа должна считывать числа с клавиатуры.
2. В классе должен быть метод public static void main.
3. В классе должен быть метод public static min, принимающий 5 параметров типа int.
4. Метод min должен возвращать минимум из 5 переданных чисел. Если минимальных чисел несколько - вернуть любое из них.
5. Программа должна выводить строку, которая начинается на "Minimum = ".
6. Программа должна выводить строку, которая заканчивается минимальным из 5 введенных чисел.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());


        int minimum = min(a, b, c, d, e);
        System.out.println("Minimum = " + minimum);
    }


    public static int min(final int a,
                          final int b,
                          final int c,
                          final int d,
                          final int e)
    {
        int[] array = {a, b, c, d, e};
        int min = 0;
        for(int i = 0; i < array.length; i++){
            int minimum = array[i];
            int index = i;
            for(int x = i; x < array.length; x++){
                if(array[x] < minimum){
                    minimum = array[x];
                    index = x;
                }
            }
            if(index != i){
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
            }
        }
        min = array[0];
        return min;
    }

}