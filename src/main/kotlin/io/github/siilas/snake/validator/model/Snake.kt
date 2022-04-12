package io.github.siilas.snake.validator.model

data class Snake(
    val x: Int,
    val y: Int,
    val velX: Int,
    val velY: Int
) {

    companion object {

        fun generateWithInitialPosition(x: Int, y: Int): Snake {
            return Snake(x = x, y = y, velX = 1, velY = 0)
        }
    }
}
