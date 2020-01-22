package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Парсер реквестов
Считать с консоли URL-ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Выводить параметры нужно в той же последовательности, в которой они представлены в URL.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк
Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.

Пример 1

Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

Вывод:
lvl view name

Пример 2

Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double: 3.14


Требования:
1. Программа должна считывать с клавиатуры только одну строку.
2. Класс Solution не должен содержать статические поля.
3. Программа должна выводить данные на экран в соответствии с условием.
4. Программа должна вызывать метод alert с параметром double в случае, если значение параметра
obj может быть корректно преобразовано в число типа double.
5. Программа должна вызывать метод alert с параметром String в случае, если значение параметра
obj НЕ может быть корректно преобразовано в число типа double.
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here

        BufferedReader bufferedReader = null;
        String key      = null;
        String valueObj = null;

        try {

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String urlSplitValues = bufferedReader.readLine().split("\\?")[1];
            List<String> urlParseValues = new ArrayList<String>(Arrays.asList(urlSplitValues.split("&")));
            for (int i = 0; i < urlParseValues.size(); i++) {
                key = urlParseValues.get(i).split("=")[0];
                if(key.equals("obj") && urlParseValues.get(i).split("=").length > 1)
                    valueObj = urlParseValues.get(i).split("=")[1];
                if(i != urlParseValues.size() - 1)
                    System.out.print(key + " ");
                else
                    System.out.print(key + "\n");
            }

            // alert double
            if(valueObj != null)
                alert(Double.parseDouble(valueObj));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // alert - String
            alert(valueObj);
        }  finally {
            try {
                if(bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }

}
