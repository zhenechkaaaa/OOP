package ru.nsu.odnostorontseva.snake.SNAKE;

import lombok.Getter;
import ru.nsu.odnostorontseva.snake.Direction;
import ru.nsu.odnostorontseva.snake.FOOD.GoodFood;
import ru.nsu.odnostorontseva.snake.GameView;
import ru.nsu.odnostorontseva.snake.OBSTACLE.Obstacle;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import static ru.nsu.odnostorontseva.snake.GameView.CELL_SIZE;

@Getter
public class Snake {
    private final List<Point> body;
    private Direction direction;
    private Direction nextDirection;
    private Point head;

    public Snake(int startX, int startY) {
        body = new ArrayList<>();
        head = new Point(startX, startY);
        body.add(head);
        direction = Direction.RIGHT;
        nextDirection = Direction.RIGHT;
    }

    public void move() {
        this.direction = this.nextDirection;

        double y = head.getY();
        double x = head.getX();

        switch (direction) {
            case UP -> y -= CELL_SIZE;
            case DOWN -> y += CELL_SIZE;
            case LEFT -> x -= CELL_SIZE;
            case RIGHT -> x += CELL_SIZE;
        };

        Point newHead = new Point((int) x, (int) y);
        body.addFirst(newHead);
        body.removeLast();
        head = newHead;
    }

    public void grow() {
        Point tail = body.getLast();
        body.add(new Point(tail.x, tail.y));
    }

    public void setDirection(Direction newDirection) {
        if ((direction == Direction.UP && newDirection != Direction.DOWN) ||
                (direction == Direction.DOWN && newDirection != Direction.UP) ||
                (direction == Direction.LEFT && newDirection != Direction.RIGHT) ||
                (direction == Direction.RIGHT && newDirection != Direction.LEFT)) {
            this.nextDirection = newDirection;
        }
    }

    public boolean Ate(GoodFood goodFood) {
        return head.getLocation().equals(goodFood.getPosition());
    }

    public boolean wallCollision() {
        return
                head.getX() < 0 ||
                        head.getY() < 0 ||
                        head.getX() >= GameView.WIDTH ||
                        head.getY() >= GameView.HEIGHT;
    }

    public boolean bodyCollision() {
        for (int i = 1; i < body.size(); i++) {
            if (head.getX() == body.get(i).getX() && head.getY() == body.get(i).getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean obstacleCollision(List<Obstacle> obstacles) {
        for (Obstacle obstacle : obstacles) {
            if (head.getLocation().equals(obstacle.getPosition())) {
                return true;
            }
        }
        return false;
    }
}
