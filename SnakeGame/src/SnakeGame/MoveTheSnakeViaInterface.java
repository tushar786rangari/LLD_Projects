package SnakeGame;

import Interface.SnakeGameInterface;
public class MoveTheSnakeViaInterface implements SnakeGameInterface {

    public void  MoveTheSnake(Direction direction, SnakeGame snakeGameContext) {
        if(     (direction == Direction.up && snakeGameContext.getCurrentDirection() == Direction.down) ||
                (direction == Direction.left && snakeGameContext.getCurrentDirection() == Direction.right) ||
                (direction == Direction.right && snakeGameContext.getCurrentDirection() == Direction.left) ||
                (direction == Direction.down && snakeGameContext.getCurrentDirection() == Direction.up)) {
            direction = snakeGameContext.getCurrentDirection();
        }
        int[] currPosition = snakeGameContext.getSnake().getFirst();
        int newX = currPosition[0];
        int newY = currPosition[1];
        switch(direction) {
            case up:newX--; break;
            case down:newX++; break;
            case left:newY--; break;
            case right:newY++; break;
        }

        //wrap logic
        if(newX < 0)
            newX = snakeGameContext.getWidth()-1;
        else if(newX >= snakeGameContext.getWidth())
            newX = 0;
        if(newY < 0)
            newY = snakeGameContext.getHeight()-1;
        else if(newY >= snakeGameContext.getHeight())
            newY = 0;

        //check colliosion
        for(var it : snakeGameContext.getSnake()){
            if(it[0] == newX && it[1] == newY){
                snakeGameContext.setGameOver(true);
                return;
            }
        }
        snakeGameContext.setMovesSinceLastGrowth(snakeGameContext.getMovesSinceLastGrowth()+1);
        snakeGameContext.getSnake().addFirst(new int[]{newX, newY});

        if(snakeGameContext.getMovesSinceLastGrowth() < snakeGameContext.getThresholdSnakeSize()) {
            snakeGameContext.getSnake().removeLast();
        }
        else {
            snakeGameContext.setMovesSinceLastGrowth(0);
        }

    }

    @Override
    public boolean isTheGameOver(boolean game){
        return game;
    }
}
