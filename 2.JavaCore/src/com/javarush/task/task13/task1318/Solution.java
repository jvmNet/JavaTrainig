package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.


Требования:
1. Программа должна считывать c консоли имя файла.
2. Программа должна выводить на экран содержимое файла.
3. Поток чтения из файла (FileInputStream) должен быть закрыт.
4. BufferedReader также должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader bufferedReader = null;
        InputStream fileInputStream = null;
        String fileName = null;
        try{

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            fileName = bufferedReader.readLine();
            fileInputStream = new FileInputStream(fileName);

            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer, 0 , fileInputStream.available());
            for(int i = 0; i < buffer.length; i++)
                System.out.print((char)buffer[i]);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
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