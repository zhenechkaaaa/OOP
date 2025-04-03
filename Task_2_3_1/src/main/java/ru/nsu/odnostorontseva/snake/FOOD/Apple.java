package ru.nsu.odnostorontseva.snake.FOOD;

import lombok.Getter;
import ru.nsu.odnostorontseva.snake.Snake;
import java.awt.Point;
import java.util.Random;

@Getter
public class Apple implements Food {
    private Point position;
    private static final int GRID_WIDTH = 15; // Ширина поля (в клетках)
    private static final int GRID_HEIGHT = 15; // Высота поля (в клетках)

    public Apple() {
        spawnFood();
    }

    public void spawnFood() {
        Random random = new Random();
        int x = random.nextInt(GRID_WIDTH) * 30;
        int y = random.nextInt(GRID_HEIGHT) * 30;
        position = new Point(x, y);
    }

    public boolean isEatenBy(Snake snake) {
        return snake.getHead().equals(position);
    }
}

