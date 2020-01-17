package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 маленьких букв алфавита).
Результат вывести на экран в алфавитном порядке.

Пример вывода:
а 5
б 8
в 3
г 7
д 0
...
я 9


Требования:
1. Программа должна 10 раз считывать данные с клавиатуры.
2. Программа должна выводить текст на экран.
3. Выведенный текст должен содержать 33 строки.
4. Каждая строка вывода должна содержать букву русского алфавита,
пробел и сколько раз буква встречалась в введенных строках.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а','б','в','г','д','е','ё','ж',
                'з','и','й','к','л','м','н','о',
                'п','р','с','т','у','ф','х','ц',
                'ч','ш','щ','ъ','ы','ь','э','ю','я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        // напишите тут ваш код
//        Map<Character, Integer> result = new TreeMap<Character, Integer>();
//        for(Character letter : alphabet)
//            result.put(letter, 0);
//
//        for(String str : list){
//            for(Map.Entry<Character, Integer> pair : result.entrySet()){
//                char letter = pair.getKey();
//                int amountStrLetter = countLetter(letter, str);
//
//                pair.setValue(pair.getValue() + amountStrLetter);
//            }
//        }
//
//        for(Map.Entry<Character, Integer> pair : result.entrySet())
//            System.out.println(pair.getKey() + " " + pair.getValue());

        // напишите тут ваш код
        // fix - е -> ё
        List<ArrayList<String>> result = new ArrayList<>();
        for(int i = 0; i < alphabet.size(); i++) {
            ArrayList<String> strItem = new ArrayList<String>();
            strItem.add(0, String.valueOf(alphabet.get(i)));
            strItem.add(1, "0");
            result.add(i, strItem);
        }

        for(String str : list){
            for(List<String> item : result){
                char letter = item.get(0).charAt(0);

                int amountStrLetter = countLetter(letter, str) + Integer.parseInt(item.get(1));
                item.remove(1);
                item.add(1, String.valueOf(amountStrLetter));

            }
        }

        for(List<String> item : result){
            System.out.println(item.get(0) + " " + item.get(1));
        }

    }

    private static int countLetter(char letter, String str) {
        int count = 0;
        char[] strToArray = str.toCharArray();
        for(int i = 0; i < strToArray.length; i++){
            if(Character.compare(letter, strToArray[i]) == 0){
                count++;
            }
        }
        return count;
    }

}
