package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
CrUD - Create, Update, Delete.

Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u - обновляет данные человека с данным id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке.
Все люди должны храниться в allPeople.
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -і:
Миронов м 15-Apr-1990


Требования:
1. Класс Solution должен содержать public static поле allPeople типа List<Person>.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами
в конец списка allPeople, и выводить id (index) на экран.
4. При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
5. При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.
6. При запуске программы с параметром -i программа должна выводить на экран данные о человеке
с заданным id по формату указанному в задании.
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут

        switch(args[0]) {
            case "-c": create(args[1],
                    args[2],
                    args[3]);
                break;
            case "-u": update(args[1],
                    args[2],
                    args[3],
                    args[4]);
                break;
            case "-d": delete(args[1]);
                break;
            case "-i": info(args[1]);
                break;
        }

//        for(Person person : allPeople)
//            System.out.println(person.getName() + " "
//                               + person.getSex() + " "
//                               + person.getBirthDate());

    }

    private static void create(final String name,
                               final String sex,
                               final String birthDay)
    {
        Person person = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date bd = null;
        try {
            bd = simpleDateFormat.parse(birthDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(sex.equals("м")) {
            person = Person.createMale(name, bd);
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        } else if(sex.equals("ж")) {
            person = Person.createFemale(name, bd);
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }
    }

    private static void update(final String id,
                               final String name,
                               final String sex,
                               final String birthDay)
    {
        int idPerson = Integer.parseInt(id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date bd = null;
        try {
            bd = simpleDateFormat.parse(birthDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(sex.equals("м")) {
            allPeople.set(idPerson, Person.createMale(name, bd));
        } else if(sex.equals("ж")) {
            allPeople.set(idPerson, Person.createFemale(name, bd));
        }
    }

    private static void delete(final String id) {
        int idPerson = Integer.parseInt(id);
        Person person = allPeople.get(idPerson);
        person.setName(null);
        person.setSex(null);
        person.setBirthDate(null);
        allPeople.set(idPerson, person);
    }

    private static void info(final String id) {
        Person person = allPeople.get(Integer.parseInt(id));

        Date date = person.getBirthDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        String name = person.getName();
        String sex  = person.getSex() == Sex.MALE ? "м" : "ж";
        String bd   = simpleDateFormat.format(date);

        System.out.println(name + " " + sex + " " + bd);
    }

}
