package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.

Пример ввода:
5
8
-2
11
3
-5
2
10

Пример вывода:
-2
2
8
10


Требования:
1. Программа должна считывать данные с консоли.
2. Программа должна создавать FileInputStream для введенной с консоли строки.
3. Программа должна выводить данные на экран.
4. Программа должна вывести на экран все четные числа считанные из файла отсортированные по возрастанию.
5. Программа должна закрывать поток чтения из файла(FileInputStream).
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код

        BufferedReader bufferedReader = null;
        FileInputStream fileInputStream = null;
        String fileName = null;
        List<Integer> arrayDigits = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();

        try {

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            fileName = bufferedReader.readLine();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            String digit = null;
            while((digit = bufferedReader.readLine()) != null){
                arrayDigits.add(Integer.parseInt(digit));
            }
            arrayDigits.sort(Integer::compareTo);
            for(Integer n : arrayDigits)
                if(n%2 == 0)
                    System.out.println(n);

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
