import java.util.Arrays;
import java.io.IOException;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int temp;
        boolean sorted = false;
        int [] array = {11, 3, 14, 16, 7};
        Logger log = Logger.getLogger(Main.class.getName());
        FileHandler file = new FileHandler("array_log.txt");
        SimpleFormatter format = new SimpleFormatter();
        file.setFormatter(format);
        log.addHandler(file);
        log.info(Arrays.toString(array));
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if(array[i] > array[i+1]){
                    sorted = false;
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    log.info(Arrays.toString(array));
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}