package LS_01;
import java.util.Scanner;

// Вычислить n-ое треугольного число (сумма чисел от 1 до n), 
// n! (произведение чисел от 1 до n)

public class LS0101 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = 0;
    while (n < 1) {
      System.out.print("Введите целое число больше 0:");
      while (!sc.hasNextInt()) {
        System.out.print("Введите целое число больше 0:");
        sc.next();
      }
      n = sc.nextInt();
    }
    sc.close();
    int triangle = 0;
    int factorial = 1;
    for (int i = 1; i <= n; i++) {
      triangle += i;
      factorial *= i;
    }
    System.out.printf("T%d = %d \n", n, triangle);
    System.out.printf("%d! = %d \n", n, factorial);
  }

}
