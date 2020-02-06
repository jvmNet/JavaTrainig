package com.javarush.task.task19.task1925;

/* 
Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать через запятую во второй файл
 все слова из первого файла длина которых строго больше 6(используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {

        String fileNameInput = args[0];
        String fileNameOutput = args[1];

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileNameInput));
             FileWriter fileWriter = new FileWriter(fileNameOutput))
        {

            List<String> dataFile = fileReader.lines().collect(Collectors.toList());

            StringJoiner result = new StringJoiner(",");
            for(String line : dataFile) {
                for(String word : line.split(" ")) {
                    if(word.length() > 6) {
                        result.add(word);
                    }
                }
            }

            fileWriter.write(result.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
