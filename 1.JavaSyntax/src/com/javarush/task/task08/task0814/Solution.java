package com.javarush.task.task08.task0814;

import java.util.*;

/* 
Больше 10? Вы нам не подходите
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только три метода.
4. Метод createSet() должен создавать и возвращать множество Set состоящих из 20 различных чисел.
5. Метод removeAllNumbersGreaterThan10() должен удалять из множества все числа больше 10.
*/

public class Solution {
    public static Set<Integer> createSet() {
        // напишите тут ваш код
        Set<Integer> digitsSet = new HashSet<Integer>();
        Random random = new Random();

        do{
            digitsSet.add(random.nextInt(99));
        } while(digitsSet.size() < 20);

        return digitsSet;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        // напишите тут ваш код

        List<Integer> toRemove = new ArrayList<>();
        for(Integer digit : set){
            if(Integer.compare(digit, 10) > 0){
                toRemove.add(digit);
            }
        }

        // remove
        for(Integer digit : toRemove)
            set.remove(digit);

        return set;
    }

    public static void main(String[] args) {

    }
}
