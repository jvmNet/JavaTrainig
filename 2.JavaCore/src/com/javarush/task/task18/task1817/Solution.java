package com.javarush.task.task18.task1817;

/* 
Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45.
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой.
4. Закрыть потоки.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. Посчитай отношение пробелов ко всем символам в файле и выведи в консоль это число.
4. Выведенное значение необходимо округлить до 2 знаков после запятой.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileReader fr = null;
        StringBuffer sb = null;

        try {

            fr = new FileReader(args[0]);
            sb = new StringBuffer();

            while (fr.ready()) {
                sb.append(String.valueOf((char) fr.read()).toLowerCase());
            }

            byte[] buffer = sb.toString().getBytes();
            int countSymbols = 0;
            int countSpace = 0;
            for (int i = 0; i < buffer.length; i++) {
                countSymbols++;
                if (buffer[i] == 32)
                    countSpace++;
            }

            double result = new BigDecimal((double) countSpace / countSymbols * 100)
                    .setScale(2, RoundingMode.UP)
                    .doubleValue();

            System.out.println(result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                        fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
