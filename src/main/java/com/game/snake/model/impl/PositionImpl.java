package com.game.snake.model.impl;

import com.game.snake.model.api.Position;

public class PositionImpl implements Position {
    private final int x;
    private final int y;

    public PositionImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PositionImpl(Position position) {
        this.x = position.getX();
        this.y = position.getY();
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "{" +
            "x=" + x +
            ", y=" + y +
            '}'
            ;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Position position) {
            result = x == position.getX() && y == position.getY();
        }
        return result;
    }
}
