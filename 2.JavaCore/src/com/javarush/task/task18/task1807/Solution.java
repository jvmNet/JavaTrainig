package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
С консоли считать имя файла.
Посчитать в файле количество символов ',', количество вывести на консоль.
Закрыть потоки.

Подсказка:
нужно сравнивать с ascii-кодом символа ','.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должно выводится число запятых в считанном файле.
4. Поток чтения из файла должен быть закрыт.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        FileInputStream fileInputStream = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            fileInputStream = new FileInputStream(bufferedReader.readLine());

            if(fileInputStream.available() > 0) {

                // read file
                byte[] buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer, 0, fileInputStream.available());

                // count comma
                int countComma = 0;
                for(int i = 0; i < buffer.length; i++) {
                    if(buffer[i] == 44)
                        countComma++;
                }

                // out in console
                System.out.println(countComma);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
             {
                try {
                    if(bufferedReader != null)
                        bufferedReader.close();
                    if(fileInputStream != null)
                        fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
