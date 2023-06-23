
import java.util.*;

public class Main {
    static Deque longPlusShort(Deque l, Deque s, byte sign){
        int sum = 0;
        int overflow = 0;
        Deque result = new LinkedList();

        while (s.size() > 0) {
            sum = (int) l.pop() + (int) s.pop() + overflow;
            if (sum > 9){
                overflow = 1;
                sum %= 10;
            }
            else overflow = 0;
            result.addFirst(sum);
        }

        while (l.size() > 0) {
            sum = (int) l.pop() + overflow;
            if (sum > 9){
                overflow = 1;
                sum %= 10;
            }
            else overflow = 0;
            result.addFirst(sum);
        }
        if (overflow == 1)
            result.addFirst(overflow);
        if (sign == -1)
            result.addFirst(-(int)result.pop());
        return result;
    }

    static Deque longMinusShort(Deque l, Deque s, byte sign){
        int sum = 0;
        int overflow = 0;
        Deque result = new LinkedList();

        while (s.size() > 0) {
            sum = (int) l.pop() - (int) s.pop() + overflow;
            if (sum < 0){
                overflow = -1;
                sum += 10;
            }
            else overflow = 0;
            result.addFirst(sum);
        }

        while (l.size() > 0) {
            sum = (int) l.pop() + overflow;
            if (sum < 0){
                overflow = -1;
                sum += 10;
            }
            else overflow = 0;
            result.addFirst(sum);
        }
        //if (overflow == -1)
        //    result.addFirst(overflow);
        while ((int) result.getFirst() == 0 & result.size()>1){
            result.pop();
        }
        if (sign == -1)
            result.addFirst(-(int)result.pop());
        return result;
    }
    static Deque sum(Deque n1, Deque n2){
        boolean plus;
        byte result_sign;
        boolean n1_greatest = n1.size() > n2.size();
        boolean n1_positive = (int) n1.getLast() >= 0;
        boolean n2_positive = (int) n2.getLast() >= 0;

        if (!n1_positive)
            n1.addLast(-(int)n1.pollLast());
        if (!n2_positive)
            n2.addLast(-(int)n2.pollLast());

        if (n1.size() == n2.size()) {
            Iterator<Integer> in1 = n1.iterator();
            Iterator<Integer> in2 = n2.iterator();

            while (in1.hasNext()) {
               int d1 = (Integer) in1.next().intValue();
               int d2 = (Integer) in2.next().intValue();
               if (d1 != d2) {
                   n1_greatest = d1 > d2;
                   break;
               }
            }

        }

        if (n1_positive & n2_positive) {
            // Оба числа положительные. Сложение. Итог знак +
            plus = true;
            result_sign = 1;
        } else if (!n1_positive & !n2_positive) {
            // Оба числа отрицательные. Сложение. Итог знак -
            plus = true;
            result_sign = -1;
        } else{
            // Варианты когдо одно из чисел отрицательное.Вычтание.
            plus = false;
            if ((n1_greatest & n1_positive) | (!n1_greatest & !n1_positive))
                result_sign = 1;
            else
                result_sign = -1;
        }

        if (plus)
            if(n1_greatest)
                return longPlusShort(n1, n2, result_sign);
            else
                return longPlusShort(n2, n1, result_sign);
        else
            if(n1_greatest)
                return longMinusShort(n1, n2, result_sign);
            else
                return longMinusShort(n2, n1, result_sign);
    }

    static Deque longMultiplyShort(Deque n1, Deque n2, byte sign){
        int shift = 0;
        LinkedList<Integer> temp = new LinkedList();
        LinkedList<Integer> result = new LinkedList();

        for (int i = 0; i < n1.size()+n2.size()+1; i++) {
           result.add(0);
        }

        while(n2.size() > 0){
            for (int i = 0; i < shift; i++) {
              temp.add(0);
            }

            int overflow = 0;
            int number = (int) n2.pop();
            Iterator<Integer> n1_iterator = n1.iterator();
            while (n1_iterator.hasNext()) {
                int product = n1_iterator.next() * number;
                temp.addLast((product+overflow) % 10);
                overflow = product / 10;
            }
            if (overflow != 0) {
                temp.addLast(overflow);
                overflow = 0;
            }

            ListIterator<Integer> r_iterator = result.listIterator();
            while (temp.size() > 0) {
                Integer r = r_iterator.next();
                if ((Integer) temp.getFirst() != 0) {
                    int x = r + (Integer) temp.pollFirst() + overflow;
                    r_iterator.set(x % 10);
                    overflow = x / 10;
                }
                else
                    temp.pollFirst();
            }
            temp.clear();
            shift++;
        }
        while (result.getLast() == 0){
          result.pollLast();
        }
        if (sign == -1)
            result.addLast(-(int)result.pollLast());
        return result;
    }

    static Deque product(Deque n1, Deque n2){
        byte result_sign = 1;
        boolean n1_greatest = n1.size() >= n2.size();
        if ((int) n1.getLast() < 0) {
            n1.addLast(-(int) n1.pollLast());
            result_sign *= -1;
        }
        if ((int) n2.getLast() < 0) {
            n2.addLast(-(int)n2.pollLast());
            result_sign *= -1;
        }

        if (n1_greatest)
            return longMultiplyShort(n1, n2, result_sign);
        else
            return longMultiplyShort(n2, n1, result_sign);
    }

    public static void main(String[] args) {
        Deque<Integer> number_one = new LinkedList();
        number_one.add(9);
        number_one.add(9);
        number_one.add(9);
        number_one.add(-5);
        System.out.print("REVERSE NUMBER ONE ");
        System.out.println(number_one);
        Deque<Integer> number_two = new LinkedList();
        number_two.add(8);
        number_two.add(8);
        number_two.add(8);
        System.out.print("REVERSE NUMBER TWO ");
        System.out.println(number_two);
        System.out.print("SUM AS INT ");
        System.out.println(-5999+888);
        System.out.print("SUM AS LINKEDLIST ");
        System.out.println(sum(number_one, number_two));
        System.out.println();

        number_one.add(5);
        number_one.add(5);
        number_one.add(5);
        number_one.add(-5);
        System.out.print("REVERSE NUMBER ONE ");
        System.out.println(number_one);

        number_two.add(1);
        number_two.add(3);
        number_two.add(5);
        System.out.print("REVERSE NUMBER TWO ");
        System.out.println(number_two);

        System.out.print("PRODUCT AS INT ");
        System.out.println(-5555*531);
        System.out.print("PRODUCT AS LINKEDLIST ");
        System.out.println(product(number_one, number_two));
    }
}