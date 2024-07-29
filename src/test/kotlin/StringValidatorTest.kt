import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.provider.ValueSource

class StringValidatorTest {
    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 True를 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    fun emptyOrNull(text: String?) {
        assertThat(StringValidator.isNullOrEmptyOrBlank(text)).isTrue();
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1"])
    fun oneNumber(text: String) {
        assertThat(StringValidator.convertSingleInteger(text)).isSameAs(Integer.parseInt(text));
    }
}