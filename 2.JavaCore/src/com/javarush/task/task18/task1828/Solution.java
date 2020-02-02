package com.javarush.task.task18.task1828;

/* 
Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD

Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id

Значения параметров:
где id - 8 символов
productName - название товара, 30 символов
price - цена, 8 символов
quantity - количество, 4 символа
-u - обновляет данные товара с заданным id
-d - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19847   Шорты пляжные синие           159.00  12
198479  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами "-u id productName price quantity" должна обновится информация о товаре в файле.
4. При запуске программы с параметрами "-d id" строка товара с заданным id должна быть удалена из файла.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String fileName = null;

        String key = "";
        String id = "";
        String price = "";
        String quantity = "";
        String title = "";

        // init input params product
        if(args.length > 0) {

            StringJoiner inputParams = new StringJoiner(" ");
            for (String param : args) inputParams.add(param);

            key      = args[0].trim();
            id       = args[1].trim();
            price    = args[args.length - 2].trim();
            quantity = args[args.length - 1].trim();
            title = inputParams
                    .toString()
                    .replace(key, "")
                    .replace(id, "")
                    .replace(price, "")
                    .replace(quantity, "")
                    .trim();

        }

        try {

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            fileName = bufferedReader.readLine();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            List<String> dataFile = new LinkedList<String>();

            if(key.equals("-u")) {

                String updateLine = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    dataFile.add(line);
                    String tempID = line.substring(0, 8).trim();
                    if(tempID.equals(id))
                        updateLine = line;
                }
                bufferedReader.close();

                // update
                String newProduct = String.format(Locale.ROOT, "%-8s%-30s%-8s%-4s",
                                id, title, price, quantity);
                dataFile.set(dataFile.indexOf(updateLine), newProduct);

            } else if(key.equals("-d")) {

                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    String tempID = line.substring(0, 8).trim();
                    if(!tempID.equals(id)) {
                        dataFile.add(line);
                    }
                }
                bufferedReader.close();

            }

            if(dataFile.size() > 0) {

                // write file
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
                for (String product : dataFile) {

                    Charset charset = StandardCharsets.UTF_8;
                    ByteBuffer paramsBuffer = ByteBuffer.wrap(product.getBytes());
                    CharBuffer charBuffer = charset.decode(paramsBuffer);

                    bufferedWriter.write(String.valueOf(charBuffer) + "\n");

                }
                bufferedWriter.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bufferedReader != null)
                    bufferedReader.close();
                if(bufferedWriter != null)
                    bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
