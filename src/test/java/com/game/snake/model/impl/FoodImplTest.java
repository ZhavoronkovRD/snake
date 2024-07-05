package com.game.snake.model.impl;

import com.game.snake.model.api.Food;
import com.game.snake.model.api.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FoodImplTest {

    private Food food;

    @BeforeEach
    void setUp() {
        food = new FoodImpl(new PositionImpl(5, 5));
    }

    @Test
    void whenCreateFoodThenSetPermanentPosition() {
        Position position = food.getPosition();
        Assertions.assertEquals(5, position.getX());
        Assertions.assertEquals(5, position.getY());
    }
}