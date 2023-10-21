package baseball

import camp.nextstep.edu.missionutils.Console

class User {

    fun inputNumber(): MutableList<Int> {
        val inputNumber = Console.readLine()
        val userNumber = mutableListOf<Int>()
        checkBlank(inputNumber)
        checkInputThree(inputNumber)
        for (char in inputNumber) {
            val num = char.toString().toIntOrNull()
            userNumber.add(checkDuplicate(userNumber,checkIsNumber(num)))
        }
        return userNumber
    }

    private fun checkInputThree(inputNumber: String) {
        if (inputNumber.length != 3)
            throw IllegalArgumentException()
    }
    private fun checkBlank(inputNumber: String?) {
        if (inputNumber!!.isBlank())
            throw IllegalArgumentException()
    }

    private fun checkIsNumber(inputNumber: Int?) : Int {
        if (inputNumber==null)
            throw IllegalArgumentException()
        return inputNumber
    }

    private fun checkDuplicate(userNumber:MutableList<Int>,inputNumber: Int):Int{
        if (userNumber.contains(inputNumber))
            throw IllegalArgumentException()
        return inputNumber
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