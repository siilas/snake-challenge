package io.github.siilas.snake.validator.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GameTest {

    @Test
    fun shouldValidateOutOfBounds() {
        val game = Game("", 10, 10, 0, Fruit(0, 0), Snake(0, 0, 0, 0), emptyList())

        val outX = game.isOutBounds(15, 0)
        val outY = game.isOutBounds(0, 11)

        Assertions.assertTrue(outX)
        Assertions.assertTrue(outY)
    }
}
