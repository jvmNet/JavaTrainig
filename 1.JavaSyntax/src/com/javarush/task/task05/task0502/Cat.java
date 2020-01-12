package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Нужно сравнить каждый критерий по отдельности, и победителем будет тот, у которого больше "победивших" критериев.
Метод должен определять, выиграли ли мы (this) бой или нет, т.е. возвращать true, если выиграли и false - если нет.
Если ничья и никто не выиграл, возвращаем либо true либо false, но должно выполняться условие:
если cat1.fight(cat2) возвращает true,
то cat2.fight(cat1) должен возвращать false.


Требования:
1. Класс Cat должен содержать конструктор без параметров.
2. Класс Cat должен содержать всего три поля: age, weight и strength. Поля должны быть публичные.
3. В классе Cat должен быть метод fight.
4. В методе fight реализовать механизм драки котов в зависимости от их веса, возраста и силы согласно условию.
5. Метод должен возвращать одно и тоже значение, если мы деремся с одним и тем же котом.
6. Если некий кот1 выигрывает у кота кот2, то кот2 должен проигрывать коту кот1.
7. Если ничья, то метод fight должен возвращать false.
*/


public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код

        int age = 0;
        int weight = 0;
        int strength = 0;

        if(this.age != anotherCat.age)
            age = this.age > anotherCat.age ? 1 : -1;
        if(this.weight != anotherCat.weight)
            weight = this.weight > anotherCat.weight ? 1 : -1;
        if(this.strength != anotherCat.strength)
            strength = this.strength > anotherCat.strength ? 1 : -1;

        return (age + weight + strength) > 0;

    }

    public static void main(String[] args) {

        Cat cat1 = new Cat();
        cat1.age = 12;
        cat1.weight = 20;
        cat1.strength = 50;

        Cat cat2 = new Cat();
        cat2.age = 15;
        cat2.weight = 17;
        cat2.strength = 50;

        System.out.println(cat1.fight(cat2));
    }
}
