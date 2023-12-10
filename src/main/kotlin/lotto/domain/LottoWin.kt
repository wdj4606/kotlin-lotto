package lotto.domain

class LottoWin(val lotto: Lotto, val bonus: LottoNum) {

    init {
        require(!lotto.contains(bonus)) { "bonus number duplicated" }
    }
}
