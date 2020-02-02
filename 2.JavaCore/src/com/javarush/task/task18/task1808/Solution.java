package com.javarush.task.task18.task1808;

/* 
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream2 = null;
        FileOutputStream fileOutputStream3 = null;
        String fileInputName1 = null;
        String fileOutputName2 = null;
        String fileOutputName3 = null;

        try {

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            fileInputName1 = bufferedReader.readLine();
            fileOutputName2 = bufferedReader.readLine();
            fileOutputName3 = bufferedReader.readLine();
            fileInputStream = new FileInputStream(fileInputName1);
            fileOutputStream2 = new FileOutputStream(fileOutputName2);
            fileOutputStream3 = new FileOutputStream(fileOutputName3);

            int countFirstFileWrite = (int)Math.ceil((double)fileInputStream.available() / 2);
            int countSecondFileWrite = fileInputStream.available() - countFirstFileWrite;

            // write first file
            if(countFirstFileWrite > 0) {
                byte[] buffer = new byte[countFirstFileWrite];
                fileInputStream.read(buffer, 0, countFirstFileWrite);
                fileOutputStream2.write(buffer);
            }

            // write second file
            if(countSecondFileWrite > 0) {
                byte[] buffer = new byte[countSecondFileWrite];
                fileInputStream.read(buffer, 0, countSecondFileWrite);
                fileOutputStream3.write(buffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bufferedReader != null)
                    bufferedReader.close();
                if(fileInputStream != null)
                    fileInputStream.close();
                if(fileOutputStream2 != null)
                    fileOutputStream2.close();
                if(fileOutputStream3 != null)
                    fileOutputStream3.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
