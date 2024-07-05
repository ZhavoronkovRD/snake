package com.game.snake.model.api;

import com.game.snake.model.enums.MoveDirection;

import java.util.Deque;

/**
 * Интерфейс Змейки - поведение (или "контракт") змейки
 */
public interface Snake {
    /**
     * Метод движения змейки
     *
     * @return новое положение головы змейки
     */
    Position move();

    /**
     * Устанавливает новое положение головы змейки.
     * Нужен если игра без стен
     *
     * @param position - новое положение головы змейки
     */
    void setPosition(Position position);

    /**
     * Части из которых состоит змейка.
     *
     * @return двусвязный список сегментов змейки
     */
    Deque<SnakeSegment> getSegments();

    /**
     * Метод меняет направление движения змейки
     *
     * @param moveDirection - новое направление движения
     */
    void changeDirection(MoveDirection moveDirection);

    /**
     * Метод возвращает направление движения змейки
     *
     * @return движения змейки
     */
    MoveDirection getDirection();

    /**
     * Метод осуществляющий рост змейки
     */
    void grow();

}
