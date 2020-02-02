package com.javarush.task.task18.task1820;

/* 
Округление чисел
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения. Для второго - поток для записи.
3. Считать числа из первого файла, округлить их и записать через пробел во второй.
4. Должны соблюдаться принципы округления, указанные в задании.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Solution {
    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        BufferedReader fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            fileInputStream = new BufferedReader(new FileReader(bufferedReader.readLine()));
            fileOutputStream = new FileOutputStream(bufferedReader.readLine());

            String line = null;
            List<String> lineData = new ArrayList<String>();
            while((line = fileInputStream.readLine()) != null) {
                lineData.add(line.trim());
            }

            List<Long> data = new ArrayList<Long>();
            for(String str : lineData) {
                for(String val : str.split(" ")) {
                    if(!val.isEmpty())
                        data.add(Math.round(Double.parseDouble(val)));
                }
            }

            StringJoiner stringJoiner = new StringJoiner(" ");
            for(Long digit : data) {
                stringJoiner.add(digit.toString());
            }

            fileOutputStream.write(stringJoiner.toString().getBytes());

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

    private static String parseDouble(final StringBuffer s) {
        String result = "";
        try {
            result = String.valueOf(Math.round(Double.parseDouble(s.toString()))) + " ";
        } catch (NumberFormatException e) {
            return result;
        }
        return result;
    }

}
