package com.game.snake.model.impl;

import com.game.snake.model.api.Position;
import com.game.snake.model.api.Snake;
import com.game.snake.model.api.SnakeSegment;
import com.game.snake.model.enums.MoveDirection;

import java.util.Deque;

public class SnakeImpl implements Snake {

    @Override
    public void setPosition(Position position) {
//       TODO: реализорвать метод установки положения змейки
         throw new UnsupportedOperationException();
    }

    @Override
    public Deque<SnakeSegment> getSegments() {
        throw new UnsupportedOperationException();
    }

    @Override
    public MoveDirection getDirection() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeDirection(MoveDirection moveDirection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Position move() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void grow() {
        throw new UnsupportedOperationException();
    }
}
