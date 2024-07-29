package Lotto

import Lotto.domain.Lotto
import Lotto.domain.LottoGame.buyLotto
import Lotto.domain.LottoGame.calculateRate
import Lotto.domain.LottoGame.getReward
import Lotto.domain.LottoGame.match
import Lotto.domain.LottoGame.setMoney
import Lotto.domain.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LottoGameTest {
    @Test
    fun `금액에 맞게 로또를 구매하는지 확인`() {
        setMoney(5000)
        val lottos = buyLotto()

        assertEquals(5, lottos.size)
    }

    @Test
    fun `로또 번호 매칭 개수가 0개인지 확인`() {
        val lottos = listOf(Lotto(listOf(7, 8, 9, 10, 11, 12)))
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val matchResults = match(lottos, winningNumber)
        assertEquals(Rank.NO_REWARD, matchResults[0])
    }

    @Test
    fun `로또 번호 매칭 개수가 3개인지 확인`() {
        val lottos = listOf(Lotto(listOf(1, 2, 3, 10, 11, 12)))
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val matchResults = match(lottos, winningNumber)
        assertEquals(Rank.THREE_MATCH, matchResults[0])
    }

    @Test
    fun `로또 번호 매칭 개수가 4개인지 확인`() {
        val lottos = listOf(Lotto(listOf(1, 2, 3, 4, 11, 12)))
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val matchResults = match(lottos, winningNumber)
        assertEquals(Rank.FOUR_MATCH, matchResults[0])
    }

    @Test
    fun `로또 번호 매칭 개수가 5개인지 확인`() {
        val lottos = listOf(Lotto(listOf(1, 2, 3, 4, 5, 12)))
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val matchResults = match(lottos, winningNumber)
        assertEquals(Rank.FIVE_MATCH, matchResults[0])
    }

    @Test
    fun `로또 번호 매칭 개수가 6개인지 확인`() {
        val lottos = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val matchResults = match(lottos, winningNumber)
        assertEquals(Rank.SIX_MATCH, matchResults[0])
    }

    @Test
    fun `로또 번호 매칭 개수가 0에서 6개 사이인지 확인`() {
        val lottos = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val matchResults = match(lottos, winningNumber)
        matchResults.forEach { rank ->
            assertTrue(rank.count in 0..6)
        }
    }

    @Test
    fun `당첨금 계산이 맞는지 확인`() {
        val matchResults = listOf(Rank.THREE_MATCH, Rank.FOUR_MATCH, Rank.FIVE_MATCH, Rank.SIX_MATCH, Rank.NO_REWARD)
        val reward = getReward(matchResults)

        assertEquals(5000 + 50000 + 1500000 + 2000000000, reward)
    }

    @Test
    fun `수익률 계산 테스트`() {
        setMoney(5000)
        val rate = calculateRate(10000)

        assertEquals(200.00, rate)
    }
}