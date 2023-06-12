package LS_01;

import java.util.Scanner;

// Реализовать простой калькулятор (+ - / *)

public class LS0103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите целое число:");
        while (!sc.hasNextInt()) {
            System.out.print("Введите целое число:");
            sc.next();
        }
        int a = sc.nextInt();

        String math_op;
        do {
           System.out.print("Введите знак арифметической операции:");
           math_op = sc.nextLine();
        } while (!math_op.equals("+") && !math_op.equals("-") && !math_op.equals("*")&& !math_op.equals("/"));
        
        System.out.print("Введите целое число:");
        while (!sc.hasNextInt()) {
            System.out.print("Введите целое число:");
            sc.next();
        }
        int b = sc.nextInt();

        sc.close();

        switch (math_op) {
            case "+":
                System.out.printf("%d %s %d = %d \n", a, math_op, b, a + b);
                break;
            case "-":
                System.out.printf("%d %s %d = %d \n", a, math_op, b, a - b);
                break;
            case "*":
                System.out.printf("%d %s %d = %d \n", a, math_op, b, a * b);
                break;
            case "/":
                if (b == 0) {
                    System.out.println("Делить на 0 нельзя");
                } else {
                    System.out.printf("%d %s %d = %.6f \n", a, math_op, b, (double)a / (double)b);
                }
                break;
        }
    }
}
