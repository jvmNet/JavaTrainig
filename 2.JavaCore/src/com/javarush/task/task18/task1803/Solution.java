package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = null;
        FileInputStream fileInputStream = null;
        String fileName = null;

        try {

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            fileName = bufferedReader.readLine();
            fileInputStream = new FileInputStream(fileName);

            // add buffer
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer, 0, fileInputStream.available());

            // add byte
            byte[] bytes = new byte[Byte.MAX_VALUE];
            for(int i = 0; i < buffer.length; i++) {
                bytes[buffer[i]]++;
            }

            // add map
            Map<Integer, Byte> result = new HashMap<Integer, Byte>();
            for(int i = 0; i < bytes.length; i++) {
                if(bytes[i] != 0) {
                    result.put(i, bytes[i]);
                }
            }

            // maximum byte
            byte maximum = 0;
            for (Map.Entry<Integer, Byte> pair : result.entrySet()) {
                if(maximum < pair.getValue())
                    maximum = pair.getValue();
            }

            // out in console
            for (Map.Entry<Integer, Byte> pair : result.entrySet()) {
                if (pair.getValue() == maximum)
                    System.out.print(pair.getKey() + " ");
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
