package io.github.siilas.snake.validator.controller

import io.github.siilas.snake.validator.model.State
import io.github.siilas.snake.validator.service.GameService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class GameController(private val gameService: GameService) {

    @GetMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    fun new(@RequestParam("w") width: Int, @RequestParam("h") height: Int): State {
        return gameService.generateNewGame(width, height)
    }
}
