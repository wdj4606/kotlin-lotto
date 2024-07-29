import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class DelimiterManagerTest {
    private lateinit var manager: DelimiterManager

    @BeforeEach
    fun setUp() {
        manager = DelimiterManager()
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun customDelimiter(text: String) {
        manager.extractDelimiter(text)
        assertThat(manager.delimiters).isEqualTo(mutableListOf(",", ":", ";"))
    }
}
