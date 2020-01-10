package com.javarush.task.task03.task0312;

/* 
Конвертируем время

Требования:
1. Добавь метод convertToSeconds, он должен быть public static, возвращать и принимать int.
2. Метод convertToSeconds должен переводить переданные часы в секунды.
3. Метод main должен дважды вызывать метод convertToSeconds.
4. Метод main должен выводить результаты вызова на экран, каждый раз с новой строки.
5. Метод convertToSeconds не должен ничего выводить на экран.

*/

public class Solution {
    //напишите тут ваш код

    public static int convertToSeconds(int hour){
        int seconds = hour * 60 * 60;
        return seconds;
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println(convertToSeconds(1));
        System.out.println(convertToSeconds(5));
    }
}
