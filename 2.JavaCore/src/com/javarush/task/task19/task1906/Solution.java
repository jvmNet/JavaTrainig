package com.javarush.task.task19.task1906;

/* 
Четные символы
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).

Пример первого файла:
text in file
Вывод во втором файле:
eti ie
Закрыть потоки ввода-вывод


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна записывать во второй файл все байты из первого файла
с четным порядковым номером (используй FileWriter).
6. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        String fileInputName = null;
        String fileOutputName = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            fileInputName = bufferedReader.readLine();
            fileOutputName = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileReader fileReader = null;
        List<Integer> buffer = new ArrayList<>();

        try {
            fileReader = new FileReader(fileInputName);
            while(fileReader.ready()) {
                buffer.add(fileReader.read());
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileOutputName);
            for(int i = 0; i < buffer.size(); i++) {
                if(i%2 != 0)
                    fileWriter.write(buffer.get(i));
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
