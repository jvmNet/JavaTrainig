package com.javarush.task.task04.task0403;

/* 
Как зовут кота?
Помогите коту обрести имя с помощью метода setName.


Требования:
1. Класс Cat должен содержать только одну переменную name.
2. Переменная name должна иметь модификатор доступа private и тип String.
3. Класс Cat должен содержать только два метода setName и main.
4. Метод setName класса Cat должен устанавливать значение переменной private String name равным переданному параметру String name.
*/

public class Cat {
    private String name = "безымянный кот";

    public void setName(String name) {
        //напишите тут ваш код
        this.name = name;
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("Жужик");
        System.out.println(cat.name);
    }
}
