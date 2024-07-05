package com.game.snake;

import com.game.snake.model.api.GameController;
import com.game.snake.model.impl.GameControllerImpl;

/**
 * Входная точка приложения
 */
public class SnakeGameApplication {

    private static GameController gameController;

    public static void main(String[] args) {
        gameController = new GameControllerImpl();
        gameController.doControl();
    }
}