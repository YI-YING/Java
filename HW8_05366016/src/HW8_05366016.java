import java.io.*;
import java.util.*;

public class HW8_05366016 {
    public static void main(String[] args) throws IOException {
        //開啟檔案
        FileReader fr = new FileReader(HW8_05366016.class.getResource("data.txt").getPath());
        Scanner scFile = new Scanner(fr);
        Scanner scInput = new Scanner(System.in);
        
        //用 TreeMap 儲存資料以及計算資料個數
        TreeMap <Integer, Integer> tm = new TreeMap <>();
        
        int k, v;
        while (scFile.hasNext()) {
            k = scFile.nextInt();
            v = (tm.get(k) == null) ? 0 : tm.get(k);
            tm.put(k, ++v);
        }
        
        //要求使用者輸入 Threshold
        System.out.print("Please enter a threshold : ");
        int iInput;
        iInput = scInput.nextInt();
        
        //根據 Treadhold 將個數太少的資料 key 先存起來
        //方便之後刪除
        HashSet <Integer> temp = new HashSet <>();
        for (Map.Entry e : tm.entrySet()) {
            if ((int)e.getValue() > iInput) 
                System.out.println(e.getKey());
            
            else
                temp.add((int)e.getKey());
        }
        
        //刪除資料筆數比 Threshold 還少的資料
        Iterator <Integer> itr = temp.iterator();
        while (itr.hasNext()) 
            tm.remove(itr.next());
        
        System.out.println("Element : " + tm.size());
    }
    
}
