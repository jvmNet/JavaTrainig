package com.javarush.task.task04.task0408;

/* 
Хорошо или плохо?
Написать метод compare(int a), чтобы он:
- выводил на экран строку "Число меньше 5", если параметр метода меньше 5,
- выводил строку "Число больше 5", если параметр метода больше 5,
- выводил строку "Число равно 5", если параметр метода равен 5.


Требования:
1. Программа должна выводить текст на экран.
2. Метод main не должен вызывать System.out.println или System.out.print.
3. Метод main должен вызывать метод compare.
4. Метод compare должен быть void.
5. Метод compare должен выводить текст на экран согласно заданию.
*/

public class Solution {
    public static void main(String[] args) {
        compare(3);
        compare(6);
        compare(5);
    }

    public static void compare(int a) {
        //напишите тут ваш код
        if(a < 5){
            System.out.println("Число меньше 5");
        } else if(a > 5){
            System.out.println("Число больше 5");
        } else {
            System.out.println("Число равно 5");
        }
    }
}