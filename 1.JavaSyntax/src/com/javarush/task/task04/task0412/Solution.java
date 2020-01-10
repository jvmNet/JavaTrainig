package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
Ввести с клавиатуры число.
Если число положительное, то увеличить его в два раза.
Если число отрицательное, то прибавить единицу.
Если введенное число равно нулю, необходимо вывести ноль.
Вывести результат на экран.


Требования:
1. Программа должна считывать число c клавиатуры.
2. Программа должна выводить число на экран.
3. Если введенное число положительное, необходимо увеличить его в два раза и вывести.
4. Если введенное число отрицательное, необходимо увеличить его на единицу и вывести.
5. Если введенное число равно нулю, необходимо вывести ноль.
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int digital = Integer.parseInt(bufferedReader.readLine());

        if(digital > 0){
            digital+= digital;
            System.out.println(digital);
        } else if(digital < 0){
            System.out.println(digital + 1);
        } else {
            System.out.println(digital);
        }

    }

}