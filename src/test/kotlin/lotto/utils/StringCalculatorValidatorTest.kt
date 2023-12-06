package lotto.utils

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StringCalculatorValidatorTest : DescribeSpec({
    describe("계산기의 값 판단 유효성 테스트") {
        context("정상적인 경우") {
            it("숫자가 주어지면") {
                val result = StringCalculatorValidator.getValue("55")
                result shouldBe 55
            }
        }
        context("입력이 잘못된 경우") {
            it("문자가 주어지면") {
                val exception = shouldThrow<RuntimeException> {
                    StringCalculatorValidator.getValue("hello")
                }
                exception.message shouldBe "input is not number"
            }
            it("음수가 주어지면") {
                val exception = shouldThrow<RuntimeException> {
                    StringCalculatorValidator.getValue("-1")
                }
                exception.message shouldBe "input is negative"
            }
        }
    }
})
