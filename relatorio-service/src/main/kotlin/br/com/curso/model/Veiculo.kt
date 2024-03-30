package br.com.curso.model

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable.Serializable
import io.micronaut.serde.annotation.Serdeable.Deserializable

@Introspected
@Serializable
@Deserializable
@NoArg
data class Veiculo(
        var id: Long,
        var modelo: String,
        var marca: String,
        var placa: String
)