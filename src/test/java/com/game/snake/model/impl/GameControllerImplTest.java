package com.game.snake.model.impl;

import com.game.snake.model.api.GameController;
import com.game.snake.model.api.GameWorld;
import com.game.snake.model.api.KeyboardListener;
import com.game.snake.model.api.UserInputParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class GameControllerImplTest {

    @Mock
    GameWorld gameWorld;
    @Mock
    KeyboardListener keyboardListener;
    @Mock
    UserInputParser inputParser;
    @InjectMocks
    GameController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenDoControlThenCallAllResources() {
        controller.doControl();
        Mockito.verify(keyboardListener, Mockito.atLeastOnce()).readKey();
        Mockito.verify(inputParser, Mockito.atLeastOnce()).parse(Mockito.anyString());
        Mockito.verify(gameWorld, Mockito.atLeastOnce()).handleUserAction(Mockito.any());
    }
}