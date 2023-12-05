package lotto.utils

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto

class StatisticsUtilTest : DescribeSpec({
    describe("상금을 처리하는 클래스를 테스트합니다.") {
        context("정상 경우") {
            it("등수 제대로 구하는지 확인") {
                val lottoList = listOf(
                    Lotto(setOf(1, 2, 3, 4, 5, 6)),
                    Lotto(setOf(1, 2, 3, 4, 5, 7)),
                    Lotto(setOf(1, 2, 3, 4, 5, 7)),
                    Lotto(setOf(1, 2, 3, 4, 7, 8)),
                    Lotto(setOf(1, 2, 3, 4, 7, 8)),
                    Lotto(setOf(1, 2, 3, 4, 7, 8)),
                    Lotto(setOf(1, 2, 3, 7, 8, 9)),
                    Lotto(setOf(1, 2, 3, 7, 8, 9)),
                    Lotto(setOf(1, 2, 3, 7, 8, 9)),
                    Lotto(setOf(1, 2, 3, 7, 8, 9)),
                    Lotto(setOf(1, 2, 7, 8, 9, 10)),
                    Lotto(setOf(1, 7, 8, 9, 10, 11))
                )
                val winLotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
                for (lotto in lottoList) {
                    lotto.matchWin(winLotto)
                }
                StatisticsUtil.getCountWin(lottoList, StatisticsUtil.Companion.Prize.THREE) shouldBe 4
                StatisticsUtil.getCountWin(lottoList, StatisticsUtil.Companion.Prize.FOUR) shouldBe 3
                StatisticsUtil.getCountWin(lottoList, StatisticsUtil.Companion.Prize.FIVE) shouldBe 2
                StatisticsUtil.getCountWin(lottoList, StatisticsUtil.Companion.Prize.SIX) shouldBe 1
            }
        }
    }
})
