package ru.nsu.odnostorontseva.snake;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import ru.nsu.odnostorontseva.snake.FOOD.GoodFood;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class GameView {
    private final GraphicsContext gc;
    public static final int CELL_SIZE = 28;
    public static final int WIDTH = 420;
    public static final int HEIGHT = 420;
    public static final int NUM_OF_FOOD = 5;

    public GameView(Canvas canvas) {
        this.gc = canvas.getGraphicsContext2D();
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
