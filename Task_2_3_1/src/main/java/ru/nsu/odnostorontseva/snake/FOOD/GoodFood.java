package ru.nsu.odnostorontseva.snake.FOOD;

import lombok.Getter;
import lombok.Setter;
import ru.nsu.odnostorontseva.snake.GameView;
import ru.nsu.odnostorontseva.snake.OBSTACLE.Obstacle;
import ru.nsu.odnostorontseva.snake.SNAKE.Snake;
import java.awt.Point;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class GoodFood {
    private static final int GRID_WIDTH = GameView.WIDTH/GameView.CELL_SIZE;
    private static final int GRID_HEIGHT = GameView.HEIGHT/GameView.CELL_SIZE;
    private final Random random = new Random();
    private Point position = new Point(
            random.nextInt(GRID_WIDTH) * GameView.CELL_SIZE,
            random.nextInt(GRID_HEIGHT) * GameView.CELL_SIZE);
    private int currentImageIndex = 0;


    public void spawnFood(Snake snake, List<Obstacle> obstacles) {
        currentImageIndex = random.nextInt(0,3);
        Point newPosition;
        do {
            int x = random.nextInt(GRID_WIDTH) * GameView.CELL_SIZE;
            int y = random.nextInt(GRID_HEIGHT) * GameView.CELL_SIZE;
            newPosition = new Point(x, y);
        } while (isOccupied(snake, obstacles, newPosition));
        position = newPosition;
    }

    private boolean isOccupied(Snake snake, List<Obstacle> obstacles, Point newPosition) {
        for (Obstacle obstacle : obstacles) {
            if (newPosition.equals(obstacle.getPosition())) {
                return true;
            }
        }
        return snake.getBody().contains(newPosition);
    }
}

