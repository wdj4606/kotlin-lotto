import lotto.*
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.math.RoundingMode

class LottoEventMachineTest {
    @DisplayName(value = "로또 추첨기는 로또 티켓 리스트를 일치한 숫자 갯수 별로 당첨 수량을 확인할 수 있다.")
    @Test
    fun getLottoResult() {
        val fakeGenerator = FakeReverseGenerator()
        val tickets = listOf(LottoTicket(fakeGenerator), LottoTicket(fakeGenerator))

        val results1 = LottoEventMachine.result(listOf(40,41,42,43,44,45), tickets)
        val results2 = LottoEventMachine.result(listOf(37,38,39,40,41,42), tickets)

        Assertions.assertThat(results1.count { it.rank == 1}).isEqualTo(1)
        Assertions.assertThat(results2.count { it.rank == 4}).isEqualTo(2)
    }

    @DisplayName(value = "로또 추첨기는 받은 로또 티켓 리스트를 통해 수익률을 계산할 수 있다.")
    @Test
    fun ratioOfReturn() {
        val fakeGenerator = FakeReverseGenerator()
        val tickets = listOf(LottoTicket(fakeGenerator), LottoTicket(fakeGenerator))

        val results = LottoEventMachine.result(listOf(40,41,42,43,44,45), tickets)

        val totalReward = BigDecimal(Rank.First.reward)
        val totalPrice = BigDecimal(LottoVendingMachine.PRICE).multiply(BigDecimal(results.size))
        val ratio = totalReward.divide(totalPrice, 2, RoundingMode.HALF_UP)

        Assertions.assertThat(LottoEventMachine.ratioOfReturn(results))
            .isEqualTo(ratio)
    }
}