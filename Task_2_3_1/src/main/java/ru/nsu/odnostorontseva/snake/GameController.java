package ru.nsu.odnostorontseva.snake;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.animation.AnimationTimer;
import ru.nsu.odnostorontseva.snake.FOOD.Apple;

public class GameController {
    @FXML private Canvas gameCanvas;
    private Snake snake;
    private GameView gameView;
    private Apple apple;

    private long lastUpdate;
    private static final long UPDATE_INTERVAL = 300000000;
    private AnimationTimer game;

    private int score;
    private boolean gameOver = false;

    @FXML
    public void initialize() {
        GraphicsContext gc = gameCanvas.getGraphicsContext2D();
        gameView = new GameView(gameCanvas);
        snake = new Snake(GameView.CELL_SIZE, GameView.CELL_SIZE);
        apple = new Apple();

        gameCanvas.setFocusTraversable(true);
        gameCanvas.setOnKeyPressed(this::onKeyPressed);

        startGameLoop();
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
        score = 0;
        game = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (!gameOver && now - lastUpdate >= UPDATE_INTERVAL) {
                    updateGame();
                    render();
                    lastUpdate = now;
                }
            }
        };
        game.start();
    }

    private void updateGame() {
        snake.move();

        if (snake.wallCollision() || snake.bodyCollision()) {
            gameOver = true;
            game.stop();
            return;
        }

        if (snake.Ate(apple)) {
            snake.grow();
            apple.spawnFood(snake);
            score++;
        }
    }

    private void render() {
        gameView.drawGrid();
        gameView.drawSnake(snake);
        gameView.drawFood(apple);
        gameView.drawScore(score);
        if (gameOver) {
            gameView.drawGameOver();
        }
    }
}
