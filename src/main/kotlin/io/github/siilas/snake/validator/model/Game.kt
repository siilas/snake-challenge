package io.github.siilas.snake.validator.model

data class Game(
    val gameId: String,
    val width: Int,
    val height: Int,
    val score: Int,
    val fruit: Fruit,
    val snake: Snake,
    val ticks: List<Tick>
) {

    fun isOutBounds(x: Int, y: Int): Boolean {
        return x < 0 || x > width || y < 0 || y > height
    }
}
