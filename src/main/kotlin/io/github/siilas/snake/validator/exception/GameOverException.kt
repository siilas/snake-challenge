package io.github.siilas.snake.validator.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
class GameOverException : RuntimeException("Game Over")