package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InvalidPropertiesFormatException;

/* 
Осваивание статического блока
1. В отдельных файлах создать классы Plane и Helicopter, реализующие интерфейс CanFly.
2. Класс Plane должен иметь конструктор с параметром int - количество перевозимых пассажиров.
3. В статическом методе reset класса Solution:
3.1. Считать с консоли параметр типа String.
3.2. Если параметр равен "helicopter", то статическому объекту CanFly result присвоить объект класса Helicopter.
3.3. Если параметр равен "plane", то считать второй параметр типа int(количество пассажиров),
статическому объекту CanFly result присвоить объект класса Plane.
4. В статическом блоке инициализировать CanFly result вызвав метод reset.
5. Закрыть поток ввода методом close().


Требования:
1. Класс Plane должен быть создан в отдельном файле и реализовывать интерфейс CanFly.
2. Класс Helicopter должен быть создан в отдельном файле и реализовывать интерфейс CanFly.
3. Класс Plane должен иметь конструктор с параметром int.
4. В классе Solution должен быть реализован метод public static void reset().
5. Метод reset должен считывать строки с клавиатуры.
6. Если введенная строка равна "helicopter", в переменную result должен быть сохранен объект типа Helicopter.
7. Если введенная строка равна "plane", в переменную result должен быть сохранен объект типа Plane.
8. Поле result класса Solution должно быть инициализировано в статическом блоке путем вызова метода reset.
*/

public class Solution {

    private static BufferedReader bufferedReader = null;
    private static String kindOfTransports = null;
    private static int amountPassengers = 0;
    private static final String HELICOPTER = "helicopter";
    private static final String PLANE = "plane";

    public static void main(String[] args) {
//        System.out.println(result);
//        if(result instanceof Plane)
//            System.out.println(((Plane) result).getAmountPassengers());
    }
    
    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static CanFly result;

    public static void reset() {
        //add your code here - добавьте код тут

        try {

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            kindOfTransports = bufferedReader.readLine();
            if(kindOfTransports.equals(PLANE))
                amountPassengers = Integer.parseInt(bufferedReader.readLine());

            result = kindOfTransports.equals(PLANE) ? new Plane(amountPassengers) :
                     kindOfTransports.equals(HELICOPTER) ? new Helicopter() : null;

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
