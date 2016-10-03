import java.util.*;
public class Reserve {
   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       double a = scan.nextDouble() / 3;
       
       System.out.printf("%.3f \r\n",a);
       System.out.println(round(a, 3));
    }
    static double round(double a, int i) {
//        String s = Double.toString(a);
        return (int)(a * Math.pow(10, i) + 0.5) / Math.pow(10, i);//Double.parseDouble(s.substring(0, s. indexOf(".") + i + 1)) ;
    }
}
