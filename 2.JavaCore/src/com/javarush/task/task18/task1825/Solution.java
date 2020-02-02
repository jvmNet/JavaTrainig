package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.
6. Не используй статические переменные.
*/

public class Solution {
    public static void main(String[] args) {

        Set<String> filePart = new TreeSet<String>();
        byte[] buffer = null;
        final String commandExit = "end";
        String fileName = null;
        BufferedReader bufferedReader = null;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while(!(fileName = bufferedReader.readLine()).equals(commandExit)) {
                filePart.add(fileName);
            }

            fileOutputStream = new FileOutputStream(filePart.iterator().next().split(".part")[0]);
            for(String part : filePart) {
                fileInputStream = new FileInputStream(part);
                buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer, 0, fileInputStream.available());
                fileOutputStream.write(buffer);
                fileInputStream.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bufferedReader != null)
                    bufferedReader.close();
                if(fileInputStream != null)
                    fileInputStream.close();
                if(fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
