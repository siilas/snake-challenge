package io.github.siilas.snake.validator.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class FruitNotFoundException : RuntimeException("Fruit Not Found")
