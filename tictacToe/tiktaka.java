package tictacToe;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;


public class tiktaka{

    char [][] board = new char [3][3];
    String player1;
    String player2;
    Boolean turn;
    char o = 'o';
    char x = 'x';
    int row;
    int col;
    boolean gameEnded = true;

    FileOutputStream fout = null;

    Scanner input = new Scanner(System.in);

    public char[][] fillBoardWithDashes(){

        for(int i = 0; i < this.board.length; i++){
            for (int j = 0; j < this.board.length; j++){
                board[i][j] = '-';
            }
        }

        return board;
    }

    public void setPlayersName(){
        

        System.out.println("Wanna take on Isabella.......??(enter yes or no)");

        String choice = input.next();

        String yesOrNo = "yes";

        if (choice.compareTo(yesOrNo) == 0) {
            this.player1 = "isabella";
            System.out.println("enter your name:");
            this.player2 = input.next();
        }else{
            System.out.println("enter player one's name:");
            this.player1 = input.next();
            System.out.println("enter player two's name:");
            this.player2 = input.next();
        }

        /*System.out.println("enter player one's name:");
        this.player1 = input.next();
        System.out.println("enter player two's name:");
        this.player2 = input.next();*/

       // input.close();

    }

    public String getplayerone(){
        return this.player1;
    }

    public String getplayertwo(){
        return this.player2;
    }

