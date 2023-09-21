package days

import java.awt.geom.IllegalPathStateException

abstract class Day {
    abstract fun partOne(): Any
    abstract fun partTwo(): Any

    private fun getDay(): Int {
        return this.javaClass.simpleName.substring(3).toIntOrNull()
            ?: throw IllegalPathStateException("Filename has to be in format day{dayNumber}")
    }

    fun readInput(): List<String> {
        val content = this.javaClass.getResource("../day${getDay()}.txt")
            ?: throw IllegalStateException("Missing Resource day${getDay()}.txt")
        return content.readText().split("\n")
    }

    fun printPartOne() = println("\u001B[35mDay ${getDay()} Part 1 Solution: \u001b[32m${partOne()}")
    fun printPartTwo() = println("\u001B[35mDay ${getDay()} Part 2 Solution: \u001b[32m${partTwo()}")
}