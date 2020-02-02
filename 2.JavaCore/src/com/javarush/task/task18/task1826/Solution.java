package com.javarush.task.task18.task1826;

/* 
Шифровка
Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName - имя файла, который необходимо зашифровать/расшифровать.
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
-e - ключ указывает, что необходимо зашифровать данные.
-d - ключ указывает, что необходимо расшифровать данные.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
3. Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {

        final String encryptKey = "Gfhr%f)_ejkf_&u";

        final String commandKey = args[0];
        final String fileInputName = args[1];
        final String fileOutputName = args[2];

        switch (commandKey) {

            case "-e" : {
                 readWriteFile(encryptKey, "-e", fileInputName, fileOutputName);
            }
            break;

            case "-d" : {
                readWriteFile(encryptKey, "-d", fileInputName, fileOutputName);
            }
            break;

        }

    }

    private static void readWriteFile(final String encryptKey,
                                      final String commandKey,
                                      final String fileInputName,
                                      final String fileOutputName)
    {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {

            fileInputStream = new FileInputStream(fileInputName);

            List<Byte> bufferEncryptDecrypt = null;

            byte[] buffer = null;
            if(fileInputStream.available() > 0) {
                buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer, 0, fileInputStream.available());
            }

            fileInputStream.close();

            if(commandKey.equals("-e")) {
                bufferEncryptDecrypt = encrypt(encryptKey, buffer);
            } else if(commandKey.equals("-d")) {
                bufferEncryptDecrypt = decrypt(encryptKey, buffer);
            }

            byte[] bufferOutput = new byte[bufferEncryptDecrypt.size()];
            for(int i = 0; i < bufferOutput.length; i++) bufferOutput[i] = bufferEncryptDecrypt.get(i);
            fileOutputStream = new FileOutputStream(fileOutputName);
            fileOutputStream.write(bufferOutput);
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Byte> encrypt(final String key,
                                      final byte[] dataFile)
    {
        List<Byte> result = new ArrayList<Byte>();

        byte[] keyByte = key.getBytes();
        int sum = 0;
        for (byte b : keyByte) {
            sum += b;
        }

        int rangeRandom = Integer.parseInt(String.valueOf(
                new StringBuffer(String.valueOf(sum)).substring(0, 2)));

        for(int i = 0; i < dataFile.length; i++) {

            int byteEncrypt = sum + dataFile[i];

            Random rDigit = new Random();
            int digitOne = 0;
            int digitTwo = 0;
            do {
                digitOne = rDigit.nextInt(rangeRandom + 2);
                digitTwo = rDigit.nextInt(99);
            } while (digitOne < rangeRandom || digitTwo < 10);
            String sRandom = String.valueOf(digitOne) + String.valueOf(digitTwo);

            String sResultEncrypt = String.valueOf(byteEncrypt) + sRandom;
            char[] cResultEncrypt = sResultEncrypt.toCharArray();

            StringBuilder sBuffer = new StringBuilder();
            byte[] byteResultBuffer = new byte[cResultEncrypt.length / 2];

            int countByte = 0;
            for (int x = 0; x < cResultEncrypt.length; x++) {
                if (x % 2 != 0) {
                    sBuffer.append(cResultEncrypt[x - 1]).append(cResultEncrypt[x]);
                    byteResultBuffer[countByte] = Byte.parseByte(sBuffer.toString());
                    countByte++;
                }
                sBuffer.delete(0, sBuffer.length());
            }
            for (byte b : byteResultBuffer) result.add(b);
        }
        return result;
    }

    private static List<Byte> decrypt(final String key,
                                      final byte[] dataFile)
    {
        List<Byte> result = new ArrayList<Byte>();

        byte[] keyByte = key.getBytes();
        int sum = 0;
        for (byte b : keyByte) {
            sum += b;
        }

        StringBuilder stringBuffer = new StringBuilder();
        for(int i = 0; i < dataFile.length; i++) {

            String sByte = null;
            if(String.valueOf(dataFile[i]).length() == 1)
                sByte = "0" + String.valueOf(dataFile[i]);
            else
                sByte = String.valueOf(dataFile[i]);

            stringBuffer.append(sByte);
            if(stringBuffer.length() == 8) {
                int temp = Integer.parseInt(String.valueOf(stringBuffer.substring(0,4))) - sum;
                result.add((byte)temp);
                stringBuffer.delete(0, stringBuffer.length());
            }
        }
        return result;
    }

}
