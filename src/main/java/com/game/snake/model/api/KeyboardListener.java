package com.game.snake.model.api;

import java.io.IOException;

/**
 * Интерфейс осуществляет обработку нажатия пользователем на кнопки клавиатуры
 */
public interface KeyboardListener {
    int readKey() throws IOException;
}
