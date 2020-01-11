package com.javarush.task.task04.task0441;

/* 
Как-то средненько
Ввести с клавиатуры три числа, вывести на экран среднее из них.
Т.е. не самое большое и не самое маленькое.
Если все числа равны, вывести любое из них.


Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить число на экран.
3. Программа должна выводить среднее из трех чисел.
4. Если все числа равны, вывести любое из них.
5. Если два числа из трех равны, вывести любое из двух.
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());

        Solution solution = new Solution();
        int min = solution.getMinDigit(a, b) < c ? solution.getMinDigit(a, b) : c;
        int max = solution.getMaxDigit(a, b) > c ? solution.getMaxDigit(a, b) : c;
        int medium = (a + b + c) - (min + max);

        if(a == b){
            System.out.println(a);
        } else if(b == c){
            System.out.println(c);
        } else if(a == c){
            System.out.println(c);
        } else {
            System.out.println(medium);
        }

    }

    private int getMinDigit(int a, int b){
        if(a < b)
            return a;
        return b;
    }

    private int getMaxDigit(int a, int b){
        if(a > b)
            return a;
        return b;
    }

}
