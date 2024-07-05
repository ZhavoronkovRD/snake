package com.game.snake.model.api;

import com.game.snake.model.enums.UserAction;

/**
 * Парсер, разбирает пользовательский ввод и преобразует к игровому действию
 */
public interface UserInputParser {
    UserAction parse(String input);
    UserAction parse(int input);
}
