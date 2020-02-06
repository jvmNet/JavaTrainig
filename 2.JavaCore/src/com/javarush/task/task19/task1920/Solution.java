package com.javarush.task.task19.task1920;

/* 
Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль имена, у которых максимальная сумма.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader(args[0])) {

            TreeMap<String, Double> result = new TreeMap<String, Double>();

            List<String> buffer = new BufferedReader(fileReader).lines().collect(Collectors.toList());

            for(String line : buffer) {
                String[] person = line.split(" ");
                for(int i = 1; i < person.length; i++) {
                    Double value = result.get(person[0]);
                    if(value == null) {
                        result.put(person[0], Double.valueOf(person[i]));
                    } else {
                        result.put(person[0], value + Double.parseDouble(person[i]));
                    }
                }
            }

            double max = Collections.max(result.entrySet(), Comparator.comparingDouble(Map.Entry::getValue)).getValue();
            for(Map.Entry<String, Double> person : result.entrySet()) {
                if(person.getValue() == max)
                    System.out.println(person.getKey());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
