package com.javarush.task.task14.task1420;

/* 
НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.


Требования:
1. Программа должна считывать с клавиатуры 2 строки.
2. В случае если введенные строки невозможно преобразовать в положительные целые числа, должно возникать исключение.
3. Программа должна выводить данные на экран.
4. Программа должна выводить на экран наибольший общий делитель(НОД) чисел считанных
с клавиатуры и успешно завершаться.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int a = 0;
        int b = 0;

        try {

            a = Integer.parseInt(bufferedReader.readLine());
            b = Integer.parseInt(bufferedReader.readLine());

        } catch (Exception e) {
            e.printStackTrace();
        }

        if(a <= 0 || b <= 0)
                throw new Exception();

        System.out.println(nod(a, b, Math.max(a, b)));

    }

    private static int nod(int a, int b, int max) {
        if(a%max == 0 && b%max == 0) {
            return max;
        } else {
            max--;
            return nod(a, b, max);
        }
    }

}
