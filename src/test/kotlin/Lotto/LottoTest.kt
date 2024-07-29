package Lotto

import Lotto.domain.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Test
    fun `모든 번호가 1 ~ 45 사이인지 확인`() {
        val lotto = Lotto()
        val numbers = lotto.number

        assertTrue(numbers.all { it in 1..45 })
    }

    @Test
    fun `번호가 1 ~ 45 사이가 아닐 때 예외 발생 확인`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }

        assertEquals("로또 번호는 1부터 45 사이의 숫자여야 합니다.", exception.message)
    }

    @Test
    fun `번호가 6개인지 확인`() {
        val lotto = Lotto()
        val numbers = lotto.number

        assertEquals(6, numbers.size)
    }

    @Test
    fun `번호가 6개가 아닐 때 예외 발생 확인`() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }

        assertEquals("로또 번호는 6개여야 합니다.", exception.message)
    }

    @Test
    fun `번호 6개가 전부 고유한지 확인`() {
        val lotto = Lotto()
        val numbers = lotto.number

        assertEquals(6, numbers.toSet().size)
    }

    @Test
    fun `번호가 정렬되어있는지 확인`() {
        val lotto = Lotto()
        val numbers = lotto.number

        assertEquals(numbers, numbers.sorted())
    }

    @Test
    fun `match 함수의 인자와 정상적으로 비교되는지 확인`() {
        val lotto = Lotto()
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val generatedNumber = lotto.number

        val matchCount = lotto.match(winningNumber)
        assertEquals(generatedNumber.intersect(winningNumber.toSet()).count(), matchCount)
    }
}