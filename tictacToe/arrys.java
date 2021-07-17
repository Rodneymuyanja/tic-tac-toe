package tictacToe;
import java.util.*;

public class arrys {

   

        public int[] addX(int n, int arr[], int x)
        {
            int i;
      
            // create a new array of size n+1
            int newarr[] = new int[11];
      
            // insert the elements from
            // the old array into the new array
            // insert all elements till n
            // then insert x at n+1
            for (i = 0; i < newarr.length+1; i++)
                newarr[i] = arr[i];
      
            newarr[n] = x;
      
            return newarr;
        }
        
        
    
    public static void main(String[] args) {
       // Scanner s = new Scanner(System.in);
       arrys k = new arrys();
       

       int [] t = new int[10];

       int [] arr = new int[10];

       t[0] = 7;
       
       while

       

       

       for (int i = 0; i < arr.length; i++){
           System.out.println(arr[i]);
       }

    }
}
