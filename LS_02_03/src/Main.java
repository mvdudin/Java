import java.io.*;

public class Main {
    static String Parse(String line){
        StringBuilder result = new StringBuilder();
        if (line.startsWith("[") && line.endsWith("]")) {
            int st = line.indexOf('{');
            int en = line.indexOf('}');

            while (st > -1){
               result.append(line.substring(st+1, en).replace("\"фамилия\":", "Студент").replace("\"оценка\":", "получил").replace("\"предмет\":","по предмету").replace("\",", " ").replace('"', ' ').trim()).append("\n");
               st = line.indexOf('{', st+1);
               en = line.indexOf('}', en+1);
           }
        }
        else {
          result.append("error");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        try {String fileName = "data.txt";
             File file = new File(fileName );
             FileReader fileReader = new FileReader(file);
             BufferedReader stringBuffer = new BufferedReader(fileReader);
             String line = stringBuffer.readLine();
             while (line != null) {
                 System.out.print(Parse(line));
                 line = stringBuffer.readLine();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
