package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 
Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.


Требования:
1. Программа должна создавать большой массив на 20 целых чисел.
2. Программа должна считывать с клавиатуры 20 чисел для большого массива.
3. Программа должна создавать два маленьких массива на 10 чисел каждый.
4. Программа должна скопировать одну половину большого массива в первый маленький,
а вторую - во второй и вывести второй маленький массив на экран.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // initial arrays
        int[] arrayDigit = new int[20];
        int[] arrayFirstTen = new int[10];
        int[] arraySecondTen = new int[10];

        // add digits to array
        for(int i = 0; i < arrayDigit.length; i++)
            arrayDigit[i] = Integer.parseInt(bufferedReader.readLine());

        // copy arrayDigit to two arrays
        int iSecond = 0;
        for(int i = 0; i < arrayDigit.length; i++){
            if(i < arrayFirstTen.length){
                arrayFirstTen[i] = arrayDigit[i];
            } else {
                arraySecondTen[iSecond] = arrayDigit[i];
                iSecond++;
            }
        }

        // out second array to console
        List<Integer> listSecondArray = Arrays.stream(arraySecondTen).boxed().collect(Collectors.toList());
        listSecondArray.forEach(System.out::println);

    }
}
