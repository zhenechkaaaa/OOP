package ru.nsu.odnostorontseva.snake;

import javafx.scene.paint.Color;
import lombok.Getter;

import java.awt.Point;
import java.util.LinkedList;

public class Snake {
    @Getter
    private LinkedList<Point> body;
    private Direction direction;
    private static final int CELL_SIZE = 30;

    public Snake(int startX, int startY) {
        body = new LinkedList<>();
        body.add(new Point(startX, startY)); // Голова змейки
        direction = Direction.RIGHT;
    }

    public void move() {
        Point head = body.getFirst();
        Point newHead = switch (direction) {
            case UP -> new Point(head.x, head.y - CELL_SIZE);
            case DOWN -> new Point(head.x, head.y + CELL_SIZE);
            case LEFT -> new Point(head.x - CELL_SIZE, head.y);
            case RIGHT -> new Point(head.x + CELL_SIZE, head.y);
        };

        body.addFirst(newHead); // Добавляем новую голову
        body.removeLast(); // Убираем хвост (если не съели яблоко)
    }

    public void grow() {
        body.addLast(body.getLast()); // Добавляем новую часть к хвосту
    }

    public void setDirection(Direction newDirection) {
        if ((direction == Direction.UP && newDirection != Direction.DOWN) ||
                (direction == Direction.DOWN && newDirection != Direction.UP) ||
                (direction == Direction.LEFT && newDirection != Direction.RIGHT) ||
                (direction == Direction.RIGHT && newDirection != Direction.LEFT)) {
            this.direction = newDirection;
        }
    }

    public Color getColor() {
        return Color.PURPLE;
    }
}
