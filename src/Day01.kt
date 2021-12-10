fun main() {
    fun part1(input: List<String>): Int {
        var measurements = 0
        var lastNumber = 0
        for((index, number) in input.withIndex()) {
            if (index != 0) {
                if (number.toInt() > lastNumber) {
                    measurements += 1
                }
            }
            lastNumber = number.toInt()
        }
        return measurements
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
