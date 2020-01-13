package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 
Общение одиноких массивов
1. Создать массив на 10 строк.
2. Создать массив на 10 чисел.
3. Ввести с клавиатуры 10 строк, заполнить ими массив строк.
4. В каждую ячейку массива чисел записать длину строки из массива строк, индекс/номер ячейки которой совпадает
с текущим индексом из массива чисел.

Вывести содержимое массива чисел на экран, каждое значение выводить с новой строки.


Требования:
1. Программа должна создавать массив на 10 строк.
2. Программа должна создавать массив на 10 целых чисел.
3. Программа должна считывать строки для массива с клавиатуры.
4. Программа должна в массив чисел записать длины строк из массива строк, а затем их вывести на экран.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        // initial variables
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] arrayStrings = new String[10];
        int[] arrayDigits = new int[10];

        // add string array
        int count = 0;
        while(count < arrayStrings.length){
            arrayStrings[count] = bufferedReader.readLine();
            count++;
        }

        // add length str to digits array
        for(int i = 0; i < arrayStrings.length; i++){
            arrayDigits[i] = arrayStrings[i].length();
        }

        // print to console
        List<Integer> list = Arrays.stream(arrayDigits).boxed().collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
