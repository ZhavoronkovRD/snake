package com.game.snake.model.impl;

import com.game.snake.model.api.KeyboardListener;

import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class KeyboardListenerImpl implements KeyboardListener {
    Scanner scanner = new Scanner(System.in);
    Reader reader = System.console().reader();

    @Override
    public int readKey() throws IOException {
        return reader.ready() ? reader.read() : -1;
//        return scanner.hasNext() ? scanner.next() : null;
    }
}
