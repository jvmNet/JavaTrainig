package com.javarush.task.task04.task0440;

/* 
Достойная оплата труда
Используя цикл вывести на экран сто раз надпись:
"Я никогда не буду работать за копейки. Амиго"
Каждое значение вывести с новой строки.


Требования:
1. Программа не должна считывать текст c клавиатуры.
2. Программа должна выводить текст на экран.
3. Программа должна выводить 100 раз текст указанный в задании.
4. В программе должен использоваться цикл for или цикл while.
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int i = 100;
        while(i > 0){
            System.out.println("Я никогда не буду работать за копейки. Амиго");
            i--;
        }
    }
}
