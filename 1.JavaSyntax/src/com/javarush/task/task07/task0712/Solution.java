package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
1. Создай список строк.
2. Добавь в него 10 строчек с клавиатуры.
3. Узнай, какая строка в списке встретится раньше: самая короткая или самая длинная.
Если таких строк несколько, то должны быть учтены самые первые из них.
4. Выведи на экран строку из п.3. Должна быть выведена одна строка.


Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Программа должна считывать 10 строк с клавиатуры и добавлять их в список.
3. Программа должна выводить на экран самую короткую строку, если она была раньше самой длинной.
4. Программа должна выводить на экран самую длинную строку, если она была раньше самой короткой.
5. Должна быть выведена только одна строка.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strList = new ArrayList<String>();

        // add str to array
        int count = 10;
        while(count > 0){
            strList.add(bufferedReader.readLine());
            count--;
        }

        // create array length str
        ArrayList<Integer> strLengthArray = new ArrayList<Integer>();
        strList.forEach(str -> {
            strLengthArray.add(str.length());
        });

        // sorted array length str
        strLengthArray.sort((a, b) -> Integer.compare(a, b));

        // min - max length str
        int minLengthStr = strLengthArray.get(0);
        int maxLengthStr = strLengthArray.get(strLengthArray.size() - 1);

        for(String str : strList){
            if(Integer.compare(str.length(), minLengthStr) == 0
            || Integer.compare(str.length(), maxLengthStr) == 0)
            {
                System.out.println(str);
                break;
            }
        }

    }
}
