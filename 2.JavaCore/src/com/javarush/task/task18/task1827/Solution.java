package com.javarush.task.task18.task1827;

/* 
Прайсы
CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.

Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
где id - 8 символов.
productName - название товара, 30 символов.
price - цена, 8 символов.
quantity - количество, 4 символа.
-c - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно,
инкрементируя максимальный id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. В классе Solution не должны быть использованы статические переменные.
3. При запуске программы без параметров список товаров должен остаться неизменным.
4. При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая
строка с товаром.
5. Товар должен иметь следующий id, после максимального, найденного в файле.
6. Форматирование новой строки товара должно четко совпадать с указанным в задании.
7. Созданные для файлов потоки должны быть закрыты.
*/


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.StringJoiner;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String fileName = null;
        StringJoiner inputParams = new StringJoiner(" ");

        String checkKey = "";
        String key = "";
        String price = "";
        String quantity = "";
        String title = "";

        if(args.length > 0) {

            for (String param : args) inputParams.add(param);

            checkKey = new StringBuffer(inputParams.toString().trim()).substring(0, 2);
            key = checkKey.equals("-c") ? checkKey : "";
            price = args[args.length - 2].trim();
            quantity = args[args.length - 1].trim();
            title = inputParams
                    .toString()
                    .replace(key, "")
                    .replace(price, "")
                    .replace(quantity, "")
                    .trim();

        }

        if(key.equals("-c")) {

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            fileName = bufferedReader.readLine();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            String line = null;
            int id = 0;
            TreeSet<String> dataFile = new TreeSet<>();
            while((line = bufferedReader.readLine()) != null) {
                dataFile.add(line);
                int tempID = Integer.parseInt(line.substring(0, 8).trim());
                if(Integer.compare(tempID, id) > 0)
                    id = tempID;
            }
            bufferedReader.close();

            // id, price, product and quantity
            id++;
            double nPrice = 0d;
            int nQuantity = 0;
            try {
                nPrice = Double.parseDouble(price);
                nQuantity = Integer.parseInt(quantity);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            // create line product
            String newProduct = String.format(Locale.ROOT, "%-8s%-30s%-8s%-4s",
                    id, title, nPrice, nQuantity);

            // write file
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
            for(String product : dataFile) {

                Charset charset = StandardCharsets.UTF_8;
                ByteBuffer paramsBuffer = ByteBuffer.wrap(product.getBytes());
                CharBuffer charBuffer = charset.decode(paramsBuffer);

                bufferedWriter.write(String.valueOf(charBuffer) + "\n");

            }
            bufferedWriter.write(newProduct);
            bufferedWriter.close();

        }

    }

}
