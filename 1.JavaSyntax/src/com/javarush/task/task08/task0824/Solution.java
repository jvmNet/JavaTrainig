package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Собираем семейство
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Выведи все объекты Human на экран (Подсказка: используй метод toString() класса Human).


Требования:
1. Программа должна выводить текст на экран.
2. Класс Human должен содержать четыре поля.
3. Класс Human должен содержать один метод.
4. Класс Solution должен содержать один метод.
5. Программа должна создавать объекты и заполнять их так, чтобы получилось:
два дедушки, две бабушки, отец, мать, трое детей и выводить все объекты Human на экран.
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        final Human daughter = new Human("Maria", false, 12, new ArrayList<Human>());
        final Human son1 = new Human("Andrey", true, 15, new ArrayList<Human>());
        final Human son2 = new Human("Vladimir", true, 19, new ArrayList<Human>());

        ArrayList<Human> childParent = new ArrayList<Human>(Arrays.asList(daughter, son1, son2));
        final Human father = new Human("Igor",
                true,
                55,
                childParent);
        final Human mother = new Human("Veronika",
                false,
                49,
                childParent);


        ArrayList<Human> childGrandParentList2 = new ArrayList<Human>(Arrays.asList(mother));
        final Human grandmother2 = new Human("Irina",
                false,
                75,
                childGrandParentList2);
        final Human grandfather2 = new Human("Petr",
                true,
                82,
                childGrandParentList2);

        ArrayList<Human> childGrandParentList1 = new ArrayList<Human>(Arrays.asList(father));
        final Human grandmother1 = new Human("Kristina",
                false,
                72,
                childGrandParentList1);
        final Human grandfather1 = new Human("Vasiliy",
                true,
                80,
                childGrandParentList1);

        ArrayList<Human> family = new ArrayList<Human>(Arrays.asList(
                grandfather1,
                grandfather2,
                grandmother1,
                grandmother2,
                father,
                mother,
                daughter,
                son1,
                son2
        ));
        for(Human human : family)
            System.out.println(human.toString());

    }

    public static class Human {
        //напишите тут ваш код

        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
