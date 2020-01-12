package com.javarush.task.task05.task0532;

import java.io.*;
import java.util.ArrayList;

/* 
Задача по алгоритмам
Написать программу, которая:
1. считывает с консоли число N, которое должно быть больше 0
2. потом считывает N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.


Требования:
1. Программа должна считывать числа с клавиатуры.
2. Программа должна выводить число на экран.
3. В классе должен быть метод public static void main.
4. Нельзя добавлять новые методы в класс Solution.
5. Программа должна выводить на экран максимальное из введенных N чисел.
6. Программа не должна ничего выводить на экран, если N меньше либо равно 0.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;

        //напишите тут ваш код

        int n = Integer.parseInt(reader.readLine());
        boolean printConsole = n > 0;

        // init array digits
        int[] array = printConsole ? new int[n] : new int[0];

        // add digits to array
        for(int i = 0; i < array.length; i++){
            array[i] = Integer.parseInt(reader.readLine());
        }

        // sorted array digits _ find maximum digit
        for(int i = 0; i < array.length; i++){
            int max = array[i];
            int index = i;
            for(int x = i; x < array.length; x++){
                if(array[x] > max){
                    max = array[x];
                    index = x;
                }
            }
            if(index != i){
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
            }
        }

        if(printConsole){
            maximum = array[0];
            System.out.println(maximum);
        }
    }
}
