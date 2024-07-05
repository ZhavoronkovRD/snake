package com.game.snake.model.impl;

import com.game.snake.model.api.Food;
import com.game.snake.model.api.Position;

public class FoodImpl implements Food {

    public final Position position;

    public FoodImpl(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Food: " + position.toString();
    }
}
