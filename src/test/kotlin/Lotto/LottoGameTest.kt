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

    @Test
    fun `당첨금 계산이 맞는지 확인`() {

        val matchResults = listOf(3, 4, 5, 6, 0)
        val reward = LottoGame().getReward(matchResults)

        assertEquals(5000 + 50000 + 1500000 + 2000000000, reward)
    }

    @Test
    fun `수익률 계산 테스트`() {

        val rate = LottoGame(5000).calculateRate(10000)

        assertEquals(200.00, rate)
    }
}