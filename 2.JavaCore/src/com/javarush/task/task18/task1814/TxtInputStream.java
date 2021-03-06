package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
UnsupportedFileName
Измени класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt).
Например, first.txt или name.1.part3.txt.
Если передан не txt-файл, например, file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException.
Подумай, что еще нужно сделать, в случае выброшенного исключения.


Требования:
1. Класс TxtInputStream должен наследоваться от класса FileInputStream.
2. Если в конструктор передан txt-файл, TxtInputStream должен вести себя, как обычный FileInputStream.
3. Если в конструктор передан не txt-файл, должно быть выброшено исключение UnsupportedFileNameException.
4. В случае выброшенного исключения, так же должен быть вызван super.close().
*/

public class TxtInputStream extends FileInputStream {

    private FileInputStream fileInputStream;

    public TxtInputStream(final String fileName) throws FileNotFoundException,
            UnsupportedFileNameException
    {
        super(fileName);

//        String[] txt = fileName.split("\\.");
//        if(txt[txt.length - 1].equals("txt")) {
        if(fileName.endsWith(".txt")) {
            fileInputStream = new FileInputStream(fileName);
        } else {
            try {
                super.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            throw new UnsupportedFileNameException();
        }

    }

    public static void main(String[] args) {

    }
}

