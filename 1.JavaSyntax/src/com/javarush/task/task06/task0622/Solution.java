package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 
Числа по возрастанию
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.

Пример ввода:
3
2
15
6
17

Пример вывода:
2
3
6
15
17


Требования:
1. Программа должна считывать 5 чисел с клавиатуры.
2. Программа должна выводить 5 чисел, каждое с новой строки.
3. Выведенные числа должны быть отсортированы по возрастанию.
4. Вывод должен содержать те же числа, что и были введены (порядок не важен).
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код

        int[] arrayDigits = new int[5];
        for(int i = 0; i < arrayDigits.length; i++){
            arrayDigits[i] = Integer.parseInt(reader.readLine());
        }

        boolean checkIsSorted = true;
        for(int i = 0; i < arrayDigits.length; i++){
            for(int x = 0; x < arrayDigits.length; x++){
                if(arrayDigits[i] > arrayDigits[x]){
                    int temp = arrayDigits[i];
                    arrayDigits[i] = arrayDigits[x];
                    arrayDigits[x] = temp;
                    checkIsSorted = false;
                }
            }
            if(checkIsSorted)
                break;
        }

//        List<Integer> digits = Arrays.stream(arrayDigits).boxed().collect(Collectors.toList());
//        digits.forEach(System.out::println);

        for(int i = arrayDigits.length - 1; i >= 0; i--){
            System.out.println(arrayDigits[i]);
        }

    }
}
