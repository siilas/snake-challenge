package io.github.siilas.snake.validator.controller

import io.github.siilas.snake.validator.model.Game
import io.github.siilas.snake.validator.model.State
import io.github.siilas.snake.validator.service.ValidatorService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class ValidatorController(private val validatorService: ValidatorService) {

    @PostMapping("/validate")
    @ResponseStatus(HttpStatus.OK)
    fun validate(@RequestBody game: Game): State {
        return validatorService.validate(game)
    }
}
