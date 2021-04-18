fun main() {
    val numbers = arrayOf(
        arrayOf(6, 10, 2),
        arrayOf(3, 30, 34, 5, 9)
    )

    val i : Int = 0
    solution(numbers[i])
}

fun solution(numbers: Array<Int>): String {
    var answer = "";

    val result = mutableSetOf<String>()

    for (number1 in numbers) {
        for (number2 in numbers) {
            result.add("${number1}${number2}")
        }
    }
    for (i in result) {
        println(i)
    }
    println("${numbers[0]}${numbers[1]}")
    return answer;
}