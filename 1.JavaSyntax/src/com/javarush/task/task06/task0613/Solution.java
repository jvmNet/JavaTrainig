package com.javarush.task.task06.task0613;

/* 
Кот и статика
В классе Cat создай статическую переменную public int catCount.
Создай конструктор [public Cat()]. Пусть при каждом создании кота (нового объекта Cat)
статическая переменная catCount увеличивается на 1. Создать 10 объектов Cat и вывести значение переменной catCount на экран.


Требования:
1. В классе Cat создай статическую переменную public int catCount.
2. В классе Cat создай конструктор public Cat() без параметров.
3. Конструктор должен увеличивать значение статической переменной catCount на 1.
4. В методе main создай 10 котов.
5. В методе main, после создания всех котов, выведи значение переменной catCount.
*/

public class Solution {
    public static void main(String[] args) {
        // Создай 10 котов

        int amountCat = 10;
        while(amountCat > 0){
            new Cat();
            amountCat--;
        }

        // Выведи значение переменной catCount

        System.out.println(Cat.catCount);
    }

    public static class Cat {
        // Создай статическую переменную catCount

        public static int catCount = 0;

        // Создай конструктор


        public Cat() {
            Cat.catCount++;
        }
    }
}
