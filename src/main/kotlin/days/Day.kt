package days

import java.awt.geom.IllegalPathStateException

abstract class Day (val useExampleInput: Boolean = false) {
    abstract fun partOne(): Any
    abstract fun partTwo(): Any

    private fun getDay(): Int {
        return this.javaClass.simpleName.substring(3).toIntOrNull()
            ?: throw IllegalPathStateException("Filename has to be in format day{dayNumber}")
    }

    fun readInput(): List<String> {
        val fileName = if (useExampleInput) {
            "./example.txt"
        } else {
            "./input.txt"
        }

        val content = this.javaClass.getResource(fileName)
            ?: throw IllegalStateException("Missing Resource days/day${getDay()}/input.txt")
        return content.readText().split("\n")
    }
    fun solvePartOne() {
        println("------Solving Day ${getDay()} Part 1------")
        val solution = partOne()
        println("------Finished Solving Day ${getDay()} Part 1------")

        println("\u001B[35mDay ${getDay()} Part 1 Solution: \u001b[32m${solution}\u001B[0m")
    }
    fun solvePartTwo() {
        println("------Solving Day ${getDay()} Part 2------")
        val solution = partTwo()
        println("------Finished Solving Day ${getDay()} Part 2------")

        println("\u001B[35mDay ${getDay()} Part 2 Solution: \u001b[32m${solution}\u001B[0m")
    }
}