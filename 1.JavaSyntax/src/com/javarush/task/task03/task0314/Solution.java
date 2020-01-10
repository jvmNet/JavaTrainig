package com.javarush.task.task03.task0314;

/* 
Таблица умножения

Требования:
1. Программа должна выводить текст.
2. Выведенный текст должен содержать 10 строк.
3. Каждая выведенная строка должна содержать 10 чисел, разделенных пробелом.
4. Выведенные числа должны быть таблицей умножения.

*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        for(int i = 1; i <= 10; i++){
            for(int y = 1; y <= 10; y++){
                System.out.print((i * y) + " ");
            }
            System.out.println();
        }
    }
}
