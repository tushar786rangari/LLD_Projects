package SnakeGame;

import java.util.Arrays;
import java.util.LinkedList;

public class SnakeGame {
    final int width;
    final int height;
    final int thresholdSnakeSize;
    private LinkedList<int[]> snake;
    private int movesSinceLastGrowth;
    private Direction currentDirection;
    private Boolean isGameOver;
    MoveTheSnakeViaInterface moveTheSnakeViaInterface = new MoveTheSnakeViaInterface();


    public SnakeGame(int width, int height, int thresholdSnakeSize) {
        this.width = width;
        this.height = height;
        this.thresholdSnakeSize = thresholdSnakeSize;
        this.snake = new LinkedList<>();
        this.movesSinceLastGrowth = 0;
        snake.add(new int[]{0, 0});
        currentDirection = Direction.right;
        isGameOver = false;
    }

    public void moveTheSnake(Direction direction) {
        //check the direction and check with current direction
        //iuncrement the head
        //check the wrap conditions
        //check if it didnt collide with itself
        //check the snakesize and threshold accordingly remove the tail
        //update the hed
        moveTheSnakeViaInterface.MoveTheSnake(direction,SnakeGame.this);
    }

    public void isTheGameOver() {
        if(moveTheSnakeViaInterface.isTheGameOver(isGameOver)){
            System.out.println("Game Over");
        }
        else{
            System.out.println("Game is not Over Yet hehe hahha haha..");
        }
    }

    public void printSnake() {
        char[][] board = new char[width][height];
        for(char[] row : board) {
            Arrays.fill(row, '.');
        }
        for(int[] row : snake) {
            board[row[0]][row[1]] = '0';
        }
        for(char[] row : board){
            System.out.println(new String (row));
        }
        System.out.println();
    }

    int getMovesSinceLastGrowth() {
        return movesSinceLastGrowth;
    }

     void setMovesSinceLastGrowth(int movesSinceLastGrowth) {
        this.movesSinceLastGrowth = movesSinceLastGrowth;
    }

     Boolean getGameOver() {
        return isGameOver;
    }

    void setGameOver(Boolean val) {
        isGameOver = val;
    }

    LinkedList<int[]> getSnake() {
        return snake;
    }

     void setSnake(LinkedList<int[]> snake) {
        this.snake = snake;
    }

     int getThresholdSnakeSize() {
        return thresholdSnakeSize;
    }

     int getHeight() {
        return height;
    }

     int getWidth() {
        return width;
    }

     Direction getCurrentDirection() {
        return currentDirection;
    }

     void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }


}
