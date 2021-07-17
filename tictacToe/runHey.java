package tictacToe;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;



public class runHey {

    public static void main(String[] args) {

        //runHey r = new runHey();

        heuristics heu = new heuristics();
        String column = heu.translateCoordinates(1,0);

        System.out.println("column "+column);

        String s = null;

        

        try{
        Process p = Runtime.getRuntime().exec("D:/python3/python.exe d:/javaWork/tictactoe/tictacToe/model.py "+column);

        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));

        

        //Stack<Integer> h = new Stack<Integer>();

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

            int largest = heu.highest(t);
            
            System.out.println("highest "+largest);
            //find index
            System.out.println("the array"+Arrays.toString(g));

            int index = heu.findIndex(g, largest);
            System.out.println("index "+index);

            //change index to Coordinates
            heu.indexToCoordinates(index);

            System.out.println("row "+heu.getRow());
        
            System.out.println("column "+heu.getcolumn());

        }catch(IOException e){
            e.printStackTrace();
        }
    }
        
}
    
