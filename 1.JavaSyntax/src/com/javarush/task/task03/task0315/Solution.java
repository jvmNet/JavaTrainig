package com.javarush.task.task03.task0315;

/* 
Каждый охотник желает знать…

Требования:
1. Программа должна выводить текст.
2. Нужно создать 7 различных объектов, отвечающих за цвета.
3. Порядок создания объектов должен соответствовать порядку цветов в радуге.
4. Классы отвечающие за цвета изменять нельзя.
5. Выведенный текст должен соответствовать заданию.

*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        new Red();
        new Orange();
        new Yellow();
        new Green();
        new Blue();
        new Indigo();
        new Violet();
    }

    public static class Red {
        public Red() {
            System.out.println("Red");
        }
    }

    public static class Orange {
        public Orange() {
            System.out.println("Orange");
        }
    }

    public static class Yellow {
        public Yellow() {
            System.out.println("Yellow");
        }
    }

    public static class Green {
        public Green() {
            System.out.println("Green");
        }
    }

    public static class Blue {
        public Blue() {
            System.out.println("Blue");
        }
    }

    public static class Indigo {
        public Indigo() {
            System.out.println("Indigo");
        }
    }

    public static class Violet {
        public Violet() {
            System.out.println("Violet");
        }
    }
}
