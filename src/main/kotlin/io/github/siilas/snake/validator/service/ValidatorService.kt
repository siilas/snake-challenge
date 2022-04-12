package io.github.siilas.snake.validator.service

import io.github.siilas.snake.validator.exception.FruitNotFoundException
import io.github.siilas.snake.validator.exception.GameOverException
import io.github.siilas.snake.validator.model.Fruit
import io.github.siilas.snake.validator.model.Game
import io.github.siilas.snake.validator.model.Snake
import io.github.siilas.snake.validator.model.State
import io.github.siilas.snake.validator.model.Velocity
import org.springframework.stereotype.Service

@Service
class ValidatorService {

    fun validate(game: Game): State {
        var snakeX: Int = game.snake.x
        var snakeY: Int = game.snake.y

        var velX: Int = game.snake.velX
        var velY: Int = game.snake.velY

        game.ticks.forEach { tick ->
            val newVelX = Velocity.getVelocity(tick.velX)
            val newVelY = Velocity.getVelocity(tick.velY)

            if (!newVelX.allowVelocity(velX) || !newVelY.allowVelocity(velY) || Velocity.isMovingDiagonal(newVelX, newVelY)) {
                throw GameOverException()
            }

            snakeX = newVelX.calculate(snakeX)
            snakeY = newVelY.calculate(snakeY)

            if (game.isOutBounds(snakeX, snakeY)) {
                throw GameOverException()
            }

            velX = newVelX.value
            velY = newVelY.value
        }

        if (!game.fruit.isTheFruitFound(snakeX, snakeY)) {
            throw FruitNotFoundException()
        }

        return State(
            gameId = game.gameId,
            width = game.width,
            height = game.height,
            score = game.score.plus(1),
            fruit = Fruit.generateRandomPosition(game.width, game.height, snakeX, snakeY),
            snake = Snake(
                x = snakeX,
                y = snakeY,
                velY = velY,
                velX = velX
            )
        )
    }
}
