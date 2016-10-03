import java.util.*;
import java.io.*;

public class CountValue {
    public static void main(String[] args) throws IOException {
        
        int i;    //迴圈用的變數
        
        //初始化一個讀檔物件
        FileReader fr = new FileReader(CountValue.class.getResource("Training_Data.csv").getPath());
        
        //初始化一個 Scanner 物件
        Scanner scan = new Scanner(fr);
        String s;           //用來存每行字串的變數
        String sParts[];    //用來存以","分割後的字串陣列
        String sAttribute[];//用來存 Attribute 的陣列
        
        //讀入文件第一行，並將其分割成字串陣列
        s = scan.nextLine();
        sAttribute = s.split(",");    //第一行就是 Attribute
        
        //宣告一 HashSet 陣列用來儲存 HashSet 物件
        HashSet se[] = new HashSet[sAttribute.length];

        //有多少 Attribute 就生成多少個 Set 物件
        //並將其放置 List 物件中
        for (i = 0; i < sAttribute.length; i++)
           se[i] = new HashSet();
        
        //一行一行讀入直到資料全部讀完
        while (scan.hasNextLine()) {
            s = scan.nextLine();
            sParts = s.split(",");        //將讀到的每一行都以","分割成字串陣列
            
            //將字串陣列中的的字串各別加到對應 Attribute 的 Set 物件中
            for (i = 0; i < sParts.length; i++)
                se[i].add(sParts[i]);
        }
        
        //把在各個 Attribute 的 Set 物件的元素總數顯示在螢幕上
        //各個 Set 物件的元素總數會等於不同值的個數，因為 Set 物件
        //裡面不能存放重複的值，因此只要將每個字串加入 Set 物件，即可
        //將重複的值去除
        for (i = 0; i < sAttribute.length; i++) 
            System.out.print(sAttribute[i] + ":" + se[i].size() + " ");
        
        System.out.println();
        
       fr.close();
    }
    
}
