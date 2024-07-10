package com.game.snake.model.impl;

import com.game.snake.model.api.Position;

public class PositionImpl implements Position {

    private final int x;
    private final int y;

    public PositionImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
