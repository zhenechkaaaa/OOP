package ru.nsu.odnostorontseva.snake.SNAKE;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.canvas.Canvas;
import java.util.Objects;

import static ru.nsu.odnostorontseva.snake.GameView.CELL_SIZE;

public class SnakeView {
    private final GraphicsContext gc;
    private final Image snakeHeadImage;
    private final Image snakeBodyImage;
    private final Image snakeTailImage;

    public SnakeView(Canvas canvas) {
        this.gc = canvas.getGraphicsContext2D();
        snakeHeadImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                "/pictures/kitty_mordochka_tile.png")));
        snakeBodyImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                "/pictures/kitty_puzo_tile.png")));
        snakeTailImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                "/pictures/kitty_lapki_tile.png")));
    }

    public void drawSnake(Snake snake) {
        if(snake.getBody().size() == 1) {
            gc.drawImage(snakeHeadImage,
                    snake.getHead().getX(),
                    snake.getHead().getY(),
                    CELL_SIZE, CELL_SIZE);
        } else {
            gc.drawImage(snakeHeadImage,
                    snake.getHead().getX(),
                    snake.getHead().getY(),
                    CELL_SIZE, CELL_SIZE);
            for(int i = 1; i<snake.getBody().size() - 1; i++){
                gc.drawImage(snakeBodyImage,
                        snake.getBody().get(i).getX(),
                        snake.getBody().get(i).getY(),
                        CELL_SIZE, CELL_SIZE);
            }
            gc.drawImage(snakeTailImage,
                    snake.getBody().getLast().getX(),
                    snake.getBody().getLast().getY(),
                    CELL_SIZE, CELL_SIZE);
        }
    }
}
