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

    @Test
    fun `로또 번호 매칭 개수가 6개 이하인지 확인`() {

        val lottos = listOf(Lotto())
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val matchResults = LottoGame().match(lottos, winningNumber)

        matchResults.forEach { matchCount ->
            assertTrue(matchCount in 0..6)
        }
    }
}