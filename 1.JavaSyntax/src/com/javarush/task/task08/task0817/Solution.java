package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
Создать словарь (Map<String, String>) занести в него десять записей по принципу "фамилия" - "имя".
Удалить людей, имеющих одинаковые имена.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь Map с
типом элементов String, String состоящих из 10 записей.
4. Метод removeTheFirstNameDuplicates() должен удалять из словаря всех людей, имеющие одинаковые имена.
5. Метод removeTheFirstNameDuplicates() должен вызывать метод removeItemFromMapByValue().
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код

        Map<String, String> map = new HashMap<String, String>();

        map.put("Полковенко","Иван");
        map.put("Сидоров","Петр");
        map.put("Шаповалов","Александр");
        map.put("Мироненко","Петр");
        map.put("Березуцкий","Дмитрий");
        map.put("Коновалов","Виктор");
        map.put("Кивалов","Антон");
        map.put("Смирнов","Роман");
        map.put("Дегтярев","Денис");
        map.put("Дорошенко","Дмитрий");

        return map;

    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        Set<String> duplicatesName = new HashSet<String>();
        for(Map.Entry<String, String> pair : map.entrySet()) {
            int countDuplicateName = 0;
            for(Map.Entry<String, String> checkName : map.entrySet()) {
                if(pair.getValue().equals(checkName.getValue())) {
                    countDuplicateName++;
                }
            }
            if(countDuplicateName > 1) {
                duplicatesName.add(pair.getValue());
            }
        }

        // remove duplicates name
        for(String el : duplicatesName)
            removeItemFromMapByValue(map, el);

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
//        Map<String, String> people = createMap();
//        removeTheFirstNameDuplicates(people);
//        for(Map.Entry<String, String> pair : people.entrySet())
//            System.out.println(pair.getKey() + " - " + pair.getValue());
    }
}
