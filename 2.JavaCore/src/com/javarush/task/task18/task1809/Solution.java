package com.javarush.task.task18.task1809;

/* 
Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
3. Во второй файл нужно записать все байты из первого в обратном порядке.
4. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            fileInputStream = new FileInputStream(bufferedReader.readLine());
            fileOutputStream = new FileOutputStream(bufferedReader.readLine());

            byte[] buffer = new byte[fileInputStream.available()];
            if(fileInputStream.available() > 0) {
                int length = fileInputStream.available();
                fileInputStream.read(buffer, 0, length);

                // write reverse in second file
                for(int i = length - 1; i >= 0; i--) {
                    fileOutputStream.write((int)buffer[i]);
                }
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
