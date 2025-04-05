import TicTakToe.Player;
import TicTakToe.TicTacToe;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give width of board: ");
        int width = sc.nextInt();

        Player player1 = new Player("Vel",'X');
        Player player2 = new Player("Shark",'O');

        TicTacToe ticTakToe = new TicTacToe(player1,player2,width);
        ticTakToe.start();
    }
}