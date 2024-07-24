import lotto.LottoNumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest

class LottoNumberGeneratorTest {
    @DisplayName(value = "로또 번호 생성기는 1~45 범위의 숫자를 반환한다.")
    @RepeatedTest(100) // 100번 반복하여 테스트
    fun generatorRange() {
        assertThat(LottoNumberGenerator.generate() in 1..45).isTrue()
    }
}