package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
1. Разберись, что делает программа.
2. Реализуй логику метода run так, чтобы каждую секунду через пробел
выдавался отсчет начиная с numSeconds до 1, а потом слово [Марш!] (см примеры).
3. Если нить работает 3.5 секунды или более, прерви ее методом interrupt и внутри нити выведи в консоль слово
[Прервано!].

Пример для numSeconds=4 :
"4 3 2 1 Прервано!"

4. Если нить работает менее 3.5 секунд, она должна завершиться сама.
Пример для numSeconds=3 :
"3 2 1 Марш!"

PS: метод sleep выбрасывает InterruptedException.


Требования:
1. Метод run класса RacingClock должен содержать цикл.
2. Объект класса RacingClock должен каждую секунду уменьшать значение переменной numSeconds на единицу.
3. Метод main должен вызывать Thread.sleep(3500).
4. Метод main должен вызывать метод interrupt у объекта clock.
5. Если numSeconds равно 3, то программа должна вывести "3 2 1 Марш!".
6. Если numSeconds равно 4, то программа должна вывести "4 3 2 1 Прервано!".
*/

public class Solution {
    public static volatile int numSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        if(numSeconds == 0)
            System.out.print("Марш!");
        else
            clock.interrupt();


    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            try {
                while(!this.isInterrupted() && numSeconds > 0) {

                    Thread.sleep(1000);
                    System.out.print(numSeconds + " ");
                    numSeconds--;

                }

            } catch (InterruptedException e) {
                System.out.print(numSeconds + " Прервано!");
            }
        }
    }
}
