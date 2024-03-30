package br.com.curso.dto.output

import io.micronaut.serde.annotation.Serdeable.Serializable
import java.math.BigDecimal

@Serializable
data class Venda(
    val cliente: String,
    val veiculo: Veiculo,
    val valor: BigDecimal,
    val parcelas: List<Parcela>
)