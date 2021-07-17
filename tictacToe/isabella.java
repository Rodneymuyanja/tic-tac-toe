package tictacToe;
import java.util.concurrent.ThreadLocalRandom;

public class isabella implements players{
    public int min = -1;
    public int max = 2;

    private int possibleCol = 0;
    private int possibleRow = 0;

    public isabella(char [][] board, boolean turn){
        while(turn){
            boolean dash = this.checkFordash(board);
            if (dash == true){
                
                this.makeMove(board, turn);
                turn = false;
            }
        }
    }

    public boolean checkFordash(char [][] board){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '-') {
                    return true;
                }
            }
        }
        return false;
    }

    public void makeMove(char [][] board, boolean turn){
        boolean filled = true;

        while (filled) {
            int row = ThreadLocalRandom.current().nextInt(min + 1, max + 1);
            int column = ThreadLocalRandom.current().nextInt(min + 1, max + 1);

            if (horizontal(board)){
                System.out.println("executed horizontal to true...implementing");
                column = this.getPossibleCol();
                row = this.getPossibleRow();
                System.out.println("row:"+row+"......... column:"+column);
                board[row][column] = 'x';
                filled = false;
                break;
            }else{
                System.out.println("executed horizontal to false...not implementing it");
            }

            //.............

            if (vertical(board)){
                System.out.println("executed vertical to true...implementing it.");
                column = this.getPossibleCol();
                row = this.getPossibleRow();
                System.out.println("row:"+row+"......... column:"+column);
                board[row][column] = 'x';
                filled = false;
                break;
            }else{
                System.out.println("executed vertical to false...not implementing it");
            }

            //.............
            
            if (diagonalOne(board)){
                System.out.println("executed diagonalOne to true...implementing it.");
                column = this.getPossibleCol();
                row = this.getPossibleRow();
                System.out.println("row:"+row+"......... column:"+column);
                board[row][column] = 'x';
                filled = false;
                break;
            }else{
                System.out.println("executed diagonalOne to false...not implementing it");
            }

            //............
            
            if (diagonalTwo(board)){
                System.out.println("executed diagonalTwo to true...implementing it.");
                column = this.getPossibleCol();
                row = this.getPossibleRow();
                System.out.println("row:"+row+"......... column:"+column);
                board[row][column] = 'x';
                filled = false;
                break;
            }else{
                System.out.println("executed diagonalTwo to false...not implementing it");
            }

            /** 
             * using a strategy
            *

            strategies strategies = new strategies();
            if (strategies.oldLadysJoke(board, turn)) {
                System.out.println("implemented oldLadysJoke");
            }else{
                System.out.println("didn't implement oldLadysJoke");
            }*/

            if (board [row][column] == '-'){
               if ( board[row][column] == 'x'){
                board[row][column] = 'o';
                filled = false;

               }else{
                board[row][column] = 'x';
                filled = false; 
               }
            }
        }

    }

    private boolean horizontal(char [][] board){

        for (int i = 0; i < board.length; i++){
            if (this.Hhelper(i, board)){
                return true;
            }  
        }
    
        return false;
    }


    private boolean Hhelper(int row, char [][] board){
        
        if ((board[row][0] == 'x') && (board[row][1] =='x' )) {
            if (board[row][2] == '-'){
                this.setPossibleCol(2);
                this.setPossibleRow(row);
                System.out.println("one");
                return true;
            }
        }else {
            if ((board[row][2] == 'x') && (board[row][1] =='x' )) {
                if (board[row][0] == '-'){
                    this.setPossibleCol(0);
                    this.setPossibleRow(row);
                    System.out.println("one");
                    return true;
                }
            }

            if ((board[row][0] == 'x') && (board[row][2] =='x' )) {
                if (board[row][1] == '-'){
                    this.setPossibleCol(1);
                    this.setPossibleRow(row);
                    System.out.println("one");
                    return true;
                }
            }
        }
        return false;
    }
  
    private boolean Vhelper(int col, char [][] board){
        
        if ((board[0][col] == 'x') && (board[1][col] =='x' )) {
            if (board[2][col] == '-'){
                this.setPossibleCol(col);
                this.setPossibleRow(2);
                System.out.println("one");
                return true;
            }
        }else {
            if ((board[2][col] == 'x') && (board[1][col] =='x' )) {
                if (board[0][col] == '-'){
                    this.setPossibleCol(col);
                    this.setPossibleRow(0);
                    System.out.println("one");
                    return true;
                }
            }

            if ((board[0][col] == 'x') && (board[2][col] =='x' )) {
                if (board[1][col] == '-'){
                    this.setPossibleCol(col);
                    this.setPossibleRow(1);
                    System.out.println("one");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean vertical(char [][] board){

        for (int i = 0; i < board.length; i++){
            if (this.Vhelper(i, board)){
                return true;
            }  
        }
    
        return false;

    }


    private boolean D1helper(char [][] board){
        
        if ((board[0][2] == 'x') && (board[1][1] =='x' )) {
            if (board[2][0] == '-'){
                this.setPossibleCol(0);
                this.setPossibleRow(2);
                System.out.println("one");
                return true;
            }
        }else {
            if ((board[0][2] == 'x') && (board[2][0] =='x' )) {
                if (board[1][1] == '-'){
                    this.setPossibleCol(1);
                    this.setPossibleRow(1);
                    System.out.println("one");
                    return true;
                }
            }

            if ((board[2][0] == 'x') && (board[1][1] =='x' )) {
                if (board[0][2] == '-'){
                    this.setPossibleCol(2);
                    this.setPossibleRow(0);
                    System.out.println("one");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean diagonalOne(char [][] board){
        return D1helper(board);
    }


    private boolean D2helper( char [][] board){
        
        if ((board[0][0] == 'x') && (board[1][1] =='x' )) {
            if (board[2][2] == '-'){
                this.setPossibleCol(2);
                this.setPossibleRow(2);
                System.out.println("one");
                return true;
            }
        }else {
            if ((board[2][2] == 'x') && (board[0][0] =='x' )) {
                if (board[1][1] == '-'){
                    this.setPossibleCol(1);
                    this.setPossibleRow(1);
                    System.out.println("one");
                    return true;
                }
            }

            if ((board[2][2] == 'x') && (board[1][1] =='x' )) {
                if (board[0][0] == '-'){
                    this.setPossibleCol(0);
                    this.setPossibleRow(0);
                    System.out.println("one");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean diagonalTwo(char [][] board) {
        return D2helper(board);
    }

    private void setPossibleCol(int col){
        this.possibleCol = col;
    }

    private int getPossibleCol(){
        return this.possibleCol;
    }

    private void setPossibleRow(int row) {
        this.possibleRow = row;
    }

    private int getPossibleRow(){
        return this.possibleRow;
    }
    public static void main(String[] args) {
    }

    @Override
    public void makeMove(char[][] board) {
        // TODO Auto-generated method stub
        
    }
}
