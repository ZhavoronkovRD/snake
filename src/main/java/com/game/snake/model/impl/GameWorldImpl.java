package com.game.snake.model.impl;

import com.game.snake.model.api.Food;
import com.game.snake.model.api.GameWorld;
import com.game.snake.model.api.Position;
import com.game.snake.model.api.Snake;
import com.game.snake.model.enums.MoveDirection;
import com.game.snake.model.enums.UserAction;

import java.util.Random;

public class GameWorldImpl implements GameWorld {
    private final Snake snake;
    private Food food;

    private final int worldLength;
    private final int worldHeight;
    private final boolean hasWalls;
    private volatile boolean active;
    private final Random random = new Random(System.currentTimeMillis());
    private Thread thread;


    public GameWorldImpl(int worldLength, int worldHeight, boolean hasWalls) {
        this.snake = new SnakeImpl(new PositionImpl(worldLength / 2, worldHeight / 2), 1);
        this.worldLength = worldLength;
        this.worldHeight = worldHeight;
        this.hasWalls = hasWalls;
    }

    @Override
    public void handleUserAction(UserAction action) {
        switch (action) {
            case START: {
                startOrStop();
                break;
            }
            case STOP: {
                active = false;
                thread.interrupt();
                break;
            }
            case MOVE_UP: {
                snake.changeDirection(MoveDirection.UP);
                break;
            }
            case MOVE_DOWN: {
                snake.changeDirection(MoveDirection.DOWN);
                break;
            }
            case MOVE_LEFT: {
                snake.changeDirection(MoveDirection.LEFT);
                break;
            }
            case MOVE_RIGHT: {
                snake.changeDirection(MoveDirection.RIGHT);
                break;
            }
            default:
                break;
        }
    }

    private void startOrStop() {
        active = !active;
        thread = new Thread(() -> {
            while (active) {
//            if (active) {
                if (food == null) {
                    placeFood();
                }
                System.out.println(snake);
                Position move = snake.move();
//                System.out.println(move);
                // intersect with food
                if (move.equals(food.getPosition())) {
                    snake.grow();
                    placeFood();
                }

                // intersect with walls
                int y = move.getY();
                int x = move.getX();
                if (hasWalls) {
                    if (x < 0 || x > worldLength ||
                        y < 0 || y > worldHeight) {
                        active = false;
                        System.out.println("Game over!");
                    }
                } else {
                    if (snake.getDirection().equals(MoveDirection.LEFT) || snake.getDirection().equals(MoveDirection.RIGHT)) {
                        if (x == 0) {
                            snake.setPosition(new PositionImpl(worldLength, y));
                        } else if (x == worldLength) {
                            snake.setPosition(new PositionImpl(0, y));
                        }
                    } else if (snake.getDirection().equals(MoveDirection.UP) || snake.getDirection().equals(MoveDirection.DOWN))
                        if (y == 0) {
                            snake.setPosition(new PositionImpl(x, worldHeight));
                        } else if (y == worldHeight) {
                            snake.setPosition(new PositionImpl(x, 0));
                        }
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
                    System.err.println("Thread interrupted " + e);
                }
            }
        });
        thread.start();
    }

    private void placeFood() {
        if (snake.getSegments().size() == worldLength) {
            System.out.println("You Win!");
            active = false;
            thread.interrupt();
        } else {
            Position foodPosition;
            do {
                int x = random.nextInt(1, worldLength);
                int y = random.nextInt(1, worldHeight);
                y = 5;
                foodPosition = new PositionImpl(x, y);
            } while (checkBadFoodPosition(foodPosition));
            food = new FoodImpl(foodPosition);
            System.out.println(food);
        }
    }

    private boolean checkBadFoodPosition(Position foodPosition) {
        return snake.getSegments().stream().anyMatch(it -> it.getPosition().equals(foodPosition));
    }
}
