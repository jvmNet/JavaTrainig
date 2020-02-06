package com.javarush.task.task19.task1907;

/* 
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        String fileName = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            fileName = bufferedReader.readLine();
            fileReader = new FileReader(fileName);

            StringBuilder stringBuilder = new StringBuilder();
            while(fileReader.ready()) {
                stringBuilder.append((char)fileReader.read());
            }
            bufferedReader.close();
            fileReader.close();

            int count = 0;
            for(String word : stringBuilder.toString().split("[^A-Za-z0-9]")) {
                if(word.equals("world"))
                    count++;
            }

            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
