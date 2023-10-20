package baseball

import camp.nextstep.edu.missionutils.Console

class User {

    fun inputNumber(): MutableList<Int> {
        val inputNumber = Console.readLine()
        val userNumber = mutableListOf<Int>()
        checkInputNumber(inputNumber)
        for (char in inputNumber) {
            val digit = char.toString().toIntOrNull() ?: throw IllegalArgumentException()
            userNumber.add(digit)
        }
        return userNumber
    }

    private fun checkInputNumber(inputNumber: String) {
        if (inputNumber.length != 3)
            throw IllegalArgumentException()
    }
    fun playAgain() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val inputNumber = Console.readLine().toIntOrNull()
        if (inputNumber == 1) {
            val computer = Computer()
            computer.playGame()
        } else if (inputNumber != 2)
            throw IllegalArgumentException()
    }
}