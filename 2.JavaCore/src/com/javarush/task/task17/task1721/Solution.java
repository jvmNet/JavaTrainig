package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла.
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines.
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines
 все строки, которые есть в forRemoveLines.
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.


Требования:
1. Класс Solution должен содержать public static поле allLines типа List<String>.
2. Класс Solution должен содержать public static поле forRemoveLines типа List<String>.
3. Класс Solution должен содержать public void метод joinData() который может бросать исключение CorruptedDataException.
4. Программа должна считывать c консоли имена двух файлов.
5. Программа должна считывать построчно данные из первого файла в список allLines.
6. Программа должна считывать построчно данные из второго файла в список forRemoveLines.
7. Метод joinData должен удалить в списке allLines все строки из списка forRemoveLines, если в
allLines содержаться все строки из списка forRemoveLines.
8. Метод joinData должен очистить список allLines и выбросить исключение CorruptedDataException, если
в allLines не содержаться все строки из списка forRemoveLines.
9. Метод joinData должен вызываться в main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    static {
        init(allLines);
        init(forRemoveLines);
    }

    public static void main(String[] args) {

//        allLines.forEach(System.out::println);
//        forRemoveLines.forEach(System.out::println);

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

//        allLines.forEach(System.out::println);
//        forRemoveLines.forEach(System.out::println);

    }

    public void joinData() throws CorruptedDataException {
        List<String> resultCheck = new ArrayList<>();
        for(String str : forRemoveLines) {
            for(String innerStr : allLines) {
                if(str.equals(innerStr))
                    resultCheck.add(innerStr);
            }
        }
        System.out.println("array size: " + resultCheck.size() + " - " + forRemoveLines.size());
        if(resultCheck.size() == forRemoveLines.size()) {
            allLines.removeAll(resultCheck);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }

    private static void init(final List<String> data) {
        ReadFile readFile = null;
        try {
            readFile = new ReadFile();
            readFile.join();
            data.addAll(readFile.getData());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ReadFile extends Thread {

        private String fileName = null;
        private List<String> data = null;
        private BufferedReader bufferedReader = null;

        public ReadFile() {
            this.data = new ArrayList<String>();
            start();
        }

        public List<String> getData() {
            return this.data;
        }

        @Override
        public void run() {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                this.fileName  = bufferedReader.readLine();
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.fileName)));
                String line = null;
                while((line = bufferedReader.readLine()) != null) {
                    data.add(line);
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
    }

}
