fun main() {
    fun part1(input: List<String>): Int {
        var horizontal = 0;
        var depth = 0;
        for(command in input) {
          var (direct, value) = command.split(" ")
            var intValue = value.toInt()
            if(direct == "forward") {
                horizontal += intValue
            } else if (direct == "up") {
                depth -= intValue
            } else if (direct == "down") {
                depth += intValue
            }
        }
        return horizontal * depth
    }

    fun part2(input: List<String>): Int {
        var horizontal = 0;
        var depth = 0;
        var target = 0;
        for(command in input) {
            var (direct, value) = command.split(" ")
            var intValue = value.toInt()
            if(direct == "forward") {
                depth += target * intValue
                horizontal += intValue
            } else if (direct == "up") {
                target -= intValue
            } else if (direct == "down") {
                target += intValue
            }
        }
        return horizontal * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
