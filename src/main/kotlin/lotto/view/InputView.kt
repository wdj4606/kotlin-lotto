package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoNum
import lotto.domain.LottoWin
import lotto.utils.StringCalculatorValidator

class InputView {
    var money: Int = 0
    var manualCount: Int = 0
    fun inputMoney() {
        print("pay for lotto : ")
        money = readln().toInt()
        println()
    }
    fun inputManualCount() {
        print("manual lotto count : ")
        manualCount = readln().toInt()
        println()
    }
    fun inputManual(): List<List<Int>> {
        val manualLottoList = mutableListOf<List<Int>>()
        println("manual lotto : ")
        repeat(manualCount) {
            manualLottoList.add(readln().split(",").map { StringCalculatorValidator.getValue(it) })
        }
        println()
        return manualLottoList
    }
    fun inputWin(): LottoWin {
        print("win lotto : ")
        val lottoNumbers = readln().split(",").map { StringCalculatorValidator.getValue(it) }

        print("bonus lotto : ")
        val lottoBonus = readln().toInt()

        return LottoWin(Lotto(*lottoNumbers.toIntArray()), LottoNum(lottoBonus))
    }

    fun inputBonus(): Int {
        print("bonus lotto : ")
        return readln().toInt()
    }
}
