package com.javarush.task.task18.task1801;

import java.io.*;
import java.util.Arrays;

/* 
Максимальный байт
Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться максимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = null;
        FileInputStream fileInputStream = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bufferedReader.readLine();
            fileInputStream = new FileInputStream(fileName);
            int[] arrayByte = new int[fileInputStream.available()];
            for(int i = 0; i < fileInputStream.available(); i++) {
                arrayByte[i] = fileInputStream.read();
            }
            Arrays.sort(arrayByte);
            System.out.println(arrayByte[arrayByte.length - 1]);
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
