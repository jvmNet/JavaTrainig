package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion.

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u - обновляет соответствующие данные людей с заданными id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке.
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople.
Порядок вывода данных соответствует вводу данных.
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных).
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример вывода для параметра -і с двумя id:
Миронов м 15-Apr-1990
Миронова ж 25-Apr-1997


Требования:
1. Класс Solution должен содержать public static volatile поле allPeople типа List<Person>.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При параметре -с программа должна добавлять всех людей с заданными параметрами в конец списка allPeople,
и выводить id каждого (index) на экран.
4. При параметре -u программа должна обновлять данные людей с заданными id в списке allPeople.
5. При параметре -d программа должна логически удалять людей с заданными id в списке allPeople.
6. При параметре -i программа должна выводить на экран данные о всех людях с заданными id по формату указанному в задании.
7. Метод main класса Solution должен содержать оператор switch по значению args[0].
8. Каждый case оператора switch должен иметь блок синхронизации по allPeople.
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут

        List<String> temp = new ArrayList<String>(Arrays.asList(args));

        for(int i = 1; i < temp.size(); i++) {

            switch(args[0]) {
                // create
                case "-c":
                    synchronized (allPeople) {
                        if(i%3 == 0)
                            handlerPerson("-c", new String[]{temp.get(i - 2),
                                    temp.get(i - 1), temp.get(i)});
                    }
                break;
                // update
                case "-u":
                    synchronized (allPeople) {
                        if(i%4 == 0)
                            handlerPerson("-u", new String[]{temp.get(i - 3),
                                    temp.get(i - 2), temp.get(i - 1), temp.get(i)});
                    }
                break;
                // delete
                case "-d":
                    synchronized (allPeople) {
                        handlerPerson("-d", new String[]{temp.get(i)});
                    }
                break;
                // info
                case "-i":
                    synchronized (allPeople) {
                        handlerPerson("-i", new String[]{temp.get(i)});
                    }
                break;
            }

        }

//        for(Person person : allPeople)
//            System.out.println(person.getName() + " "
//                               + person.getSex() + " "
//                               + person.getBirthDate());

    }

    private synchronized static void handlerPerson(final String key,
                                                   final String[] personParams)
    {
        switch(key) {
            case "-c": create(personParams[0],
                              personParams[1],
                              personParams[2]);
                break;
            case "-u": update(personParams[0],
                              personParams[1],
                              personParams[2],
                              personParams[3]);
                break;
            case "-d": delete(personParams[0]);
                break;
            case "-i": info(personParams[0]);
                break;
        }
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
