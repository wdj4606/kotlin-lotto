package lotto.utils

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoNum
import lotto.domain.LottoWin

class StatisticsUtilTest : DescribeSpec({
    describe("상금을 처리 통계하는 클래스를 테스트합니다.") {
        context("enum 관련 경우") {
            val lotto = Lotto(1, 2, 3, 4, 5, 6)
            it("3개 맞을 경우") {
                StatisticsUtil.Prize.THREE.isMatched(
                    lotto,
                    LottoWin(Lotto(1, 2, 3, 10, 11, 12), LottoNum(13))
                ) shouldBe true
            }
            it("4개 맞을 경우") {
                StatisticsUtil.Prize.FOUR.isMatched(
                    lotto,
                    LottoWin(Lotto(1, 2, 3, 4, 11, 12), LottoNum(13))
                ) shouldBe true
            }
            it("5개 맞을 경우") {
                StatisticsUtil.Prize.FIVE.isMatched(
                    lotto,
                    LottoWin(Lotto(1, 2, 3, 4, 5, 12), LottoNum(13))
                ) shouldBe true
            }
            it("5개와 보너스 맞을 경우") {
                StatisticsUtil.Prize.FIVE_BONUS.isMatched(
                    lotto,
                    LottoWin(Lotto(1, 2, 3, 4, 5, 12), LottoNum(6))
                ) shouldBe true
            }
            it("6개 맞을 경우") {
                StatisticsUtil.Prize.SIX.isMatched(
                    lotto,
                    LottoWin(Lotto(1, 2, 3, 4, 5, 6), LottoNum(13))
                ) shouldBe true
            }
        }
        context("통계 관련 내용") {
            val lottoList = listOf(
                Lotto(1, 2, 3, 4, 5, 6),

                Lotto(1, 2, 3, 4, 5, 45),
                Lotto(1, 2, 3, 4, 5, 45),

                Lotto(1, 2, 3, 4, 5, 44),
                Lotto(1, 2, 3, 4, 5, 44),
                Lotto(1, 2, 3, 4, 5, 44),

                Lotto(1, 2, 3, 4, 43, 44),
                Lotto(1, 2, 3, 4, 43, 44),
                Lotto(1, 2, 3, 4, 43, 44),
                Lotto(1, 2, 3, 4, 43, 44),

                Lotto(1, 2, 3, 42, 43, 44),
                Lotto(1, 2, 3, 42, 43, 44),
                Lotto(1, 2, 3, 42, 43, 44),
                Lotto(1, 2, 3, 42, 43, 44),
                Lotto(1, 2, 3, 42, 43, 44),
            )
            val winLotto = LottoWin(Lotto(1, 2, 3, 4, 5, 6), LottoNum(45))

            it("상금 계산") {
                val winCount = StatisticsUtil.getCountWin(lottoList, winLotto)
                winCount[StatisticsUtil.Prize.THREE] shouldBe 5
                winCount[StatisticsUtil.Prize.FOUR] shouldBe 4
                winCount[StatisticsUtil.Prize.FIVE] shouldBe 3
                winCount[StatisticsUtil.Prize.FIVE_BONUS] shouldBe 2
                winCount[StatisticsUtil.Prize.SIX] shouldBe 1
            }
            it("전체 수익 계산") {
                val winCount = StatisticsUtil.getCountWin(lottoList, winLotto)
                val profit = StatisticsUtil.getTotalProfit(winCount)
                val expected = (
                    5 * StatisticsUtil.Prize.THREE.prize +
                        4 * StatisticsUtil.Prize.FOUR.prize +
                        3 * StatisticsUtil.Prize.FIVE.prize +
                        2 * StatisticsUtil.Prize.FIVE_BONUS.prize +
                        1 * StatisticsUtil.Prize.SIX.prize
                    )
                profit shouldBe expected
            }
        }
    }
})
