package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенными пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {

        String fileNameRead = args[0];
        String fileNameWrite = args[1];

        try (FileReader fileReader = new FileReader(fileNameRead);
             FileWriter fileWrite = new FileWriter(fileNameWrite))
        {

            List<String> dataFile = new BufferedReader(fileReader).lines().collect(Collectors.toList());

            List<String> buffer = new ArrayList<>();
            for(String line : dataFile) {
                for(String word : line.split(" ")) {
                    for(char e : word.toCharArray()) {
                        if(Character.isDigit(e)) {
                            buffer.add(word);
                            break;
                        }
                    }
                }
            }

            StringJoiner result = new StringJoiner(" ");
            for(String w : buffer) result.add(w);

            fileWrite.write(result.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
