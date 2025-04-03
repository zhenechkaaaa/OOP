package ru.nsu.odnostorontseva.snake;

import javafx.scene.paint.Color;
import lombok.Getter;

import java.awt.Point;
import java.util.LinkedList;

@Getter
public class Snake {
    private final LinkedList<Point> body;
    private Direction direction;
    private static final int CELL_SIZE = 30;

    public Point getHead() {
        return body.getFirst();
    }

    public Snake(int startX, int startY) {
        body = new LinkedList<>();
        body.add(new Point(startX, startY)); // Голова змейки
        direction = Direction.RIGHT;
    }

    public void move() {
        Point head = getHead();
        Point newHead = new Point(head.x, head.y);

        switch (direction) {
            case UP -> newHead.y -= CELL_SIZE;
            case DOWN -> newHead.y += CELL_SIZE;
            case LEFT -> newHead.x -= CELL_SIZE;
            case RIGHT -> newHead.x += CELL_SIZE;
        };

        body.addFirst(newHead); // Добавляем новую голову
        body.removeLast(); // Убираем хвост (если не съели яблоко)
    }

    public void grow() {
        body.addLast(new Point(-1, -1));
    }

    public void setDirection(Direction newDirection) {
        if ((direction == Direction.UP && newDirection != Direction.DOWN) ||
                (direction == Direction.DOWN && newDirection != Direction.UP) ||
                (direction == Direction.LEFT && newDirection != Direction.RIGHT) ||
                (direction == Direction.RIGHT && newDirection != Direction.LEFT)) {
            this.direction = newDirection;
        }
    }
}
