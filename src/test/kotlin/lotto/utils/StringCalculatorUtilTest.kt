package lotto.utils

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StringCalculatorUtilTest : DescribeSpec({
    val stringCalculatorUtil = StringCalculatorUtil()

    describe("분리 함수 확인") {
        context("주어진 문자열을 분해합니다.") {
            it(", 하나만 주어질 때") {
                val split = stringCalculatorUtil.splitByDelimiters("1,2,3", listOf(','))
                split shouldBe listOf(1, 2, 3)
            }
            it(", 와 : 가 주어질 때") {
                val split = stringCalculatorUtil.splitByDelimiters("1,2:3", listOf(',', ':'))
                split shouldBe listOf(1, 2, 3)
            }
            it("여러개가 주어질 때") {
                val split = stringCalculatorUtil.splitByDelimiters("1,2:3x3_8", listOf(',', ':', 'x', '_'))
                split shouldBe listOf(1, 2, 3, 3, 8)
            }
        }
    }
})
