package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: "фамилия" - "дата рождения".
Удалить из словаря всех людей, родившихся летом.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String,
Date состоящий из 10 записей.
4. Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));

        //напишите тут ваш код

        map.put("Иванов", dateFormat.parse("MAY 1 2012"));
        map.put("Сидоров", dateFormat.parse("JUNE 1 2012"));
        map.put("Патютко", dateFormat.parse("MAY 1 2012"));
        map.put("Дегтяренко", dateFormat.parse("JULY 1 2012"));
        map.put("Шаповалов", dateFormat.parse("MAY 1 2012"));
        map.put("Полковенко", dateFormat.parse("MARCH 1 2012"));
        map.put("Вербовой", dateFormat.parse("JULY 1 2012"));
        map.put("Поляков", dateFormat.parse("JANUARY 1 2012"));
        map.put("Смирнов", dateFormat.parse("MAY 1 2012"));

        return map;

    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код

        List<String> toRemove = new ArrayList<String>();
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Date> elPair = iterator.next();
            if(containsSummerMonth(elPair.getValue())){
                toRemove.add(elPair.getKey());
            }
        }

        // remove
        for(String key : toRemove)
            map.remove(key);

    }

    public static boolean containsSummerMonth(Date date) {
        boolean resultCheck = false;
        int[] month = new int[]{5, 6, 7};
        for(int el : month){
            if(Integer.compare(el, date.getMonth()) == 0)
                resultCheck = true;
        }
        return resultCheck;
    }

    public static void main(String[] args) throws ParseException {
//        Map<String, Date> map = createMap();
//        removeAllSummerPeople(map);
//        for(Map.Entry<String, Date> el : map.entrySet())
//            System.out.println(el.getKey() + " - " + el.getValue());
    }
}
