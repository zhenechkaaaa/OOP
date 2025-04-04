package ru.nsu.odnostorontseva.snake.FOOD;

import lombok.Getter;
import lombok.Setter;
import ru.nsu.odnostorontseva.snake.GameView;
import ru.nsu.odnostorontseva.snake.SNAKE.Snake;
import java.awt.Point;
import java.util.Random;

@Getter
@Setter
public class GoodFood {
    private static final int GRID_WIDTH = GameView.WIDTH/GameView.CELL_SIZE; // Ширина поля (в клетках)
    private static final int GRID_HEIGHT = GameView.HEIGHT/GameView.CELL_SIZE; // Высота поля (в клетках)
    private final Random random = new Random();
    private Point position = new Point(
            random.nextInt(GRID_WIDTH) * GameView.CELL_SIZE,
            random.nextInt(GRID_HEIGHT) * GameView.CELL_SIZE);
    private int currentImageIndex = 0;


    public void spawnFood(Snake snake) {
        currentImageIndex = random.nextInt(0,3);
        Point newPosition;
        do {
            int x = random.nextInt(GRID_WIDTH) * GameView.CELL_SIZE;
            int y = random.nextInt(GRID_HEIGHT) * GameView.CELL_SIZE;
            newPosition = new Point(x, y);
        } while (snake.getBody().contains(newPosition)); // Проверяем, не внутри ли змейки
        position = newPosition;
    }
}

