package com.game.snake.model.api;

import com.game.snake.model.enums.UserAction;

/**
 * Игровой мир, осуществляет управление игровыми объектами
 */
public interface GameWorld {
    /**
     * Метод передает команду пользователя и преобразует ее в игровое действие
     * @param action
     */
    void handleUserAction(UserAction action);
}
