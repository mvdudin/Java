package LS_01;

// Вывести все простые числа от 1 до 1000
public class LS0102 {
  static boolean simple(int n) {
    for (int i = 2; i < n; i++) {
      if (n % i == 0)
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    int n = 1000;
    for (int i = 1; i <= n; i++) {
      if (simple(i))
        System.out.printf("%d ", i);
    }
  }
}