package ru.nsu.odnostorontseva.snake.OBSTACLE;

import static ru.nsu.odnostorontseva.snake.GameView.CELL_SIZE;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ObstacleView {
    private final GraphicsContext gc;
    private final List<Image> obstacleImages;

    public ObstacleView(Canvas canvas) {
        this.gc = canvas.getGraphicsContext2D();
        obstacleImages = new ArrayList<>();
        Image bushImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                "/pictures/kust_tile.png")));
        obstacleImages.add(bushImage);
        Image bushBerriesImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                "/pictures/kust_berries_tile.png")));
        obstacleImages.add(bushBerriesImage);
    }

    public void drawObstacle(Obstacle obstacle) {
        Point position = obstacle.getPosition();
        gc.drawImage(obstacleImages.get(obstacle.getCurrentImageIndex()),
                position.x,
                position.y,
                CELL_SIZE, CELL_SIZE);
    }
}
