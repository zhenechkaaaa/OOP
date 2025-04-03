package ru.nsu.odnostorontseva.snake;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import ru.nsu.odnostorontseva.snake.FOOD.Apple;
import java.awt.Point;
import java.util.Objects;


public class GameView {
    private final GraphicsContext gc;
    public static final int CELL_SIZE = 28;
    public static final int WIDTH = 420;
    public static final int HEIGHT = 420;
    private final Image foodImage;
    private final Image snakeHeadImage;
    private final Image snakeBodyImage;
    private final Image snakeTailImage;

    public GameView(Canvas canvas) {
        this.gc = canvas.getGraphicsContext2D();
        foodImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                "/pictures/krisa_NYAM_tile.png")));
        snakeHeadImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                "/pictures/kitty_mordochka_tile.png")));
        snakeBodyImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                "/pictures/kitty_puzo_tile.png")));
        snakeTailImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                "/pictures/kitty_lapki_tile.png")));
        drawGrid();
    }

    public void drawGrid() {
        gc.setFill(Color.web("fcb4d5"));
        gc.fillRect(0, 0, WIDTH, HEIGHT);

        gc.setStroke(Color.DARKGRAY);
        for (int x = 0; x < WIDTH; x += CELL_SIZE) {
            for (int y = 0; y < HEIGHT; y += CELL_SIZE) {
                gc.strokeRect(x, y, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    public void drawSnake(Snake snake) {
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

    public void drawFood(Apple apple) {
        Point position = apple.getPosition();
        gc.drawImage(foodImage, position.x, position.y, CELL_SIZE, CELL_SIZE);
    }

    public void drawGameOver() {
        gc.setFill(Color.web("#ffdbde"));
        gc.fillRect(0, 0, WIDTH, HEIGHT);
        gc.setFont(new Font("Verdana", 50));
        gc.setFill(Color.web("#fb607f"));
        gc.fillText("Game Over =(", 15, HEIGHT / 2.0);
    }

    public void drawScore(int score) {
        gc.setFill(Color.BLACK);
        gc.setFont(new Font("Arial", 25));
        gc.fillText("Score: " + score, 300, 25);
    }
}
