
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static LinkedList<NoteBook> notes;
    public static void addNoteBooks(){
        NoteBook note = new NoteBook("ASUS", "Model 1", 4, 250, "Ubuntu Mate", "черный");
        notes.add(note);
        note = new NoteBook("ASUS", "Model 2", 8, 512, "Windows 10", "красный");
        notes.add(note);
        note = new NoteBook("Lenovo", "Model 1", 16, 1024, "Windows 7", "синий");
        notes.add(note);
    }
    public static  void printMenu(){
        System.out.println("1: Задать критерий отбора");
        System.out.println("2: Вывести на экран подходящие под критерий отбора");
        System.out.println("3: Завершить работу");
    }
    public static  void printSubMenu(){
        System.out.println("1: Объем ОЗУ");
        System.out.println("2: Объем ПЗУ");
        System.out.println("3: ОС");
        System.out.println("4: Цвет корпуса");
        System.out.println("5: Вернуться в предыдущие меню");
    }

    public static void main(String[] args) {
        int item;
        notes = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        addNoteBooks();
        do {
            printMenu();
            item = sc.nextInt();
            switch (item) {
                case 1: {
                    NoteBook.clearFilter();
                    int sub_item;
                    do {

                        printSubMenu();
                        sub_item = sc.nextInt();
                        switch (sub_item) {
                            case 1: {
                                System.out.print("Объем ОЗУ: ");
                                NoteBook.setRAMFilter(sc.nextInt());
                                break;
                            }
                            case 2: {
                                System.out.print("Объем ПЗУ: ");
                                NoteBook.setHDDFilter(sc.nextInt());
                                break;
                            }
                            case 3: {
                                System.out.print("Операционная система: ");
                                NoteBook.setOSFilter(sc.next());
                                break;
                            }
                            case 4: {
                                System.out.print("Цвет корпуса: ");
                                NoteBook.setColorFilter(sc.next());
                                break;
                            }
                        }
                    } while (sub_item != 5);
                    break;
                }
                case 2: {
                    System.out.print("Критерий отбора: ");
                    System.out.println(NoteBook.filterToString());
                    for (NoteBook note: notes) {
                        if (note.select()) System.out.println(note);
                    }
                    System.out.println();
                    break;
                }
            }
        } while (item != 3);
        sc.close();
    }
}