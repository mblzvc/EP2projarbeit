import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        //String x = "23.232323";
        //double y= Double.parseDouble(x);

        ArrayList al = new ArrayList();
        try(Scanner s = new Scanner(
                new File(System.getProperty("user.dir") +
                        "/data/junctions.csv"), "UTF-8")) {
            // Benutzen Sie das Scanner-Objekt s hier
            s.useDelimiter(Pattern.compile("\\r\\n"));
            while (s.hasNextLine()){
                String[] temp = s.next().split(";");
                al.add(temp);
            }
        } catch(FileNotFoundException e) {
            // junctions.csv wurde nicht gefunden
            System.out.println("junctions.csv wurde nicht gefunden");
            System.exit(1);
        }

        System.out.println(Arrays.toString((String[])al.get(0)));
    }
}
