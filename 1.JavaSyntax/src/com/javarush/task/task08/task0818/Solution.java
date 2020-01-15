package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
Создать словарь (Map<String, Integer>) и занести в него десять записей по принципу: "фамилия" - "зарплата".
Удалить из словаря всех людей, у которых зарплата ниже 500.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь Map с типом элементов String,
Integer состоящих из 10 записей по принципу «фамилия» - «зарплата».
4. Метод removeItemFromMap() должен удалять из словаря всех людей, у которых зарплата ниже 500.
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код

        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("Полковенко",1500);
        map.put("Сидоров",550);
        map.put("Шаповалов",1000);
        map.put("Мироненко",2500);
        map.put("Березуцкий",250);
        map.put("Коновалов",700);
        map.put("Кивалов",200);
        map.put("Смирнов",800);
        map.put("Дегтярев",350);
        map.put("Дорошенко",900);

        return map;

    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код

        Map<String, Integer> copyMap = new HashMap<String, Integer>(map);
        for(Map.Entry<String, Integer> elPair : copyMap.entrySet()){
            if(Integer.compare(elPair.getValue(), 500) < 0){
                map.remove(elPair.getKey());
            }
        }

    }

    public static void main(String[] args) {
//        Map<String, Integer> map = createMap();
//        removeItemFromMap(map);
//        for(Map.Entry<String, Integer> el : map.entrySet())
//            System.out.println(el.getKey() + " - " + el.getValue());
    }
}