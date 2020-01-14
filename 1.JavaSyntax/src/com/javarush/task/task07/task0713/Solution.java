package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число нацело делится на 3 (x%3==0), нацело делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
Порядок объявления списков очень важен.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2,
потом последний.


Требования:
1. Объяви и сразу проинициализируй 4 переменных типа ArrayList<Integer> (список целых чисел). Первый список будет главным, а остальные - дополнительными.
2. Считать 20 чисел с клавиатуры и добавить их в главный список.
3. Добавить в первый дополнительный список все числа из главного, которые нацело делятся на 3.
4. Добавить во второй дополнительный список все числа из главного, которые нацело делятся на 2.
5. Добавить в третий дополнительный список все остальные числа из главного.
6. Метод printList должен выводить на экран все элементы переданного списка, каждый с новой строки.
7. Программа должна вывести три дополнительных списка, используя метод printList.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> allListDigits = new ArrayList<Integer>();
        ArrayList<Integer> oddListDigits = new ArrayList<Integer>();
        ArrayList<Integer> evenListDigits = new ArrayList<Integer>();
        ArrayList<Integer> otherListDigits = new ArrayList<Integer>();

        // add digits to -> allListDigits
        int amountDigitsList = 20;
        while(amountDigitsList > 0){
            allListDigits.add(Integer.parseInt(bufferedReader.readLine()));
            amountDigitsList--;
        }

        allListDigits.forEach(digit -> {
            if(digit%3 == 0 && digit%2 == 0) {
                oddListDigits.add(digit);
                evenListDigits.add(digit);
            } else if(digit%3 == 0) {
                oddListDigits.add(digit);
            } else if(digit%2 == 0) {
                evenListDigits.add(digit);
            } else {
                otherListDigits.add(digit);
            }
        });

        printList(oddListDigits);
        printList(evenListDigits);
        printList(otherListDigits);

    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код

        for(Integer digit : list)
            System.out.println(digit);

    }
}
