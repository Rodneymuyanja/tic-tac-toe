package tictacToe;

public class strategies {
    public boolean oldLadysJoke(char [][] board, boolean turn){

        while(turn){
            
        if (board [2][0] == '-'){
            board[2][0] = 'x';
            turn = false;
        }else { 
            return false;
        }

        if (board[2][0] == 'x'){
            if (board[0][2] == '-') {
                board[0][2] = 'x';
                turn = false;
            } else {
                return false;
            }
        }

        if (board[2][0] == 'x'){
            if (board[0][2] == 'x') {
                if (board[2][2] == '-') {
                    board[2][2] = 'x';
                    turn = false;
                } else {
                    return false;
                }
            }
        }
        }

        return true;
    }
    public static void main(String[] args) {
      /*  tiktaka t = new tiktaka();
        t.fillBoardWithDashes();

        strategies s = new strategies();
        
        boolean k = s.oldLadysJoke(t.board);
        System.out.println(k);*/
    }
}
