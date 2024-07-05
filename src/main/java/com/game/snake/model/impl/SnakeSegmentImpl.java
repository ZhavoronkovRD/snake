package com.game.snake.model.impl;

import com.game.snake.model.api.Position;
import com.game.snake.model.api.SnakeSegment;

public class SnakeSegmentImpl implements SnakeSegment {

    private Position position;

    public SnakeSegmentImpl(int x, int y) {
        position = new PositionImpl(x, y);
    }

    public SnakeSegmentImpl(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = new PositionImpl(position);
    }

    @Override
    public String toString() {
        return position.toString();
    }
}
