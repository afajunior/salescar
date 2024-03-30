package br.com.curso.dto.output

import io.micronaut.serde.annotation.Serdeable.Serializable
import java.math.BigDecimal

@Serializable
data class Parcela(
    val valor: BigDecimal,
    val dataVencimento: String
)