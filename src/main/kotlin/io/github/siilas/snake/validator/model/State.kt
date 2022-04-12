package io.github.siilas.snake.validator.model

data class State(
    val gameId: String,
    val width: Int,
    val height: Int,
    val score: Int,
    val fruit: Fruit,
    val snake: Snake
)
