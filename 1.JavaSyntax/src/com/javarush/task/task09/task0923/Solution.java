package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;

/* 
Гласные и согласные
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы из введённой строки.
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.
Пример ввода:
Мама мыла раму.

Пример вывода:
а а ы а а у
М м м л р м .


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить две строки.
3. Первая строка должна содержать только гласные буквы из введенной строки, разделенные пробелом.
4. Вторая строка должна содержать только согласные и знаки препинания из введенной строки, разделенные пробелом.
5. Каждая строка должна заканчиваться пробелом.
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> vowelsLetter = new ArrayList<String>();
        ArrayList<String> otherLetter = new ArrayList<String>();

        String inputStr = bufferedReader.readLine();

        char[] arrayLetterInput = inputStr.toCharArray();

        for(int i = 0; i < arrayLetterInput.length; i++){
            if(isVowel(arrayLetterInput[i])){
                vowelsLetter.add(String.valueOf(arrayLetterInput[i]));
            } else if (arrayLetterInput[i] != ' ') {
                otherLetter.add(String.valueOf(arrayLetterInput[i]));
            }
        }

        for(int i = 0; i < vowelsLetter.size(); i++){
            if(i < vowelsLetter.size() - 1)
                System.out.print(vowelsLetter.get(i) + " ");
            else
                System.out.println(vowelsLetter.get(i) + " ");
        }

        for(String str : otherLetter)
            System.out.print(str + " ");

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}