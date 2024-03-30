package br.com.curso.dto.input

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import java.math.BigDecimal

@Introspected
@Serdeable.Serializable
@Serdeable.Deserializable
data class VendaInput(
        val cliente: String,
        val veiculo: Long,
        val valor: BigDecimal,
        val quantidadeParcelas: Int
)