#bin/sh

# Input files
mkdir ./src/main/resources/days/day"$1"
touch ./src/main/resources/days/day"$1"/input.txt
touch ./src/main/resources/days/day"$1"/example_input.txt

# Code files
mkdir ./src/main/kotlin/days/day"$1"

file="./src/main/kotlin/days/day$1/Day$1.kt"
sampleContent="package days.day$1

import days.Day

class Day$1: Day(true) {
    override fun partOne(): Any {
        return \"day $1 part 1 not Implemented\"
    }

    override fun partTwo(): Any {
        return \"day $1 part 2 not Implemented\"
    }
}
"


if [ ! -e "$file" ]; then
    touch "$file"
    echo "$sampleContent" > "$file"
    echo "File created and content written."
else
    echo "File already exists."
fi

echo "import days.day$1.Day$1

fun main() {
    val currentDay = Day$1()

    currentDay.solvePartOne()
    currentDay.solvePartTwo()
}" > ./src/main/kotlin/Main.kt

