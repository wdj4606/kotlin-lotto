package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows

class LottoNumTest : DescribeSpec({
    describe("로또 번호를 테스트 합니다.") {
        context("정상적인 경우") {
            it("숫자 6개가 주어진다.") {
                for (i in LottoNum.LOTTO_MIN_NUMBER..LottoNum.LOTTO_MAX_NUMBER) {
                    val lottoNum = LottoNum(i)
                    lottoNum.num shouldBe i
                }
            }
        }
        context("비정상적인 경우") {
            it("숫자가 1보다 작다") {
                assertThrows<IllegalArgumentException> { LottoNum(0) }
            }
            it("숫자가 45보다 크다") {
                assertThrows<IllegalArgumentException> { LottoNum(46) }
            }
        }
    }
})
