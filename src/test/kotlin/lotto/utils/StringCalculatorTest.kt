package lotto.utils

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : DescribeSpec({
    val stringCalculator = StringCalculator()

    describe("주어진 문자들의 합을 구한다.") {
        context("기본 규칙을 사용합니다.") {
            it(", 기준으로 숫자가 주어질 때") {
                val split = stringCalculator.calc("1,2,3,4")
                split shouldBe 10
            }
            it(",와 : 을 기준으로 숫자가 주어질 때") {
                val split = stringCalculator.calc("1,2:3")
                split shouldBe 6
            }
        }
        context("합계가 0일때") {
            it("값이 존재하지 않음") {
                val split = stringCalculator.calc("")
                split shouldBe 0
            }
            it("값이 모두 0") {
                val split = stringCalculator.calc("0,0:0")
                split shouldBe 0
            }
        }
        context("커스텀 구분자가 주어질 떄") {
            it("_ 문자로 커스텀 구분") {
                val split = stringCalculator.calc("//_\n1_2_3")
                split shouldBe 6
            }
        }
    }
})
