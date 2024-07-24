package lotto

class LottoTicket(private val generatorParam: GeneratorInterface = LottoNumberGenerator, val numbers: List<Int> = List(6) {generatorParam.generate()}.sorted())