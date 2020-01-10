package com.javarush.task.task03.task0313;

/* 
Мама мыла раму

Требования:
1. Программа должна выводить текст.
2. Выведенный текст должен содержать 6 строк.
3. Текст в каждой строке должен быть уникален.
4. Должны быть выведены все возможные комбинации.

*/

import org.w3c.dom.ls.LSOutput;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String[] text = {"Мама", "Мыла", "Раму"};

        for (int i = 0; i < text.length; i++){
            for(int x = 0; x < text.length; x++){
                for(int y = 0; y < text.length; y++){
                    if(!text[i].equals(text[y]) && !text[x].equals(text[y]) && !text[i].equals(text[x])){
                        System.out.print(text[i] + text[x] + text[y]);
                        System.out.println();
                    }
                }
            }
        }

    }
}
