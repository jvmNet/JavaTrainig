package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id - int.
productName - название товара, может содержать пробелы, String.
price - цена, double.
quantity - количество, int.

Информация по каждому товару хранится в отдельной строке.


Требования:
1. Программа должна считать имя файла с консоли.
2. Создай для файла поток для чтения.
3. Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
4. Поток для чтения из файла должен быть закрыт.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

        final String id = args[0];
        String fileName = null;
        BufferedReader bufferedReader = null;

        try {

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            fileName = bufferedReader.readLine();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            String line = null;
            String[] data = null;
            boolean check = false;
            String result = null;
            while((line = bufferedReader.readLine()) != null) {
                data = line.split(" ");
                for(int i = 0; i < data.length; i++) {
                    if(data[0].equals(id)) {
                        result = line;
                        check = true;
                    }
                }
                if(check)
                    break;
            }

            System.out.println(result);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
