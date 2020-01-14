package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Минимаксы в массивах
Создать массив на 20 чисел.
Заполнить его числами с клавиатуры.
Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.


Требования:
1. Создай массив целых чисел (int[]) на 20 элементов.
2. Считай с клавиатуры 20 целых чисел и добавь их в массив.
3. Найди и выведи через пробел максимальное и минимальное числа.
4. Используй цикл for.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        //напишите тут ваш код

        int[] listDigits = new int[20];

        int amountDigits = listDigits.length - 1;
        while(amountDigits >= 0){
            listDigits[amountDigits] = Integer.parseInt(reader.readLine());
            amountDigits--;
        }

        for(int x = 0; x < listDigits.length; x++){
            boolean checkSorted = true;
            for(int i = 0; i < listDigits.length - 1; i++){
                if(Integer.compare(listDigits[i], listDigits[i + 1]) > 0){
                    int temp = listDigits[i];
                    listDigits[i] = listDigits[i + 1];
                    listDigits[i + 1] = temp;
                    checkSorted = false;
                }
            }
            if(checkSorted)
                break;
        }

        maximum = listDigits[listDigits.length - 1];
        minimum = listDigits[0];

        System.out.print(maximum + " " + minimum);
    }
}
