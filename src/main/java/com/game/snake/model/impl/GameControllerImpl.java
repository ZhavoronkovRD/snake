package com.game.snake.model.impl;

import com.game.snake.model.api.GameController;
import com.game.snake.model.api.GameWorld;
import com.game.snake.model.api.KeyboardListener;
import com.game.snake.model.api.UserInputParser;
import com.game.snake.model.enums.UserAction;

import java.io.IOException;

public class GameControllerImpl implements GameController {
    private final GameWorld gameWorld;
    private final KeyboardListener keyboardListener;
    private final UserInputParser userInputParser;

    public GameControllerImpl() {
        userInputParser = new UserInputParserImpl();
        keyboardListener = new KeyboardListenerImpl();
        gameWorld = new GameWorldImpl(10, 10, false);
    }

    @Override
    public void doControl() {
        while (true) {
            try {
                int key = keyboardListener.readKey();
                UserAction action = userInputParser.parse(key);
                System.out.println("User action: " + action);
                if (action != null) {
                    gameWorld.handleUserAction(action);
                }
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
