package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());

        int[] arrayDigits = {a, b, c};

        int countPositiveDigits = 0;
        int countNegativeDigits = 0;
        for(int i = 0; i < arrayDigits.length; i++){
            if(arrayDigits[i] > 0 && arrayDigits[i] != 0)
                countPositiveDigits++;
            if(arrayDigits[i] < 0 && arrayDigits[i] != 0)
                countNegativeDigits++;
        }
        System.out.println("количество отрицательных чисел: " + countNegativeDigits);
        System.out.println("количество положительных чисел: " + countPositiveDigits);

    }
}
