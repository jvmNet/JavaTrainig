package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
1. Введи с клавиатуры 10 слов в список строк.
2. Определить, является ли список упорядоченным по возрастанию длины строки.
3. В случае отрицательного ответа вывести на экран индекс первого элемента, нарушающего такую упорядоченность.


Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Считай 10 строк с клавиатуры и добавь их в список.
3. Если список упорядочен по возрастанию длины строки, то ничего выводить не нужно.
4. Если список не упорядочен по возрастанию длины строки,
то нужно вывести на экран индекс первого элемента, нарушающего такую упорядоченность.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();

        int amountWords = 10;
        while(amountWords > 0){
            list.add(bufferedReader.readLine());
            amountWords--;
        }

        // check sorted
        int count = 0;
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i).length() < list.get(i + 1).length()){
                count++;
            } else {
                break;
            }
        }

        // out index no sorted
        if(count > 0 && count != list.size() - 1)
            System.out.println(count + 1);

    }
}

