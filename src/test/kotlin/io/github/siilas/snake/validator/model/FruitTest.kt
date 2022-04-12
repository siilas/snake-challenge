package io.github.siilas.snake.validator.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FruitTest {

    @Test
    fun shouldGenerateFruitPosition() {
        val fruit = Fruit.generateRandomPosition(10, 10, 0, 1)

        Assertions.assertNotEquals(0, fruit.x)
        Assertions.assertNotEquals(1, fruit.y)
    }

    @Test
    fun shouldFindTheFruit() {
        val fruit = Fruit(0, 1)

        Assertions.assertTrue(fruit.isTheFruitFound(0, 1))
    }
}
