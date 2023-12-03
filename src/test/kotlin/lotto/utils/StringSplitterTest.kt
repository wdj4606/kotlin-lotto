package lotto.utils

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StringSplitterTest : DescribeSpec({
    describe("함수를 테스트합니다.") {
        context("입력을 분해") {
            it(", 만 주어진 경우") {
                val split = StringSplitter.splitByDelimiters("1,2,3", listOf(','))
                split shouldBe listOf(1, 2, 3)
            }
            it(", 와 : 가 주어진 경우") {
                val split = StringSplitter.splitByDelimiters("1,2:3", listOf(',', ':'))
                split shouldBe listOf(1, 2, 3)
            }
            it("임의의 문자 여러개가 주어진 경우") {
                val split = StringSplitter.splitByDelimiters("1,2:3x3_8", listOf(',', ':', 'x', '_'))
                split shouldBe listOf(1, 2, 3, 3, 8)
            }
        }

        context("입력으로 부터 구분자 가져오기") {
            it("; 추가 입력이 있는 경우") {
                val split = StringSplitter.getDelimiters("//;\n1;2;3;4")
                split shouldBe listOf(';')
            }
            it("_ 추가 입력이 있는 경우") {
                val split = StringSplitter.getDelimiters("//_\n1_2_3_4")
                split shouldBe listOf('_')
            }
        }
    }
})
