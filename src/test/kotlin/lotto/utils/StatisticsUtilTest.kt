package lotto.utils

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import org.junit.jupiter.api.assertThrows
import java.lang.RuntimeException

class StatisticsUtilTest : DescribeSpec({
    describe("상금을 처리하는 클래스를 테스트합니다.") {
        context("정상 경우") {
            it("등수 제대로 구하는지 확인") {
                val lottoList = listOf(
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    Lotto(listOf(1, 2, 3, 4, 5, 7)),
                    Lotto(listOf(1, 2, 3, 4, 5, 7)),
                    Lotto(listOf(1, 2, 3, 4, 7, 8)),
                    Lotto(listOf(1, 2, 3, 4, 7, 8)),
                    Lotto(listOf(1, 2, 3, 4, 7, 8)),
                    Lotto(listOf(1, 2, 3, 7, 8, 9)),
                    Lotto(listOf(1, 2, 3, 7, 8, 9)),
                    Lotto(listOf(1, 2, 3, 7, 8, 9)),
                    Lotto(listOf(1, 2, 3, 7, 8, 9)),
                    Lotto(listOf(1, 2, 7, 8, 9, 10)),
                    Lotto(listOf(1, 7, 8, 9, 10, 11))
                )
                val winLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
                for (lotto in lottoList) {
                    lotto.matchWin(winLotto)
                }
                StatisticsUtil.getCountWin(lottoList, 3) shouldBe 4
                StatisticsUtil.getCountWin(lottoList, 4) shouldBe 3
                StatisticsUtil.getCountWin(lottoList, 5) shouldBe 2
                StatisticsUtil.getCountWin(lottoList, 6) shouldBe 1
            }
            it("상금 제대로 가져오는가") {
                StatisticsUtil.getPrize(3) shouldBe 5000
                StatisticsUtil.getPrize(4) shouldBe 50000
                StatisticsUtil.getPrize(5) shouldBe 1500000
                StatisticsUtil.getPrize(6) shouldBe 2000000000
            }
        }
        context("실패하는 경우") {
            it("상금이 없는 갯수") {
                assertThrows<RuntimeException> { StatisticsUtil.getPrize(2) }
            }
        }
    }
})
