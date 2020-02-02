package com.javarush.task.task18.task1816;

/* 
Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException{

        FileReader fileReader = new FileReader(args[0]);
        StringBuffer sb = new StringBuffer();

        while(fileReader.ready()) {
            sb.append(String.valueOf((char)fileReader.read()).toLowerCase());
        }

        byte[] buffer = sb.toString().getBytes();
        int countLetters = 0;
        for(int i = 0; i < buffer.length; i++) {
            if(buffer[i] >= 97 && buffer[i] <= 122)
                countLetters++;
        }
        System.out.println(countLetters);

        fileReader.close();

    }

}














