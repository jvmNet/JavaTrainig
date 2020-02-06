package com.javarush.task.task19.task1910;

/* 
Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла, удалить все знаки пунктуации, включая символы новой строки.

Результат вывести во второй файл.

Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл содержимое первого файла,
где удалены все знаки пунктуации, включая символы новой строки (Для записи в файл используй BufferedWriter
 с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
                    BufferedWriter fileWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine())))
        {

            StringBuilder buffer = new StringBuilder();
            while(fileReader.ready()) {
                int l = fileReader.read();
                if(Character.isAlphabetic(l) ||
                    Character.isDigit(l) ||
                        Character.isSpaceChar(l))
                {
                    buffer.append((char)l);
                }
            }

            fileWriter.write(buffer.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
