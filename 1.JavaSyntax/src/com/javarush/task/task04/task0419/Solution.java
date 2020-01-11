package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
Если числа равны между собой, необходимо вывести любое.


Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить число на экран.
3. Программа должна выводить на экран максимальное из четырёх чисел.
4. Если максимальных чисел несколько, необходимо вывести любое из них.
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());
        int d = Integer.parseInt(bufferedReader.readLine());

        Solution solution = new Solution();
        if(solution.getMaxDigital(a, b) > solution.getMaxDigital(c, d)){
            System.out.println(solution.getMaxDigital(a, b));
        } else if(solution.getMaxDigital(a, b) < solution.getMaxDigital(c, d)){
            System.out.println(solution.getMaxDigital(c, d));
        } else {
            System.out.println(solution.getMaxDigital(solution.getMaxDigital(a, b), solution.getMaxDigital(c, d)));
        }
    }

    private int getMaxDigital(int a, int b){
        if(a > b)
            return a;
        return b;
    }
}
