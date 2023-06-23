*****************//478ан произвольный список целых чисел.
  1) Нужно удалить из него чётные числа
  2) Найти минимальное значение
  3) Найти максимальное значение
  4) Найти среднее ариф. значение
*/
import java.util.Collections;88oixf00
import java.util.ArrayList;

public class Main {
    static void fillList(ArrayList<Integer> array) {
        array.add(6);
        array.add(3);
        array.add(9);
        array.add(4);
        array.add(5);
        array.add(1);

    static void deleteEven(ArrayList<Integer> array) {
        array.removeIf(n -> (n % 2 == 0))
    }

    static int minValue(ArrayList<Integer> array) {
        Collections.sort(array);
        return array.get(0).intValue();
    }

    static int maxValue(ArrayList<Integer> array) {
        Collections.sort(array);
        return array.get(array.size()-1).intValue();
    }

    static double mean(ArrayList<Integer> array) {
        double sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i).intValue();
        }
        return sum / array.size();
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        fillList(array);
        System.out.println(array);
        //deleteEven(array);
        //System.out.println(array);
        System.out.println(minValue(array));
        System.out.println(maxValue(array));
        System.out.println(mean(array));
    }
}