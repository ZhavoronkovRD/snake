package com.game.snake.model.impl;

import com.game.snake.model.api.Position;
import com.game.snake.model.api.Snake;
import com.game.snake.model.api.SnakeSegment;
import com.game.snake.model.enums.MoveDirection;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class SnakeImpl implements Snake {
    private Position headPosition;
    private Queue<Position> growPositions;
    private MoveDirection moveDirection;
    private final Deque<SnakeSegment> segments;

    public SnakeImpl(Position initHeadPosition, int size) {
        this.headPosition = initHeadPosition;
        this.growPositions = new LinkedList<>();
        moveDirection = MoveDirection.RIGHT;
        segments = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            segments.add(new SnakeSegmentImpl(initHeadPosition.getX() - i, initHeadPosition.getY()));
        }
    }

    @Override
    public void setPosition(Position position) {
        this.headPosition = position;
    }

    @Override
    public Deque<SnakeSegment> getSegments() {
        return segments;
    }

    @Override
    public MoveDirection getDirection() {
        return moveDirection;
    }

    @Override
    public void changeDirection(MoveDirection moveDirection) {
        this.moveDirection = moveDirection;
//        // TODO: 1) Реализовать класс Snake
//        throw new UnsupportedOperationException();
    }

    @Override
    public Position move() {
        SnakeSegment tailSegment = segments.removeLast();
        Position growPosition = growPositions.peek();
        if (growPosition != null && growPosition.equals(tailSegment.getPosition())) {
            segments.addLast(new SnakeSegmentImpl(growPosition));
            growPositions.poll();
            System.out.println("Real grow. Snake size: " + (segments.size() + 1));
        }
        switch (moveDirection) {
            case UP: {
                headPosition = new PositionImpl(headPosition.getX(), headPosition.getY() - 1);
                break;
            }
            case DOWN: {
                headPosition = new PositionImpl(headPosition.getX(), headPosition.getY() + 1);
                break;
            }
            case LEFT: {
                headPosition = new PositionImpl(headPosition.getX() - 1, headPosition.getY());
                break;
            }
            case RIGHT: {
                headPosition = new PositionImpl(headPosition.getX() + 1, headPosition.getY());
                break;
            }
        }
        segments.addFirst(tailSegment);
        tailSegment.setPosition(headPosition);
        if (segments.stream().skip(4).anyMatch(it -> it.getPosition().equals(headPosition))) {
            eatTail();
        }
        return headPosition;
    }

    @Override
    public void grow() {
        System.out.println("Grow");
        growPositions.add(new PositionImpl(headPosition));
    }

    private void eatTail() {
        System.out.println("Eat tail. Size before: " + segments.size());
        Iterator<SnakeSegment> iterator = segments.iterator();
        while (iterator.hasNext()) {
            SnakeSegment next = iterator.next();
            if (next.getPosition().equals(headPosition)) {
                while (iterator.hasNext()) {
                    iterator.remove();
                    iterator.next();
                }
            }
        }
        System.out.println("Eat tail. Size after: " + segments.size());
    }

    @Override
    public String toString() {
        return "Snake: [" +
            segments.stream().map(SnakeSegment::toString).collect(Collectors.joining(",")) +
            "]";
    }
}
