package ru.nsu.odnostorontseva.snake.FOOD;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static ru.nsu.odnostorontseva.snake.GameView.CELL_SIZE;

public class FoodView {
    private final GraphicsContext gc;
    private final List<Image> goodFoodImages;

    public FoodView(Canvas canvas) {
        this.gc = canvas.getGraphicsContext2D();
        goodFoodImages = new ArrayList<>();
        Image ratImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                "/pictures/krisa_NYAM_tile.png")));
        goodFoodImages.add(ratImage);
        Image mouseImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                "/pictures/mish_NYAM_tile.png")));
        goodFoodImages.add(mouseImage);
        Image fishImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                "/pictures/riba_NYAM_tile.png")));
        goodFoodImages.add(fishImage);
    }

    public void drawFood(GoodFood goodFood) {
        Point position = goodFood.getPosition();
        gc.drawImage(goodFoodImages.get(goodFood.getCurrentImageIndex()),
                position.x,
                position.y,
                CELL_SIZE, CELL_SIZE);
    }
}
