import java.io.*;

public class CountValue {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\Github\\Java\\HW3_05366016\\src\\Training_Data.csv");
        BufferedReader bf = new BufferedReader(fr);
        String s;
        
        while ((s = bf.readLine()) != null) {
            System.out.println(s);
        }
        
        fr.close();
    }
    
}
