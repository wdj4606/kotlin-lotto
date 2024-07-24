import lotto.LottoVendingMachine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoVendingMachineTest {
    @DisplayName(value = "로또 자판기는 지급된 금액을 1000으로 나눈 몫만큼 로또 티켓을 발급한다.")
    @ParameterizedTest
    @ValueSource(ints = [14000, 5500])
    fun colons(money: Int) {
        assertThat(LottoVendingMachine.purchase(money).size).isEqualTo(money/LottoVendingMachine.PRICE)
    }
}