package com.javarush.task.task18.task1819;

/* 
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Не используй в программе статические переменные.
3. Для первого файла создай поток для чтения и считай его содержимое.
4. Затем, для первого файла создай поток для записи(поток для записи должен быть один). Для второго - для чтения.
5. Содержимое первого и второго файла нужно объединить в первом файле.
6. Сначала должно идти содержимое второго файла, затем содержимое первого.
7. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        String fileName1 = null;
        String fileName2 = null;
        FileInputStream fileInputStream1 = null;
        FileInputStream fileInputStream2 = null;
        FileOutputStream fileOutputStream = null;
        byte[] buffer1 = null;
        byte[] buffer2 = null;

        try {

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            fileName1 = bufferedReader.readLine();
            fileName2 = bufferedReader.readLine();

            fileInputStream1 = new FileInputStream(fileName1);
            if(fileInputStream1.available() > 0) {
                buffer1 = new byte[fileInputStream1.available()];
                fileInputStream1.read(buffer1, 0, fileInputStream1.available());
            }

            fileInputStream2 = new FileInputStream(fileName2);
            if(fileInputStream2.available() > 0) {
                buffer2 = new byte[fileInputStream2.available()];
                fileInputStream2.read(buffer2, 0, fileInputStream2.available());
            }


            fileOutputStream = new FileOutputStream(fileName1);
            if(buffer2 != null)
                fileOutputStream.write(buffer2);
            if(buffer1 != null)
                fileOutputStream.write(buffer1);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bufferedReader != null)
                    bufferedReader.close();
                if(fileInputStream1 != null)
                    fileInputStream1.close();
                if(fileInputStream2 != null)
                    fileInputStream2.close();
                if(fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
