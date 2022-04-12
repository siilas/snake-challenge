package io.github.siilas.snake.validator.model

import kotlin.random.Random

data class Fruit(
    val x: Int,
    val y: Int
) {

    companion object {

        fun generateRandomPosition(maxWidth: Int, maxHeight: Int, snakeX: Int, snakeY: Int): Fruit {
            var x: Int
            var y: Int
            do {
                x = Random.nextInt(0, maxWidth)
                y = Random.nextInt(0, maxHeight)
            } while (x == snakeX && y == snakeY)
            return Fruit(x = x, y = y)
        }
    }

    fun isTheFruitFound(snakeX: Int, snakeY: Int): Boolean {
        return snakeX == x && snakeY == y
    }
}
