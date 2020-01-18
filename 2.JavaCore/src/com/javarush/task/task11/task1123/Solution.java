package com.javarush.task.task11.task1123;

/*

Минимакс
Написать метод, который возвращает минимальное и максимальное числа в массиве.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Класс Pair не изменять.
3. Метод main не изменять.
4. Допиши реализацию метода getMinimumAndMaximum, он должен возвращать пару из минимума и максимума.
5. Программа должна вывести правильный результат.
6. Метод getMinimumAndMaximum не должен изменять массив inputArray.

 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndMaximum(data);

        System.out.println("The minimum is " + result.x);
        System.out.println("The maximum is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndMaximum(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }

        // напишите тут ваш код
        ArrayList<Integer> arrayDigits = new ArrayList<Integer>();
        for(int i = 0; i < inputArray.length; i++)
            arrayDigits.add(inputArray[i]);

        for(int i = 0; i < arrayDigits.size(); i++){
            boolean checkSorted = true;
            for(int x = 0; x < arrayDigits.size() - 1; x++){
                if(Integer.compare(arrayDigits.get(x), arrayDigits.get(x + 1)) > 0){
                    arrayDigits.add(x + 1, arrayDigits.remove(x));
                    checkSorted = false;
                }
            }
            if(checkSorted)
                break;
        }

        return new Pair<Integer, Integer>(arrayDigits.get(0), arrayDigits.get(arrayDigits.size() - 1));
    }

    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
