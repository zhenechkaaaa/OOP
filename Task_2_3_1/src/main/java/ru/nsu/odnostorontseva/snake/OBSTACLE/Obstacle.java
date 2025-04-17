package ru.nsu.odnostorontseva.snake.OBSTACLE;

import lombok.Getter;
import ru.nsu.odnostorontseva.snake.GameView;
import ru.nsu.odnostorontseva.snake.SNAKE.Snake;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Obstacle {
    private final Point position;
    private final Random random = new Random();
    private final int currentImageIndex = random.nextInt(0,2);

    public Obstacle(Point position) {
        this.position = position;
    }

    public static List<Obstacle> generateObstacles(Snake snake, int walls) {
        List<Obstacle> obstacles = new ArrayList<>();
        Random rand = new Random();

        int cellSize = GameView.CELL_SIZE;

        while (obstacles.size() < walls * 2) {
            Point first;
            Point second;
            do {
                int x = rand.nextInt(GameView.WIDTH / cellSize) * cellSize;
                int y = rand.nextInt(GameView.HEIGHT / cellSize) * cellSize;

                boolean horizontal = rand.nextBoolean();

                first = new Point(x, y);
                second = horizontal ? new Point(x + cellSize, y) : new Point(x, y + cellSize);
            } while (snake.getBody().contains(first) ||
                    snake.getBody().contains(second));

            obstacles.add(new Obstacle(first));
            obstacles.add(new Obstacle(second));
        }

        return obstacles;
    }
}
