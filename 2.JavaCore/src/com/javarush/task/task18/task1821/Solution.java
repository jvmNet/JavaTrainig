package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
','=44, 's'=115, 't'=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.

Пример вывода:
, 19
- 7
f 361


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
4. Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
5. Поток для чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {

        FileInputStream fileInputStream = null;
        Map<Byte, Integer> result = new TreeMap<Byte, Integer>();
        byte[] buffer = null;

        try {

            fileInputStream = new FileInputStream(args[0]);

            if(fileInputStream.available() > 0) {
                buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer, 0, fileInputStream.available());
            }

            int count = 0;
            if(buffer != null)
            for(int i = 0; i < buffer.length; i++) {
                if(result.get(buffer[i]) == null) {
                    count = 1;
                } else {
                    count = result.get(buffer[i]);
                    count++;
                }
                result.put(buffer[i], count);
            }

            for(Map.Entry<Byte, Integer> pair : result.entrySet()) {
                char symbol = (char)(int)pair.getKey();
                System.out.println(symbol + " " + pair.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
