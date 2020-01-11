package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
Ввести с клавиатуры два целых числа, и вывести на экран минимальное из них.
Если два числа равны между собой, необходимо вывести любое.


Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить число на экран.
3. Программа должна выводить на экран минимальное из двух целых чисел.
4. Если два числа равны между собой, необходимо вывести любое.
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());

        if(a < b){
            System.out.println(a);
        } else if(b < a){
            System.out.println(b);
        } else {
            System.out.println(a);
        }

    }
}