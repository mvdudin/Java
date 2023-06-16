import java.util.Scanner;
import java.io.IOException;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        FileHandler file = new FileHandler("calc.log");
        SimpleFormatter format = new SimpleFormatter();
        file.setFormatter(format);
        Logger log = Logger.getLogger(Main.class.getName());
        log.addHandler(file);
        log.setLevel(Level.ALL);

        System.out.print("Введите целое число:");
        while (!sc.hasNextInt()) {
            log.log(Level.WARNING, "Введено не целое число");
            System.out.print("Введите целое число:");
            sc.next();
        }
        int a = sc.nextInt();
        sc.nextLine();

        String math_op;
        do {
            System.out.print("Введите знак арифметической операции:");
            math_op = sc.nextLine();
            if (!math_op.equals("+") && !math_op.equals("-") && !math_op.equals("*") && !math_op.equals("/")){
                log.log(Level.WARNING, "Введен символ не арифметиченской операции");
            }
            else {
                break;
            }
        } while (true);

        System.out.print("Введите целое число:");
        while (!sc.hasNextInt()) {
            log.log(Level.WARNING, "Введено не целое число");
            System.out.print("Введите целое число:");
            sc.next();
        }
        int b = sc.nextInt();

        sc.close();
        double result = 0;
        switch (math_op) {
            case "+":
                result = a + b;
                System.out.printf("%d %s %d = %d \n", a, math_op, b, (int)result);
                break;
            case "-":
                result = a - b;
                System.out.printf("%d %s %d = %d \n", a, math_op, b, (int)result);
                break;
            case "*":
                result = a * b;
                System.out.printf("%d %s %d = %d \n", a, math_op, b, (int)result);
                break;
            case "/":
                if (b == 0) {
                    System.out.println("Делить на 0 нельзя");
                } else {
                    result = a / b;
                    System.out.printf("%d %s %d = %.6f \n", a, math_op, b, result);
                }
                break;
        }
        log.info("%d %s %d = %.6f \n".formatted( a, math_op, b, result));
    }
 }