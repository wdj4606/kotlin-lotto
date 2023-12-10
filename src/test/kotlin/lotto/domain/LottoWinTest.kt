package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoWinTest : DescribeSpec({
    describe("로또 당첨 번호를 테스트 합니다.") {
        context("정상적인 경우") {
            it("숫자 6개가 주어진다.") {
                val lottoWin = LottoWin(Lotto(1, 2, 3, 4, 5, 6), LottoNum(7))
                lottoWin.lotto shouldBe Lotto(1, 2, 3, 4, 5, 6)
                lottoWin.bonus shouldBe LottoNum(7)
            }
        }
        context("비정상적인 경우") {
            it("숫자가 중복된다.") {
                org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
                    LottoWin(Lotto(1, 2, 3, 4, 5, 6), LottoNum(6))
                }
            }
        }
    }
})
