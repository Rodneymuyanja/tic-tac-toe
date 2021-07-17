package tictacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class heuristics {

    int row = 1;
    int col;

    public String translateCoordinates(int row, int column){
        String position = "-";
        
        if ( row == 0 && column == 0){
            position = "TL";
        }

        if ( row == 0 && column == 1){
            position = "TM";
        }

        if ( row == 0 && column == 2){
            position = "TR";
        }

        if ( row == 1 && column == 0){
            position = "ML";
        }

        if ( row == 1 && column == 1){
            position = "MM";
        }

        if ( row == 1 && column == 2){
            position = "MR";
        }

        if ( row == 2 && column == 0){
            position = "BL";
        }

        if ( row == 2 && column == 1){
            position = "BM";
        }

        if ( row == 2 && column == 2){
            position = "BR";
        }
        
        return position;
    }

    public int highest(int [] chances){
        int temp;
        
        for(int i = 0; i < chances.length; i++){
            for (int j = i+1; j<chances.length; j++){
                if (chances[i] > chances[j]){
                    temp = chances[i];
                    chances[i] = chances[j];
                    chances[j] = temp; 
                }
            }
        }

        return chances[chances.length-1];
    }

    public int findIndex(int arr[], int t)
    {
 
        if (arr == null) {
            return -1;
        }
 
        int len = arr.length;
        int i = 0;
 
        while (i < len) {
 
            // if the i-th element is t
            // then return the index
            if (arr[i] == t) {
                System.out.println("finding index "+t);
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }


    public void indexToCoordinates(int index){

        //index ;
        switch (index) {
            case 0:
                this.row = 0;
                this.col = 0;
                break;
            case 1: 
                this.row = 0;
                this.col = 1;
                break;
            case 2: 
                this.row = 0;
                this.col = 2;
                break;
            case 3: 
                this.row = 1;
                this.col = 0;
                break;
            case 4: 
                this.row = 1;
                this.col = 1;
                break;
            case 5: 
                this.row = 1;
                this.col = 2;
                break;
            case 6: 
                this.row = 2;
                this.col = 0;
                break;
            case 7: 
                this.row = 2;
                this.col = 1;
                break;
            case 8: 
                this.row = 2;
                this.col = 2;
                                       
            default:
                break;
        }

    }

    public int getRow(){
        return this.row;
    }

    public int getcolumn(){
        return this.col;
    }

    public void chanceOfWinning(int r, int c){
        
        String column = this.translateCoordinates(r,c);
        
        System.out.println("column "+ column);

        String s = null;
        
        try{
            Process p = Runtime.getRuntime().exec("D:/python3/python.exe d:/javaWork/tictactoe/tictacToe/model.py "+column);
    
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));

    
            System.out.println("Here is the standard output of the command:\n");
            int [] t = new int[9];
            int [] g = new int[9];
            int i = 0;
                while ((s = in.readLine()) != null) {
                    int num = Integer.parseInt(s);
    
                    t[i] = num;
                    g[i] = num;
                    i++;
                }
    
                System.out.println("the array"+Arrays.toString(t));
    
                int largest = this.highest(t);
                
                System.out.println("highest "+largest);
                //find index
                System.out.println("the array"+Arrays.toString(g));
    
                int index = this.findIndex(g, largest);
                System.out.println("index "+index);
    
                //change index to Coordinates
                this.indexToCoordinates(index);
    
            }catch(IOException e){
                e.printStackTrace();
            }
    
    }

    
    
   // public int chanceOfLosing(String column1, String column2){

   // }

   public static void main(String[] args) {
       heuristics heu = new heuristics();
       heu.chanceOfWinning(1, 2);

       
       System.out.println("row "+heu.getRow());
            
       System.out.println("column "+heu.getcolumn());

   }


}
