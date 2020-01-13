package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Массивный максимум
1. В методе initializeArray():
1.1. Создайте массив на 20 чисел
1.2. Считайте с консоли 20 чисел и заполните ими массив
2. Метод max(int[] array) должен находить максимальное число из элементов массива


Требования:
1. Метод initializeArray должен создавать массив из 20 целых чисел.
2. Метод initializeArray должен считать 20 чисел и вернуть их в виде массива.
3. Метод max должен возвращать максимальный элемент из переданного массива.
4. Метод main изменять нельзя.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        // создай и заполни массив

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for(int i = 0; i < array.length; i++){
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }
        return array;
    }

    public static int max(int[] array) {
        // найди максимальное значение

        int max = 0;

        boolean checkSorted = true;
        for(int i = 0; i < array.length; i++){
            for(int x = 0; x < array.length; x++){
                if(array[i] > array[x]){
                    int temp = array[i];
                    array[i] = array[x];
                    array[x] = temp;
                    checkSorted = false;
                }
            }
            if(checkSorted)
                break;
        }
        max = array[0];
        return max;
    }
}
