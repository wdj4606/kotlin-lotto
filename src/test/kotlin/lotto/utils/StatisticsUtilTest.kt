package lotto.utils

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto

class StatisticsUtilTest : DescribeSpec({
    describe("상금을 처리 통계하는 클래스를 테스트합니다.") {
        context("enum 관련 경우") {
            it("enum 관련 확인") {
                StatisticsUtil.Prize.THREE.count shouldBe 3
                StatisticsUtil.Prize.FOUR.count shouldBe 4
                StatisticsUtil.Prize.FIVE.count shouldBe 5
                StatisticsUtil.Prize.SIX.count shouldBe 6
            }
        }
        context("통계 관련 내용") {
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
            it("상금 계산") {
                val winCount = StatisticsUtil.getCountWin(lottoList)
                winCount[StatisticsUtil.Prize.THREE] shouldBe 4
                winCount[StatisticsUtil.Prize.FOUR] shouldBe 3
                winCount[StatisticsUtil.Prize.FIVE] shouldBe 2
                winCount[StatisticsUtil.Prize.SIX] shouldBe 1
            }
            it("전체 수익 계산") {
                val winCount = StatisticsUtil.getCountWin(lottoList)
                val profit = StatisticsUtil.getTotalProfit(winCount)
                profit shouldBe 2003170000
            }
        }
    }
})
