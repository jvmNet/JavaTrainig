package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Перепись населения
Создать словарь (Map<String, String>) занести в него десять записей по принципу "Фамилия" - "Имя".
Проверить сколько людей имеют совпадающие с заданным именем или фамилией.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь Map с типом элементов String,
String состоящих из 10 записей по принципу «Фамилия» - «Имя».
4. Метод getCountTheSameFirstName() должен возвращать число людей у которых совпадает имя.
5. Метод getCountTheSameLastName() должен возвращать число людей у которых совпадает фамилия.
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код

        HashMap<String, String> map = new HashMap<String, String>();

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

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код

        int countName = 0;

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> elPair = iterator.next();
            if(elPair.getValue().equals(name))
                countName++;
        }

        return countName;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код

        int countLastName = 0;

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> elPair = iterator.next();
            if(elPair.getKey().equals(lastName))
                countLastName++;
        }

        return countLastName;
    }

    public static void main(String[] args) {

    }
}
