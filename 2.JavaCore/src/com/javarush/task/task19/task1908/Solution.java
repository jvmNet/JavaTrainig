package com.javarush.task.task19.task1908;

/* 
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8ю 1

Результат:
12 14 1


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором принимающим FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл все числа, через пробел,
из первого файла (используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        String fileInputStream = null;
        String fileOutputName = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            fileInputStream = bufferedReader.readLine();
            fileOutputName = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuffer inputBuffer = null;
        StringBuffer outputBuffer = null;

        try {
            if(fileInputStream != null)
                bufferedReader = new BufferedReader(new FileReader(fileInputStream));
            inputBuffer = new StringBuffer();
            while(bufferedReader.ready()) {
                inputBuffer.append((char)bufferedReader.read());
            }

            outputBuffer = new StringBuffer();
            for(String n : inputBuffer.toString()
                    .replaceAll("\n", "").split(" "))
            {
                if(isInteger(n) && n != null)
                    outputBuffer.append(n).append(" ");
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedWriter bufferedWriter = null;

        try {
            if(fileOutputName != null)
                bufferedWriter = new BufferedWriter(new FileWriter(fileOutputName));
            if(outputBuffer != null && bufferedWriter != null) {
                bufferedWriter.write(outputBuffer.toString());
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static boolean isInteger(final String sD) {
        boolean check = false;
        try {
            int temp = Integer.parseInt(sD);
            check = true;
        } catch (NumberFormatException e) {
        }
        return check;
    }

}
