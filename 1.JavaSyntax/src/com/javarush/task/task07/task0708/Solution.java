package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/* 
Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран. Если таких строк несколько, выведи каждую с новой строки.


Требования:
1. В методе main инициализируй существующее поле strings класса Solution новым ArrayList<>
2. Программа должна считывать 5 строк с клавиатуры и записывать их в поле strings класса Solution.
3. Программа должна выводить самую длинную строку на экран.
4. Если есть несколько строк с длиной равной максимальной, то нужно вывести каждую из них с новой строки.
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        // init variables
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        strings = new ArrayList<String>();

        // input system in
        for(int i = 0; i < 5; i++)
            strings.add(bufferedReader.readLine());

        // sorted
        //strings.sort((str1, str2) -> Integer.compare(str2.length(), str1.length()));
        for(int i = strings.size(); i > 1; i--){
            boolean checkSorted = true;
            for(int x  = 0; x < strings.size() - 1; x++){
                if(Integer.compare(strings.get(x).length(), strings.get(x + 1).length()) < 0){
                    strings.add(x, strings.remove(x + 1));
                    checkSorted = false;
                }
            }
            if(checkSorted)
                break;
        }

        int maxStrLength = strings.get(0).length();

        for(int i = 0; i < strings.size(); i++){
            if(Integer.compare(maxStrLength, strings.get(i).length()) == 0)
                System.out.println(strings.get(i));
        }

        // out console
//        int checkCount = 0;
//        do{
//            if(checkCount == 0)
//                System.out.println(strings.get(checkCount));
//            else if(Integer.compare(strings.get(checkCount - 1).length(), strings.get(checkCount).length()) == 0)
//                System.out.println(strings.get(checkCount));
//            checkCount++;
//        } while(checkCount < strings.size());

    }
}
