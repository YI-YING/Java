class MyInt {
    int data;
    
    public String toString() {
        return Integer.toString(data);
    }
}
public class HW9_05366016 {
    public static void swap(MyInt i, MyInt j) {
   	  Integer temp;
   	  temp = i.data;
   	  i.data = j.data;
   	  j.data = temp;
    }
    public static void main(String[] args) {
      MyInt i = new MyInt();
      i.data = 10;
      
      MyInt j = new MyInt();
      j.data = 5;

	  System.out.println("i = " + i + "  j = " + j);
	  
	  swap(i, j);
	  
	  System.out.println("i = " + i + "  j = " + j);
        
    }
    
}
	
