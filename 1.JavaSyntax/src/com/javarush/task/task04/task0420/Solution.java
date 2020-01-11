package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
Выведенные числа должны быть разделены пробелом.


Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить числа на экран.
3. Программа должна выводить три числа разделенных пробелами.
4. Программа должна выводить числа в порядке убывания.
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Solution solution = new Solution();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());

        int min = solution.getMinDigital(a, b) < c ? solution.getMinDigital(a, b) : c;
        int max = solution.getMaxDigital(a, b) > c ? solution.getMaxDigital(a, b) : c;
        int medium = (a + b + c) - (min + max);

        System.out.println(max + " " + medium + " " + min);

    }

    private int getMinDigital(int a, int b){
        if(a < b)
            return a;
        return b;
    }

    private int getMaxDigital(int a, int b){
        if(a > b)
            return a;
        return b;
    }
}
