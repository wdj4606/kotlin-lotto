import lotto.GeneratorInterface
import lotto.LottoNumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

object FakeGenerator : GeneratorInterface {
    private const val LOTTO_NUMBER_SIZE = 6
    override fun generate(): List<Int> {
        return (40..45).toList()
    }
}

class LottoNumberGeneratorTest {
    @DisplayName(value = "로또 번호 생성기는 1~45 범위의 숫자를 반환한다.")
    @RepeatedTest(100) // 100번 반복하여 테스트
    fun generatorRange() {
        val numbers = LottoNumberGenerator.generate()
        for (number in numbers) {
            assertThat(number in 1..45).isTrue()
        }
    }

    @DisplayName(value = "fake generator는 1~45 범위의 숫자를 반환한다.")
    @Test
    fun generatorRangeFake() {
        val numbers = FakeGenerator.generate()
        for (number in numbers) {
            assertThat(number in 1..45).isTrue()
        }
    }
}