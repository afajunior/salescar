package br.com.curso.model

import io.micronaut.serde.annotation.Serdeable.Serializable
import io.micronaut.serde.annotation.Serdeable.Deserializable
import java.math.BigDecimal

@Serializable
@Deserializable
@NoArg
data class Parcela(
    var valor: BigDecimal,
    var dataVencimento: String
)