package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
Напиши класс Human с 6 полями.
Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. В классе Human должно быть 6 полей.
3. Все поля класса Human должны быть private.
4. В классе Human должно быть 10 конструкторов.
5. Все конструкторы класса Human должны быть public.
*/

import java.util.List;

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы

        private String name;
        private int age;
        private boolean sex;
        private String address;
        private List<Human> parent;
        private List<Human> children;

        public Human(){}

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, int age, boolean sex, String address) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.address = address;
        }

        public Human(String name, int age, boolean sex, String address, List<Human> parent) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.address = address;
            this.parent = parent;
        }

        public Human(String name, int age, boolean sex, String address, List<Human> parent, List<Human> children) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.address = address;
            this.parent = parent;
            this.children = children;
        }

        public Human(String name, int age, boolean sex, List<Human> parent) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.parent = parent;
        }

        public Human(String name, int age, List<Human> parent) {
            this.name = name;
            this.age = age;
            this.parent = parent;
        }

        public Human(String name, List<Human> children) {
            this.name = name;
            this.children = children;
        }
    }
}
