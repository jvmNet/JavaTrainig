package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
1. Создай список чисел.
2. Добавь в список 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.

Пример для списка 2, 4, 4, 4, 8, 8, 4, 12, 12, 14:
3

Искомое значение равно 3, т.к. самая длинная последовательность повторяющихся чисел состоит из трех четверок.


Требования:
1. Программа должна выводить число на экран.
2. Программа должна считывать значения с клавиатуры.
3. В методе main объяви переменную типа List с типом элементов Integer и сразу проинициализируй ee.
4. Программа должна добавлять в коллекцию 10 чисел, согласно условию.
5. Программа должна выводить на экран длину самой длинной последовательности повторяющихся чисел в списке.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> digitsList = new ArrayList<Integer>();

        int amountDigitsList = 10;
        while(amountDigitsList > 0){
            digitsList.add(Integer.parseInt(bufferedReader.readLine()));
            amountDigitsList--;
        }

        int maxlength = 1;
        int currentLength = 1;
        for(int i = 0; i < digitsList.size() - 1; i++){
            if(Integer.compare(digitsList.get(i), digitsList.get(i + 1)) == 0){
                currentLength++;
            } else {
                currentLength = 1;
            }
            if(maxlength < currentLength) {
                maxlength = currentLength;
            }
        }

        System.out.println(maxlength);

    }
}