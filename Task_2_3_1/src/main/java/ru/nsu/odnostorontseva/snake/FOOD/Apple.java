package ru.nsu.odnostorontseva.snake.FOOD;

import lombok.Getter;
import ru.nsu.odnostorontseva.snake.GameView;
import ru.nsu.odnostorontseva.snake.Snake;
import java.awt.Point;
import java.util.Random;

@Getter
public class Apple implements Food {
    private static final int GRID_WIDTH = GameView.WIDTH/GameView.CELL_SIZE; // Ширина поля (в клетках)
    private static final int GRID_HEIGHT = GameView.HEIGHT/GameView.CELL_SIZE; // Высота поля (в клетках)
    private final Random random = new Random();
    private Point position = new Point(
            random.nextInt(GRID_WIDTH) * GameView.CELL_SIZE,
            random.nextInt(GRID_HEIGHT) * GameView.CELL_SIZE);


    public void spawnFood(Snake snake) {
        Point newPosition;
        do {
            int x = random.nextInt(GRID_WIDTH) * GameView.CELL_SIZE;
            int y = random.nextInt(GRID_HEIGHT) * GameView.CELL_SIZE;
            newPosition = new Point(x, y);
        } while (snake.getBody().contains(newPosition)); // Проверяем, не внутри ли змейки

        position = newPosition;
    }
}

