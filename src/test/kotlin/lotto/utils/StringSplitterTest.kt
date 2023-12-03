package lotto.utils

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StringSplitterTest : FunSpec({
    test(", 만 주어진 경우") {
        val split = StringSplitter.splitByDelimiters("1,2,3", listOf(','))
        split shouldBe listOf(1, 2, 3)
    }
    test(", 와 : 가 주어진 경우") {
        val split = StringSplitter.splitByDelimiters("1,2:3", listOf(',', ':'))
        split shouldBe listOf(1, 2, 3)
    }
    test("임의의 문자 여러개가 주어진 경우") {
        val split = StringSplitter.splitByDelimiters("1,2:3x3_8", listOf(',', ':', 'x', '_'))
        split shouldBe listOf(1, 2, 3, 3, 8)
    }
})
