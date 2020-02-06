package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/* 
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013


Требования:
1. Класс Solution должен содержать публичную константу PEOPLE типа List<Person>,
которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна заполнить список PEOPLE данными из файла.
6. Программа должна правильно работать с двойными именами, например Анна-Надежда.
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {

        String fileName = args[0];

        try (FileReader fileReader = new FileReader(fileName))
        {

            List<String> lines = new BufferedReader(fileReader).lines().collect(Collectors.toList());

            for(String human : lines) {
                String[] description = human.split(" ");
                String datePart = description[description.length - 3] + " "
                        + description[description.length - 2] + " "
                        + description[description.length - 1];
                String name = human.replace(datePart, "");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
                Date birthday = null;
                try {
                    birthday = simpleDateFormat.parse(datePart.trim());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                PEOPLE.add(new Person(name.trim(), birthday));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
