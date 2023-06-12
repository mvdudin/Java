package LS_01;

import java.util.Scanner;

public class LS0104 {
    public static void main(String[] args) {
        int i;
        String equation;
        String q_reverse = "";
        String w_reverse = "";
        String e_reverse = "";
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.print("Введите уравнение: ");
            equation = sc.nextLine();
            i = equation.length()-1;
            int step = 0;
            
            while (i > -1)
            { switch (step) {
                case 0:
                    if (equation.charAt(i) >= '0' && equation.charAt(i) <= '9' || equation.charAt(i) == '?') {
                        e_reverse += equation.charAt(i);
                        i--;
                    }
                    else if (equation.charAt(i) == '='){
                        step = 1;
                        i--;
                    }
                    else {
                        i=-2;
                    }  
                    break;
                case 1:
                    if (equation.charAt(i) >= '0' && equation.charAt(i) <= '9' || equation.charAt(i) == '?') {
                        w_reverse += equation.charAt(i);
                        i--;
                    }
                    else if (equation.charAt(i) == '+'){
                        step = 2;
                        i --;
                    }
                    else {
                        i=-2;
                    }  
                    break;
                case 2:
                    if (equation.charAt(i) >= '0' && equation.charAt(i) <= '9' || equation.charAt(i) == '?') {
                        q_reverse += equation.charAt(i);
                        i--;
                    }
                    else {
                        i=-2;
                    }  
                    break;
              }
            }
        } while (i != -1);
        
        sc.close();
        
        int ten = 1;
        int sum_x = 0;
        int sum_e = 0;
        int sum_q_w = 0;
        
        for (int j = 0; j < q_reverse.length(); j++) {
           if (q_reverse.charAt(j) == '?') {
               sum_x += ten;
           }
           else {
            sum_q_w += (int)(q_reverse.charAt(j)-48)*ten;
           }
           ten *= 10;  
        }

        ten = 1;
        for (int j = 0; j < w_reverse.length(); j++) {
            if (w_reverse.charAt(j) == '?') {
                sum_x += ten;
            }
            else {
             sum_q_w += (int)(w_reverse.charAt(j)-48)*ten;
            }
            ten *= 10;  
         }  

         ten = 1;
         for (int j = 0; j < e_reverse.length(); j++) {
             if (e_reverse.charAt(j) == '?') {
                  sum_x -= ten;
             }
             else {
                  sum_e += (int)(e_reverse.charAt(j)-48)*ten;
             }
             ten *= 10;  
          } 

        if ((sum_e - sum_q_w) % sum_x == 0) {
            double x = (sum_e - sum_q_w) / sum_x;
            System.out.println(equation);
            System.out.println("? = " + (int) x);
            System.out.println(equation.replace('?', (char)(x+48)));
        }
        else{
            System.out.println("Нет решения в целых числах");
        }
    }
}