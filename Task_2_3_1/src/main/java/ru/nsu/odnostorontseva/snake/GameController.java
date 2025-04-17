package ru.nsu.odnostorontseva.snake;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.animation.AnimationTimer;
import ru.nsu.odnostorontseva.snake.FOOD.FoodView;
import ru.nsu.odnostorontseva.snake.FOOD.GoodFood;
import ru.nsu.odnostorontseva.snake.OBSTACLE.Obstacle;
import ru.nsu.odnostorontseva.snake.OBSTACLE.ObstacleView;
import ru.nsu.odnostorontseva.snake.SNAKE.Snake;
import ru.nsu.odnostorontseva.snake.SNAKE.SnakeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameController {
    @FXML private Canvas gameCanvas;
    private Snake snake;
    private SnakeView snakeView;
    private GameView gameView;
    private FoodView foodView;
    private ObstacleView obstacleView;
    private List<GoodFood> goodFoodList;
    private List<Obstacle> obstacles;

    private long lastUpdate;
    private static final long UPDATE_INTERVAL = 300_000_000;
    private static final int NUM_OBSTACLES = 7;
    private static final int NUM_GOOD_FOODS = 5;
    private static final int NUM_FOOD_FOR_NEXT_LEVEL = 5;
    private AnimationTimer game;

    private int score;
    private boolean gameOver = false;
    private int level = 1;
    private long updateInterval = UPDATE_INTERVAL;

    @FXML
    public void initialize() {
        GraphicsContext gc = gameCanvas.getGraphicsContext2D();
        gameView = new GameView(gameCanvas);
        snakeView = new SnakeView(gameCanvas);
        foodView = new FoodView(gameCanvas);
        obstacleView = new ObstacleView(gameCanvas);
        snake = new Snake(GameView.CELL_SIZE, GameView.CELL_SIZE);
        goodFoodList = new ArrayList<>();
        obstacles = new ArrayList<>();
        for(int i = 0; i < NUM_GOOD_FOODS; i++){
            GoodFood goodFood = new GoodFood();
            goodFood.spawnFood(snake, obstacles);
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
                if (!gameOver && now - lastUpdate >= updateInterval) {
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

        if (snake.wallCollision() || snake.bodyCollision() || snake.obstacleCollision(obstacles)) {
            gameOver = true;
            game.stop();
            return;
        }

        if (score != 0 && score % NUM_FOOD_FOR_NEXT_LEVEL == 0) {
            level++;
            applyLevelSettings();
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
                newFood.spawnFood(snake, obstacles);
                add.add(newFood);
            }
        }
        goodFoodList.addAll(add);
    }

    private void render() {
        gameView.drawGrid();
        snakeView.drawSnake(snake);
        for (Obstacle obstacle : obstacles) {
            obstacleView.drawObstacle(obstacle);
        }
        for (GoodFood food : goodFoodList) {
            foodView.drawFood(food);
        }
        gameView.drawScore(score);
        if (gameOver) {
            gameView.drawGameOver();
        }
    }

    private void applyLevelSettings() {
        switch (level) {
            case 2 -> {
                updateInterval -= 100_000_000;
                obstacles = Obstacle.generateObstacles(snake, NUM_OBSTACLES);
            }
            case 3 -> {
                updateInterval -= 100_000_000;
            }
            default -> updateInterval = UPDATE_INTERVAL;
        }
    }
}
