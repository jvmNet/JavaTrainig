package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
1. В классе Cat добавь публичную статическую переменную cats (ArrayList<Cat>).
2. Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот.
Создать 10 объектов Cat.
3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.


Требования:
1. Добавь в класс Cat публичную статическую переменную cats (ArrayList<Cat>).
2. Переменная cats должна быть проинициализирована.
3. Метод main должен создавать 10 объектов Cat (используй конструктор Cat()).
4. Метод main должен добавить всех созданных котов в переменную cats.
5. Метод printCats должен выводить всех котов из переменной cats на экран. Каждого с новой строки.
*/

public class Cat {
    //напишите тут ваш код

    public static ArrayList<Cat> cats;

    public Cat() {
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        Cat.cats = new ArrayList<Cat>();
        int amountCats = 10;
        while(amountCats > 0){
            cats.add(new Cat());
            amountCats--;
        }
        printCats();
    }

    public static void printCats() {
        //напишите тут ваш код
        Cat.cats.forEach(System.out::println);
    }
}
