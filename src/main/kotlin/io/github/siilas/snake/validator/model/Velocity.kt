package io.github.siilas.snake.validator.model

enum class Velocity(val value: Int) {

    LEFT_OR_UP(1) {

        override fun allowVelocity(oldVelocity: Int): Boolean {
            return oldVelocity == 0 || oldVelocity == 1
        }

        override fun calculate(value: Int): Int {
            return value.plus(1)
        }
    },

    NO_MOVEMENT(0) {

        override fun allowVelocity(oldVelocity: Int): Boolean {
            return true
        }

        override fun calculate(value: Int): Int {
            return value
        }
    },

    DOWN_OR_RIGHT(-1) {

        override fun allowVelocity(oldVelocity: Int): Boolean {
            return oldVelocity == 0 || oldVelocity == -1
        }

        override fun calculate(value: Int): Int {
            return value.minus(1)
        }
    };

    companion object {

        fun getVelocity(value: Int): Velocity {
            values().forEach {
                if (it.value == value) return it
            }
            throw IllegalArgumentException("Invalid Velocity")
        }

        fun isMovingDiagonal(velX: Velocity, velY: Velocity): Boolean {
            return (LEFT_OR_UP == velX && NO_MOVEMENT != velY) || (NO_MOVEMENT != velX && DOWN_OR_RIGHT == velY)
        }
    }

    abstract fun allowVelocity(newVelocity: Int): Boolean

    abstract fun calculate(value: Int): Int
}
