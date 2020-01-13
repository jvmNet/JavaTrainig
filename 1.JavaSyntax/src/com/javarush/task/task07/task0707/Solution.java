package com.javarush.task.task07.task0707;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* 
Что за список такой?
1. Создай список строк.
2. Добавь в него 5 различных строк.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.


Требования:
1. Программа не должна ничего считывать с клавиатуры.
2. Объяви переменную типа ArrayList<String> (список строк) и сразу проинициализируй ee.
3. Программа должна добавить 5 любых строк в список.
4. Программа должна вывести размер списка на экран.
5. Программа должна вывести содержимое списка на экран, каждое значение с новой строки.
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        ArrayList<String> str = new ArrayList<String>();

        for(int i = 1; i <= 5; i++)
            str.add(new Solution().toString() + ": " + i);

        System.out.println(str.size());
        str.forEach(System.out::println);
    }
}
