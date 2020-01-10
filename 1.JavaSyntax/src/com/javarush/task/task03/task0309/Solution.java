package com.javarush.task.task03.task0309;

/* 
Сумма 5 чисел

Требования:
1. Программа должна выводить текст.
2. Выведенный текст должен содержать 5 строк.
3. Число в каждой новой строке должно быть больше предыдущего.
4. Выводимый текст должен соответствовать заданию.

*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int tmp = 0;
        for(int i = 1; i < 6; i++){
            tmp+= i;
            System.out.println(tmp);
        }

    }
}
