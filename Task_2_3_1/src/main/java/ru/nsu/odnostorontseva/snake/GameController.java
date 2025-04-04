package ru.nsu.odnostorontseva.snake;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.animation.AnimationTimer;
import ru.nsu.odnostorontseva.snake.FOOD.FoodView;
import ru.nsu.odnostorontseva.snake.FOOD.GoodFood;
import ru.nsu.odnostorontseva.snake.SNAKE.Snake;
import ru.nsu.odnostorontseva.snake.SNAKE.SnakeView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameController {
    @FXML private Canvas gameCanvas;
    private Snake snake;
    private GameView gameView;
    private SnakeView snakeView;
    private FoodView foodView;
    private List<GoodFood> goodFoodList;

    private long lastUpdate;
    private static final long UPDATE_INTERVAL = 300000000;
    private AnimationTimer game;

    private int score;
    private boolean gameOver = false;

    @FXML
    public void initialize() {
        GraphicsContext gc = gameCanvas.getGraphicsContext2D();
        gameView = new GameView(gameCanvas);
        snakeView = new SnakeView(gameCanvas);
        foodView = new FoodView(gameCanvas);
        snake = new Snake(GameView.CELL_SIZE, GameView.CELL_SIZE);
        goodFoodList = new ArrayList<GoodFood>();
        for(int i = 0; i< GameView.NUM_OF_FOOD; i++){
            GoodFood goodFood = new GoodFood();
            goodFood.spawnFood(snake);
            goodFoodList.add(goodFood);
        }

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

        List<GoodFood> add = new ArrayList<>();
        Iterator<GoodFood> it = goodFoodList.iterator();
        while (it.hasNext()) {
            GoodFood food = it.next();
            if (snake.Ate(food)) {
                snake.grow();
                it.remove();
                score++;
                GoodFood newFood = new GoodFood();
                newFood.spawnFood(snake);
                add.add(newFood);
            }
        }
        goodFoodList.addAll(add);
    }

    private void render() {
        gameView.drawGrid();
        snakeView.drawSnake(snake);
        for (GoodFood food : goodFoodList) {
            foodView.drawFood(food);
        }
        gameView.drawScore(score);
        if (gameOver) {
            gameView.drawGameOver();
        }
    }
}
