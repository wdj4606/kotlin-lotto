package Lotto

import Lotto.domain.Lotto
import Lotto.domain.LottoGame
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LottoGameTest {
    @Test
    fun `금액에 맞게 로또를 구매하는지 확인`() {
        val game = LottoGame(5000)
        val lottos = game.buyLotto()

        assertEquals(5, lottos.size)
    }
}