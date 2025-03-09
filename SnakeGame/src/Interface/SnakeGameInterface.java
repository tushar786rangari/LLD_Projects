package Interface;

import SnakeGame.Direction;
import SnakeGame.SnakeGame;

public interface SnakeGameInterface {
    void MoveTheSnake(Direction direction, SnakeGame snakeGameContext);
    boolean isTheGameOver(boolean isGameOver);
}
