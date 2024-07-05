package com.game.snake.model.api;

/**
 * Сегмент из которых состоит змейка.
 */
public interface SnakeSegment {
    /**
     * Возвращает положение сегмента змейки на игровом поле.
     *
     * @return положение сегмента змейки
     */
    Position getPosition();

    /**
     * Устанавливает новое положение сегмента змейки на игровом поле.
     *
     * @param position - новое положение сегмента змейки
     */
    void setPosition(Position position);
}
