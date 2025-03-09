import SnakeGame.SnakeGame;
import SnakeGame.Direction;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the width of the board: ");
        int width = sc.nextInt();
        System.out.println("Enter the height of the board: ");
        int height = sc.nextInt();
        System.out.println("Enter after how many movements size of snake should increase");
        int movementsSize = sc.nextInt();
        SnakeGame snakeGame = new SnakeGame(width,height,movementsSize);
        snakeGame.moveTheSnake(Direction.right);
        snakeGame.printSnake();
        snakeGame.moveTheSnake(Direction.up);
        snakeGame.printSnake();
        snakeGame.moveTheSnake(Direction.up);
        snakeGame.printSnake();
        snakeGame.moveTheSnake(Direction.right);
        snakeGame.printSnake();
        snakeGame.moveTheSnake(Direction.right);
        snakeGame.printSnake();
        snakeGame.moveTheSnake(Direction.down);
        snakeGame.printSnake();
        snakeGame.moveTheSnake(Direction.down);
        snakeGame.printSnake();
        snakeGame.moveTheSnake(Direction.down);
        snakeGame.printSnake();
        snakeGame.moveTheSnake(Direction.down);
        snakeGame.printSnake();
        snakeGame.moveTheSnake(Direction.down);
        snakeGame.printSnake();
        snakeGame.isTheGameOver();
    }
}