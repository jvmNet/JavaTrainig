package com.javarush.task.task12.task1233;

/* 
Изоморфы наступают
Написать метод, который возвращает минимальное число в массиве и его позицию (индекс).


Требования:
1. Класс Solution должен содержать класс Pair.
2. Класс Solution должен содержать два метода.
3. Класс Solution должен содержать метод getMinimumAndIndex().
4. Метод getMinimumAndIndex() должен возвращать минимальное число в массиве и его позицию (индекс).
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndIndex(data);

        System.out.println("The minimum is " + result.x);
        System.out.println("The index of the minimum element is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndIndex(int[] array) {
        if (array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }

        //напишите тут ваш код

        Integer minDigitIndexToArray = 0;
        Integer minDigit = 0;
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < array.length; i++)
            list.add(array[i]);

        for(int i = 0; i < list.size(); i++){
            boolean checkSorted = true;
            for(int x = 0; x < list.size() - 1; x++){
                if(Integer.compare(list.get(x), list.get(x + 1)) > 0){
                    list.add(x, list.remove(x + 1));
                    checkSorted = false;
                }
            }
            if(checkSorted)
                break;
        }

        minDigit = list.get(0);
        for(int i = 0; i < array.length; i++){
            if(Integer.compare(minDigit, array[i]) == 0)
                minDigitIndexToArray = i;
        }

        return new Pair<Integer, Integer>(minDigit, minDigitIndexToArray);
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
