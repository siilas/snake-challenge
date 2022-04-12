package io.github.siilas.snake.validator.service

import io.github.siilas.snake.validator.model.Fruit
import io.github.siilas.snake.validator.model.Snake
import io.github.siilas.snake.validator.model.State
import java.util.UUID
import org.springframework.stereotype.Service

@Service
class GameService {

    companion object {
        const val SNAKE_INITIAL_X = 0
        const val SNAKE_INITIAL_Y = 0
    }

    fun generateNewGame(width: Int, height: Int): State {
        return State(
            gameId = UUID.randomUUID().toString(),
            width = width,
            height = height,
            score = 0,
            fruit = Fruit.generateRandomPosition(width, height, SNAKE_INITIAL_X, SNAKE_INITIAL_Y),
            snake = Snake.generateWithInitialPosition(SNAKE_INITIAL_X, SNAKE_INITIAL_Y)
        )
    }
}
