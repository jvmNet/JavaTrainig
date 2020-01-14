package com.javarush.task.task08.task0813;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/* 
20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву "Л".


Требования:
1. Не изменяй заголовок метода createSet().
2. Программа не должна выводить текст на экран.
3. Программа не должна считывать значения с клавиатуры.
4. Метод createSet() должен создавать и возвращать множество (реализация HashSet).
5. Множество из метода createSet() должно содержать 20 слов на букву «Л».
*/

public class Solution {
    public static Set<String> createSet() {
        //напишите тут ваш код
        Set<String> set = new HashSet<String>();

        final String chars = "митьбюдлорпавыфйцукенгшщзх";
        Random random = new Random();
        char[] word = new char[9];

        int amountWords = 20;
        while(amountWords > 0) {
            StringBuilder str = new StringBuilder("Л");
            for(int i = 0; i < word.length; i++){
                str.append(chars.charAt(random.nextInt(chars.length())));
            }
            set.add(str.toString());
            amountWords--;
        }

        return set;
    }

    public static void main(String[] args) {

    }
}
