import java.util.*;

public class Main {
    private static TreeSet<Integer> sizes;
    private static HashMap<String, ArrayList<Integer>> book;
    public static void testAdd() {
        add("D", 123);
        add("D", 346);
        add("D", 789);
        add("R", 123);
        add("R", 321);
        add("E", 8888);
    }
    public static void add(String person, int phone) {
        if (book.containsKey(person)) {
            book.get(person).add(phone);
            sizes.add(book.get(person).size());
        }
        else {
            ArrayList<Integer> phoneList = new ArrayList<Integer>();
            phoneList.add(phone);
            book.put(person, phoneList);
            sizes.add(1);
        }
    }
    public static void printAllDesc() {
        Iterator<Integer> items;
        items = sizes.descendingIterator();
        while(items.hasNext()) {
            Integer size = items.next();
            for (var node : book.entrySet()) {
                if (node.getValue().size() == size) {
                    System.out.print(node.getKey());
                    System.out.println(node.getValue());
                }
            }
        }
    }
    public static  void printMenu(){
        System.out.println("1: Добавить контакт");
        System.out.println("2: Вывести на экран все контакты");
        System.out.println("3: Завершить работу");
    }

    public static void main(String[] args) {
        int item = 0;
        book = new HashMap<>();
        sizes = new TreeSet<>();
        Scanner sc = new Scanner(System.in);
        testAdd();
        System.out.println(sizes);
        do {
            printMenu();
            item = sc.nextInt();
            switch (item) {
                case 1: {
                    System.out.print("Фамилия: ");
                    String person = sc.next();
                    System.out.print("Номер телефона: ");
                    int phone = sc.nextInt();
                    add(person, phone);
                    break;
                }
                case 2: {
                    printAllDesc();
                    break;
                }
            }
        } while (item != 3);
        sc.close();
    }
}