//package com.game.snake.model;
//
//import com.game.snake.model.api.Position;
//import com.game.snake.model.api.Snake;
//import com.game.snake.model.enums.MoveDirection;
//import com.game.snake.model.impl.PositionImpl;
//import com.game.snake.model.impl.SnakeImpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//
//public class SnakeImplTest {
//
//    private Snake snake;
//
//    @BeforeEach
//    void setUp() {
//        snake = new SnakeImpl(new PositionImpl(), 1);
//    }
//
//    @Test
//    public void whenMoveDirectionIsUpMoveSnakeUp() {
//        Position initPosition = new PositionImpl(snake.getHeadPosition());
//        snake.changeDirection(MoveDirection.UP);
//        snake.start();
//        try {
//            Thread.sleep(5);
//        } catch (InterruptedException e) {
//        }
//        Position newPosition = new PositionImpl(snake.getHeadPosition());
//        Assertions.assertEquals(initPosition.getX(), newPosition.getX());
//        Assertions.assertEquals(initPosition.getY() - 1, newPosition.getY());
//    }
//
//    @Test
//    public void whenMoveDirectionIsDownMoveSnakeDown() {
//        Position initPosition = new PositionImpl(snake.getHeadPosition());
//        snake.changeDirection(MoveDirection.DOWN);
//        snake.start();
//        try {
//            Thread.sleep(5);
//        } catch (InterruptedException e) {
//        }
//        Position newPosition = new PositionImpl(snake.getHeadPosition());
//        Assertions.assertEquals(initPosition.getX(), newPosition.getX());
//        Assertions.assertEquals(initPosition.getY() + 1, newPosition.getY());
//    }
//
//    @Test
//    public void whenMoveDirectionIsLeftMoveSnakeLeft() {
//        Position initPosition = new PositionImpl(snake.getHeadPosition());
//        snake.changeDirection(MoveDirection.LEFT);
//        snake.start();
//        try {
//            Thread.sleep(5);
//        } catch (InterruptedException e) {
//        }
//        Position newPosition = new PositionImpl(snake.getHeadPosition());
//        Assertions.assertEquals(initPosition.getX() - 1, newPosition.getX());
//        Assertions.assertEquals(initPosition.getY(), newPosition.getY());
//    }
//
//    @Test
//    public void whenMoveDirectionIsRightMoveSnakeRight() {
//        Position initPosition = new PositionImpl(snake.getHeadPosition());
//        snake.changeDirection(MoveDirection.RIGHT);
//        snake.start();
//        try {
//            Thread.sleep(5);
//        } catch (InterruptedException e) {
//        }
//        Position newPosition = new PositionImpl(snake.getHeadPosition());
//        Assertions.assertEquals(initPosition.getX() + 1, newPosition.getX());
//        Assertions.assertEquals(initPosition.getY(), newPosition.getY());
//    }
//
//    @Test
//    public void whenGrowThanSnakeIncrementSize() {
//        int initSize = snake.getSize();
//        snake.grow();
//        int newSize = snake.getSize();
//        Assertions.assertEquals(initSize + 1, newSize);
//    }
//}