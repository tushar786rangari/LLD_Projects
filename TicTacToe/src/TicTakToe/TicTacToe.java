package TicTakToe;

import java.util.Scanner;

public class TicTacToe {
    private final int width;
    char[][] board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    Scanner sc = new Scanner(System.in);

    public TicTacToe(Player player1, Player player2, int width) {
        this.width = width;
        board = new char[width][width];
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
        initializeBoard();
    }
    private void initializeBoard() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void start(){
        System.out.println("Starting TicTacToe");
        while(true){
            System.out.println("current Player: " + currentPlayer.getName()+ " give first index");
            int row = sc.nextInt();
            System.out.println("give second index");
            int col = sc.nextInt();
            if(!checkValidMove(row,col,currentPlayer)){
                System.out.println("Invalid Move");
                continue;
            }
            if(checkIfPlayerWin()){
                System.out.println("This player is winner: " + currentPlayer.getName());
                printBoard();
                break;
            }
            if(checkGameDraw()){
                printBoard();
                break;
            }
            currentPlayer = currentPlayer == player1 ? player2 : player1; //switch player
            printBoard();
        }
    }

    private void printBoard() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(System.lineSeparator());
        }
    }


    private boolean checkGameDraw() {
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < width; j++) {
                if(board[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkIfPlayerWin() {

        for(int i = 0; i < width; i++){
            if(checkRow(i,currentPlayer.getSymbol())){
                return true;
            }
        }
        for(int i = 0; i < width; i++){
            if(checkCol(i,currentPlayer.getSymbol())){
                return true;
            }
        }
        if(checkDiagonal(currentPlayer.getSymbol()) || checkReverseDiagonal(currentPlayer.getSymbol())){
            return true;
        }
        return false;
    }

    private boolean checkReverseDiagonal(char symbol) {
        for(int i = 0; i < width; i++){
            if(symbol != board[i][width-i - 1]){
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(char symbol) {
        for(int i = 0; i < width; i++){
            if(symbol != board[i][i]){
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(int col, char symbol) {
        for(int i = 0; i < width; i++){
            if(board[i][col] != symbol){
                return false;
            }
        }
        return true;
    }

    private boolean checkRow(int row,char symbol) {
        for (int i = 0; i < width; i++) {
            if(board[row][i] != symbol){
                return false;
            }
        }
        return true;
    }

    private boolean checkValidMove(int row, int col, Player currentPlayer) {
        if(row < 0 || row >= width || col < 0 || col >= width || board[row][col] != '-'){
            return false;
        }
        board[row][col] = currentPlayer.getSymbol();
        return true;
    }
}
