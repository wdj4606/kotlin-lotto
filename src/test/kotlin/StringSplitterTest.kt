import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach

class StringSplitterTest {
    private lateinit var parser: StringSplitter

    @BeforeEach
    fun setUp() {
        parser = StringSplitter();
    }

    @DisplayName(value = "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,2"])
    fun twoNumbers(text: String) {
        assertThat(parser.splitByDelimiter(text)).isEqualTo(listOf("1", "2"))
    }

    @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun colons(text: String) {
        assertThat(parser.splitByDelimiter(text)).isEqualTo(listOf("1", "2", "3"))
    }
}