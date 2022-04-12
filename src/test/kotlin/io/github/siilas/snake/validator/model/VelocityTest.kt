package io.github.siilas.snake.validator.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class VelocityTest {

    @Test
    fun shouldValidateInvalidVelocity() {
       Assertions.assertThrows(IllegalArgumentException::class.java) { Velocity.getVelocity(10) }
    }

    @Test
    fun shouldValidateAllowedVelocities() {
        val invalidLeftOrUp = Velocity.LEFT_OR_UP.allowVelocity(-1)
        val invalidDownOrRight = Velocity.DOWN_OR_RIGHT.allowVelocity(1)

        Assertions.assertFalse(invalidLeftOrUp)
        Assertions.assertFalse(invalidDownOrRight)
    }

    @Test
    fun shouldValidateDiagonalMove() {
        val isDiagonalMove = Velocity.isMovingDiagonal(Velocity.LEFT_OR_UP, Velocity.DOWN_OR_RIGHT)

        Assertions.assertTrue(isDiagonalMove)
    }
}