    public void printBoard(char board [][]){
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++ ){
               System.out.print("  "+board[i][j]+"   ");
               
            }
            System.out.println();
        }
    }

    public void printBoardTofile(String pOne, String pTwo, char board[][]){
        try (FileWriter fw = new FileWriter("history.txt", true)) {
            fw.write(".........."+pOne+" and "+pTwo+"'s game..........\n");
            for(int i = 0; i < board.length; i++){
                for (int j = 0; j < board.length; j++ ){
                   fw.write("  "+board[i][j]+"   |");
                   
                }
                  fw.write('\n');
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public void trackTurns(boolean t, String player){
        this.turn = t;
        if (turn == true){
            System.out.println(this.getplayerone()+"'s turn.");
            this.setRowAndCol();
            this.mark(player);
        }else{
            System.out.println(this.getplayertwo()+"'s turn.");
            this.setRowAndCol();
            this.mark(player);
        }
    }

    public boolean getTurn(){
        return this.turn;
    }

    public void setRowAndCol(){
      //  Scanner s = new Scanner(System.in);

        System.out.println("enter row:");
        int r = input.nextInt();
        while (r > 2 || r < 0){
            System.out.println("enter 0, 1, 2:"); 
            r = input.nextInt();
        }
            this.row = r;
        //column
        System.out.println("enter column:");
        //this.col = s.nextInt();
        int c = input.nextInt();
        while (c > 2 || c < 0){
            System.out.println("enter 0, 1, 2:"); 
            c = input.nextInt();
        }
            this.col = c;
        
       // s.close();
    }

    public int getRow(){
        return this.row;
    }
    public int getColumn(){
        return this.col;
    }

    public void mark(String player){
        if (player == this.player1){
            this.board[this.getRow()][this.getColumn()] = this.x;
        }else{
            this.board[this.getRow()][this.getColumn()] = this.o;
        }
    }


    public boolean checkForVericalWin(char [][] board){
        char j0 = 'k', j1 = 'l' , j2 = 'v';

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if ((j == 0) && (board[i][j] != '-')){
                    j0 = board[i][j];
                }
                if ((j == 1) && (board[i][j] != '-')){
                    j1 = board[i][j];
                }
                if ((j == 2) && (board[i][j] != '-')){
                    j2 = board[i][j];
                }
            }

            if( j0 == j1) {
                if ( j0 == j2) {
                    if ( j1 == j2) {
                        if (j2 == 'x'){
                            System.out.println(this.getplayerone()+" wins");
                        }else {
                            System.out.println(this.getplayertwo()+" wins");
                        }
                        return true;
                    }
                }
            }
        }

        return false;
    } 

    public boolean checkForHorizontalWin(char [][] board){
        char i0 = 'p', i1 = '$', i2 = 'k';

        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < 1; j++){
                if ((i == 0) && (board[i][j] != '-')) {
                    i0 = board[i][j];
                }
                if ((i == 1) && (board[i][j] != '-')) {
                    i1 = board[i][j];
                }
                if ((i == 2) && (board[i][j] != '-')) {
                    i2 = board[i][j];
                }
            }
        }

        if (i0 == i1) {
            if (i0 == i2) {
                if (i1 == i2) {
                    
                    if (i2 == 'x'){
                        System.out.println(this.getplayerone()+" wins");
                    }else {
                        System.out.println(this.getplayertwo()+" wins");
                    }
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkDiagonalOne(char [][] board){
        char d0 = 'g', d1 = 'h', d2 = '*';

        for (int i = 0; i < board.length; i++){
            for ( int j = 0; j < board.length; j++){
                if (((i == 0) && (j == 0)) && (board[i][j] != '-')){
                    
                    d0 = board[i][j];
                }
                if (((i == 1) && (j == 1)) && (board[i][j] != '-')){
                    d1 = board[1][j];
                }
                if (((i == 2) && (j == 2)) && (board[i][j] != '-')){
                    d2 = board[i][j];
                }
            }
        }

        if (d0 == d1) {
            if (d0 == d2) {
                if (d1 == d2) {
                    if (d2 == 'x'){
                        System.out.println(this.getplayerone()+" wins");
                    }else {
                        System.out.println(this.getplayertwo()+" wins");
                    }
                    return true;
                }
            }
         }

        return false;
    }

    public boolean checkDiagonalTwo(char [][] board){
        char d0 = 'g', d1 = 'h', d2 = '*';

        for (int i = 0; i < board.length; i++){
            for ( int j = 0; j < board.length; j++){
                if (((i == 2) && (j == 0)) && (board[i][j] != '-')){
                    d0 = board[i][j];
                }
                if (((i == 1) && (j == 1)) && (board[i][j] != '-')){
                    d1 = board[1][j];
                }
                if (((i == 0) && (j == 2)) && (board[i][j] != '-')){
                    d2 = board[i][j];
                }
            }
        }

        if (d0 == d1) {
            if (d0 == d2) {
                if (d1 == d2) {
                    if (d2 == 'x'){
                        System.out.println(this.getplayerone()+" wins");
                    }else {
                        System.out.println(this.getplayertwo()+" wins");
                    }
                    return true;
                }
            }
         }

        return false;
    }

    public boolean checkForWin(char [][] board){

        boolean vertical = this.checkForVericalWin(board);
        boolean horizotal = this.checkForHorizontalWin(board);
        boolean diagonalOne = this.checkDiagonalOne(board);
        boolean diagonalTwo = this.checkDiagonalTwo(board);

        if ((vertical || horizotal || diagonalOne || diagonalTwo ) == true) {

            this.gameEnded = false;
            this.printFinalBoard(board);

            return true;
        }
        
        return false;
    }

    public boolean checkForDraw(char [][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++){
                if (board [i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }

    public void printFinalBoard(char [][] board){
        this.printBoard(board);
    }

    public void verseIsabella(char [][] board, boolean turn){
        System.out.println("hi, im Isabella .....i'll be whooping your ass today");
        new isabella(board, turn);
    }

    public static void main(String[] args) {
        tiktaka t = new tiktaka();

        char[][] board = t.fillBoardWithDashes();
        t.setPlayersName();
        System.out.println("player one: "+t.getplayerone());
        System.out.println("player two: "+t.getplayertwo());
        

        // gameEnded = true;

        boolean playerOne = true;
        boolean playerTwo = false;

        while (t.gameEnded) {
            System.out.println("........Current Board.......");
            t.printBoard(board);
            t.printBoardTofile(t.getplayerone(), t.getplayertwo(), board);

            //player one's turn choice.compareTo(yesOrNo) == 0
            if(t.getplayerone().compareTo("isabella") == 0) { 
                t.verseIsabella(board, playerOne);

                boolean Iwin = t.checkForWin(board);
                if (Iwin == true) {
                    t.gameEnded = false;
                    break;
                }
            
            }else{
                t.trackTurns(playerOne, t.player1);
                boolean Owin = t.checkForWin(board);
                if (Owin == true) {
                    t.gameEnded = false;
                    break;
                }
            }


            //t.trackTurns(playerOne, t.player1);
            //check for player one's win
           
            
            //player one plays last if the game is to end in a draw
            boolean r = t.checkForDraw(board);
            if (r == true) {
                System.out.println("Game is a draw");
                t.printFinalBoard(board);
                t.gameEnded = false;
                break;
            }

            System.out.println("........Current Board.......");
            t.printBoard(board);
           // t.printBoardTofile(t.getplayerone(), t.getplayertwo(), board);
            t.trackTurns(playerTwo, t.player2);

            boolean twin = t.checkForWin(board);
            t.printBoardTofile(t.getplayerone(), t.getplayertwo(), board);
            if (twin == true) {
                t.gameEnded = false;
                break;
            }

           
        }
      
    }
    
}