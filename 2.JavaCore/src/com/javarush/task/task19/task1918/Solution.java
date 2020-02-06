package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат.

Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

Первым параметром в метод main приходит тег. Например, "span".
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, \n, \r не влияют на результат.
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.

Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль все теги, которые соответствуют тегу, заданному в параметре метода main.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        String tag = args[0];

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine())))
        {

            String line = "";
            StringBuilder dataHTML = new StringBuilder();
            while((line = fileReader.readLine()) != null) dataHTML.append(line);

            List<String> paths = new ArrayList<>();
            parts(dataHTML, paths, tag);

            List<String> result = new ArrayList<>();

            result.add(paths.get(paths.size() - 1));
            for(int i = paths.size() - 1; i > 0; i--) {
                String temp = paths.get(i - 1).replace(paths.get(i), "");
                result.add(temp);
            }

            paths.clear();
            for(int i = result.size() - 1; i >= 0; i--) {
                int indexCloseTag = result.get(i).indexOf("</" + tag + ">");
                if(indexCloseTag == -1) {
                    result.add(i, result.remove(i) + result.get(i - 1));
                } else {
                    result.add(i, result.remove(i).substring(0, indexCloseTag + tag.length() + 3));
                }
                paths.add(result.get(i));
            }

            paths.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static StringBuilder parts(final StringBuilder data,
                                       final List<String> lineParts,
                                       final String tag)
    {
        int index = 0;
        if(data.length() > 0) {
            index = data.indexOf("<" + tag);
            if (index != -1)
                lineParts.add(data.substring(index, data.length()));
            data.delete(0, index + (tag.length() + 2));
            return parts(data, lineParts, tag);
        } else {
            return data;
        }

    }
}
