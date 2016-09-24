import java.io.*;
import java.util.*;

public class HW3_05366016 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader(HW3_05366016.class.getResource("Training_Data.csv").getPath()));
        PrintWriter pwr = new PrintWriter("Revise_Training_Data.csv");
        
        String s;
        String sArray[];
        while (sc.hasNext()) {
            s =sc.next();
            sArray = s.split(",");
            pwr.write(sArray[0]);
            for (int i = 1; i < sArray.length; i++)
                pwr.write("@" + sArray[i]);
            pwr.write("\r\n");
        }
        pwr.flush();
        
        sc.close();
        pwr.close();
    }
    
}
