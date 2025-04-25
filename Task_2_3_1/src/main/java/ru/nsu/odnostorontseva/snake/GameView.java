package ru.nsu.odnostorontseva.snake;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Objects;


public class GameView {
    private final GraphicsContext gc;
    public static final int CELL_SIZE = 28;
    public static final int WIDTH = 420;
    public static final int HEIGHT = 420;
    Image gridImage;

    public GameView(Canvas canvas) {
        this.gc = canvas.getGraphicsContext2D();
        gridImage =
                new Image(Objects.requireNonNull(getClass().getResourceAsStream("/pictures/ground_tile.png")));
    }

    public void drawGrid() {
        for (int row = 0; row < GameView.HEIGHT/CELL_SIZE; row++) {
            for (int col = 0; col < GameView.WIDTH/CELL_SIZE; col++) {
                gc.drawImage(gridImage,
                        col*CELL_SIZE,
                        row*CELL_SIZE,
                        CELL_SIZE,
                        CELL_SIZE);
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
