package com.game.snake.model.enums;

import java.util.Arrays;

/**
 * Команды пользователя
 */
public enum UserAction {
    START("p", 112),
    STOP("b", 98),
    MOVE_UP("w", 119),
    MOVE_DOWN("s", 115),
    MOVE_LEFT("a", 97),
    MOVE_RIGHT("d", 100);

    private final String key;
    private final int intKey;

    UserAction(String key, int intKey) {
        this.key = key;
        this.intKey = intKey;
    }

    public static UserAction getAction(String key) {
        return Arrays.stream(UserAction.values())
            .filter(it -> it.key.equals(key))
            .findFirst()
            .orElse(null);
    }

    public static UserAction getAction(int key) {
        return Arrays.stream(UserAction.values())
            .filter(it -> it.intKey == key)
            .findFirst()
            .orElse(null);
    }
}
