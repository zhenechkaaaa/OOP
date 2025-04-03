package ru.nsu.odnostorontseva.snake;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.animation.AnimationTimer;

public class GameController {
    @FXML private Canvas gameCanvas;
    private GraphicsContext gc;
    private Snake snake;
    private GameView gameView;
    private static final int WIDTH = 450;
    private static final int HEIGHT = 450;

    private long lastUpdate = 0; // Время последнего обновления
    private static final long UPDATE_INTERVAL = 500000000;

    @FXML
    public void initialize() {
        gc = gameCanvas.getGraphicsContext2D();
        gameView = new GameView(gameCanvas);
        snake = new Snake(0, 0); // Змейка появляется в центре
        startGameLoop();

        gameCanvas.setFocusTraversable(true);
        gameCanvas.setOnKeyPressed(this::onKeyPressed);
    }

    @FXML
    public void onKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case UP, W -> snake.setDirection(Direction.UP);
            case DOWN, S -> snake.setDirection(Direction.DOWN);
            case LEFT, A -> snake.setDirection(Direction.LEFT);
            case RIGHT, D -> snake.setDirection(Direction.RIGHT);
        }
    }

    private void startGameLoop() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (now - lastUpdate >= UPDATE_INTERVAL) {
                    updateGame();
                    render();
                    lastUpdate = now; // Обновляем время последнего обновления
                }
            }
        }.start();
    }

    private void updateGame() {
        snake.move();
    }

    private void render() {
        gameView.drawGrid(); // Отрисовываем поле
        gameView.drawSnake(snake); // Отрисовываем змейку
    }
}
