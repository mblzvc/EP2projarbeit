import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Test2 {
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

        // System.out.println(Arrays.toString((String[])al.get(0)));
        around(0.0,0.0,575.0,al);
        around( 1818.54657,5813.29982,100.0,al);
    }

    public static void around(double xo, double yo, double r,ArrayList al){
        r=Math.pow(r,2);
        long counterF=0;
        long counterB=0;
        System.out.println(al.size());
        for(int i=0;i<al.size();i++){
            String[] a=(String[])al.get(i);
            double x=Double.parseDouble(a[1]);
            double y=Double.parseDouble(a[2]);
            x=Math.pow(x-xo,2);
            y=Math.pow(y-yo,2);
            if(x+y<r){
                if(a[3].equals("TRAINSTATION")){
                    counterB++;
                }else{
                    counterF++;
                }
            }
        }
        System.out.println("Flughafen: "+counterF+"  Bahnhofen: "+counterB);
    }

}
