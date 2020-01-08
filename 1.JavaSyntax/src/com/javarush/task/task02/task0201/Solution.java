package com.javarush.task.task02.task0201;

/* 
Реализуем метод print
*/
public class Solution {
    public static void main(String[] args) {
        print("Java is easy to learn!");
        print("Java opens many opportunities!");
    }

    public static void print(String s) {
        //напишите тут ваш код
        for(int i = 0; i < 4; i++)
            System.out.println(s);
    }
}
