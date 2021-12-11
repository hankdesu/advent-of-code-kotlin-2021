fun main() {
    fun part1(input: List<String>): Int {
        var gamma = ""
        var epsilon = ""
        var countZero = 0
        var countOne = 0
        val binaryLength = input[0].length
        for (binaryIndex in 0 until binaryLength) {
            for (binaryNumber in input) {
                val binaryDigit = binaryNumber[binaryIndex].toString().toInt()
                if (binaryDigit == 0) {
                    countZero += 1
                } else if (binaryDigit == 1) {
                    countOne += 1
                }
            }
            if (countZero > countOne) {
                gamma += "0"
                epsilon += "1"
            } else if (countOne > countZero) {
                gamma += "1"
                epsilon += "0"
            }
            countZero = 0
            countOne = 0
        }
        return gamma.toInt(2) * epsilon.toInt(2)
    }

    fun part2(input: List<String>): Int {
        var oxygen = input
        var co2 = input
        var pointer = 0
        var countZero = 0
        var countOne = 0
        while (oxygen.size > 1 ) {
            val tempOxygenList = mutableListOf<String>()
            var mostNum = 0
            for (binaryNumber in oxygen) {
                val digit = binaryNumber[pointer].toString().toInt()
                if (digit == 0) {
                    countZero += 1
                } else if (digit == 1) {
                    countOne += 1
                }
            }
            if (countOne > countZero) {
                mostNum = 1
            } else if (countZero > countOne) {
                mostNum = 0
            } else {
                mostNum = 1
            }
            for (binaryNumber in oxygen) {
                val digit = binaryNumber[pointer].toString().toInt()
                if (digit == mostNum) {
                    tempOxygenList.add(binaryNumber)
                }
            }
            oxygen = tempOxygenList
            pointer += 1
            countZero = 0
            countOne = 0
        }
        pointer = 0
        countZero = 0
        countOne = 0
        while (co2.size > 1) {
            val tempCo2List = mutableListOf<String>()
            var lessNum = 0
            for (binaryNumber in co2) {
                val digit = binaryNumber[pointer].toString().toInt()
                if (digit == 0) {
                    countZero += 1
                } else if (digit == 1) {
                    countOne += 1
                }
            }
            if (countOne < countZero) {
                lessNum = 1
            } else if (countZero < countOne) {
                lessNum = 0
            } else {
                lessNum = 0
            }
            for (binaryNumber in co2) {
                val digit = binaryNumber[pointer].toString().toInt()
                if (digit == lessNum) {
                    tempCo2List.add(binaryNumber)
                }
            }
            co2 = tempCo2List
            pointer += 1
            countZero = 0
            countOne = 0
        }
        return oxygen[0].toInt(2) * co2[0].toInt(2)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
