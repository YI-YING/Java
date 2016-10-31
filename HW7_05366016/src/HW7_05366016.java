import java.io.*;
import java.util.*;

public class HW7_05366016 {
    public static void main(String[] args) throws IOException{
        int i;    //迴圈用的變數
        
        //初始化一個讀檔物件
        FileReader fr = new FileReader(HW7_05366016.class.getResource("Training_Data.csv").getPath());
        
        //初始化一個 Scanner 物件
        Scanner scan = new Scanner(fr);
        String s;           //用來存每行字串的變數
        String sParts[];    //用來存以","分割後的字串陣列
        String sAttribute[];//用來存 Attribute 的陣列
        
        //讀入文件第一行，並將其分割成字串陣列
        s = scan.nextLine();
        sAttribute = s.split(",");    //第一行就是 Attribute
        
        //宣告一 HashMap 陣列用來儲存 HashMap 物件
        HashMap hmp[] = new HashMap[sAttribute.length];

        //將 HashMap 陣列初始化
        for (i = 0; i < sAttribute.length; i++)
           hmp[i] = new HashMap();
        
        //一行一行讀入直到資料全部讀完
        while (scan.hasNextLine()) {
            s = scan.nextLine();
            sParts = s.split(",");        //將讀到的每一行都以","分割成字串陣列
            
            //將字串陣列中的的字串各別加到對應 Attribute 的 HashMap 物件中
            for (i = 0; i < sParts.length; i++) {
                //如果 key 已經在 HashMap 取出 value
                //否則將值設為 0
                int k = (hmp[i].get(sParts[i]) == null) ? 0 : (int)hmp[i].get(sParts[i]);
                hmp[i].put(sParts[i], ++k);
            }
        }
        
        //把代表各個 Attribute 的 HashMap 的元素總數顯示在螢幕上
        //並將元素總數在 10 以內的所有元素也一併顯示在螢幕上
        for (i = 0; i < sAttribute.length; i++) { 

            System.out.print(sAttribute[i] + ":" + hmp[i].size() + " ");
            
            if (hmp[i].size() <= 10) 
                System.out.println(hmp[i] + " ");
        }
        System.out.println();
        
       fr.close();
        
    }
    
}
