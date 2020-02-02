package com.javarush.task.task18.task1818;

/* 
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
*/


import java.io.*;

public class Solution {

    private static byte[] bufferFile2 = null;

    private static byte[] bufferFile3 = null;

    private static String[] fileNames = new String[3];

    private static void fileReading() {
        bufferFile2 = new ReadFile(fileNames[1]).getData();
        bufferFile3 = new ReadFile(fileNames[2]).getData();
    }

    private static void readConsole() {

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            for(int i = 0; i < fileNames.length; i++) {
                fileNames[i] = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

        FileOutputStream fileOutputStream = null;

        readConsole();

        fileReading();

        try {
             fileOutputStream = new FileOutputStream(fileNames[0]);
             fileOutputStream.write(bufferFile2);
             fileOutputStream.write(bufferFile3);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    static class ReadFile {

        private FileInputStream fileInputStream = null;

        private final String fileName;

        private byte[] buffer = null;

        public ReadFile(final String fileName) {
            this.fileName = fileName;
            readFile();
        }

        public byte[] getData() {
            return buffer;
        }

        public void readFile() {
            try {
                fileInputStream = new FileInputStream(fileName);
                if(fileInputStream.available() > 0) {
                    buffer = new byte[fileInputStream.available()];
                    fileInputStream.read(buffer, 0, fileInputStream.available());
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

}
