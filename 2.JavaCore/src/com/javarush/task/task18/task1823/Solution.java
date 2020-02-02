package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        final String commandExit = "exit";
        String fileName = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while(!(fileName = bufferedReader.readLine()).equals(commandExit)) {
                new ReadThread(fileName).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
            super(fileName);
            //start();
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {

            FileReader fileReader = null;
            byte[] result = new byte[Byte.MAX_VALUE];

            try {
                fileReader = new FileReader(getName());
                while(fileReader.ready()) {
                    result[fileReader.read()]++;
                }
                int mByte = 0;
                int mCount = 0;
                for(int i = 0; i < result.length; i++) {
                    if(mCount < result[i]) {
                        mCount = result[i];
                        mByte = i;
                    }
                }
                resultMap.put(getName(), mByte);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(fileReader != null) {
                        fileReader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
