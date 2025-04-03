package ru.nsu.odnostorontseva.snake;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.Point;

public class GameView {
    private final GraphicsContext gc;
    private static final int CELL_SIZE = 30;
    private static final int WIDTH = 450;
    private static final int HEIGHT = 450;

    public GameView(Canvas canvas) {
        this.gc = canvas.getGraphicsContext2D();
        drawGrid();
    }

    // Метод для рисования поля
    public void drawGrid() {
        gc.setFill(Color.web("#ffdbde"));
        gc.fillRect(0, 0, WIDTH, HEIGHT);

        gc.setStroke(Color.DARKGRAY);
        for (int x = 0; x < WIDTH; x += CELL_SIZE) {
            for (int y = 0; y < HEIGHT; y += CELL_SIZE) {
                gc.strokeRect(x, y, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    // Метод для рисования змейки
    public void drawSnake(Snake snake) {
        gc.setFill(snake.getColor());
        for (Point part : snake.getBody()) {
            gc.fillRect(part.x, part.y, CELL_SIZE, CELL_SIZE);
        }
    }
}
