package com.game.snake.model.impl;

import com.game.snake.model.api.UserInputParser;
import com.game.snake.model.enums.MoveDirection;
import com.game.snake.model.enums.UserAction;

public class UserInputParserImpl implements UserInputParser {
    @Override
    public UserAction parse(String input) {
        System.out.println("User input: " + input);
        return UserAction.getAction(input);
    }

    @Override
    public UserAction parse(int input) {
        System.out.println("User input: " + input);
        return UserAction.getAction(input);
    }

}
