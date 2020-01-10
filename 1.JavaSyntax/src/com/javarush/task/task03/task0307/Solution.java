package com.javarush.task.task03.task0307;

/*

Привет StarCraft!
Создать 5 зергов, 3 протосса и 4 террана.
Дать им всем уникальные имена.


Требования:
1. Нельзя изменять классы Zerg, Protoss и Terran.
2. Нужно создать 5 объектов типа Zerg и каждому из них дать свое имя.
3. Нужно создать 3 объекта типа Protoss и каждому из них дать свое имя.
4. Нужно создать 4 объекта типа Terran и каждому из них дать свое имя.

*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        Zerg zerg1 = new Zerg();
        zerg1.name = "Git";
        Zerg zerg2 = new Zerg();
        zerg2.name = "Maf";
        Zerg zerg3 = new Zerg();
        zerg3.name = "Ilo";
        Zerg zerg4 = new Zerg();
        zerg4.name = "Pin";
        Zerg zerg5 = new Zerg();
        zerg5.name = "Xer";

        Protoss protoss1 = new Protoss();
        protoss1.name = "Ptor";
        Protoss protoss2 = new Protoss();
        protoss2.name = "Wert";
        Protoss protoss3 = new Protoss();
        protoss3.name = "Nfjk";

        Terran terran1 = new Terran();
        terran1.name = "Wdopy";
        Terran terran2 = new Terran();
        terran2.name = "Serp";
        Terran terran3 = new Terran();
        terran3.name = "Xopet";
        Terran terran4 = new Terran();
        terran4.name = "Wvb";


    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
