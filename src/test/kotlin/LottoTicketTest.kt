import lotto.LottoNumberGenerator
import lotto.LottoTicket
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTicketTest {
    private lateinit var lottoTicket: LottoTicket

    @BeforeEach
    fun setUp() {
        lottoTicket = LottoTicket();
    }

    @DisplayName(value = "로또 티켓은 6개의 숫자를 List로 가진다.")
    @Test
    fun lottoNumberSize() {
        assertThat(lottoTicket.numbers.size).isEqualTo(6)
    }

    @DisplayName(value = "로또 티켓은 6개의 숫자 모드 1~45 사이의 정수이다.")
    @Test
    fun lottoNumberRange() {
        for (number in lottoTicket.numbers) {
            assertThat(number in 1..45).isTrue()
        }
    }
}