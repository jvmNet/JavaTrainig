package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.


Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Программа должна считывать 5 строк с клавиатуры и записывать их в список.
3. Программа должна выводить самую короткую строку на экран.
4. Если есть несколько строк с длиной равной минимальной, то нужно вывести каждую из них с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        // init
        ArrayList<String> strList = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // add list
        for(int i = 0; i < 5; i++)
            strList.add(bufferedReader.readLine());

        // sorted
        int count = strList.size();
        while(count > 0){
            for(int i = 0; i < strList.size() - 1; i++){
                if(Integer.compare(strList.get(i).length(), strList.get(i + 1).length()) > 0)
                    strList.add(i, strList.remove(i + 1));
            }
            count--;
        }

        // add min length
        int minimal = strList.get(0).length();

        // out to console
        strList.forEach(str -> {
            if(Integer.compare(minimal, str.length()) == 0)
                System.out.println(str);
        });

    }
}
