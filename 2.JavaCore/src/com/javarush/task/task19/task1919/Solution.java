package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль каждое имя и сумму всех его значений,
все данные должны быть отсортированы в возрастающем порядке по имени.
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;
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

            result.forEach((k, v) -> {
                System.out.println(k + " " + v);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
