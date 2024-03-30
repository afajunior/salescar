package br.com.curso.model

import io.micronaut.serde.annotation.Serdeable.Serializable
import io.micronaut.serde.annotation.Serdeable.Deserializable
import java.math.BigDecimal

@Serializable
@Deserializable
@NoArg
data class Venda(
    var cliente: String,
    var veiculo: Veiculo,
    var valor: BigDecimal,
    var parcelas: List<Parcela>
)