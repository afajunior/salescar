package br.com.curso.dto.output

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import io.micronaut.serde.annotation.Serdeable.Deserializable

@Introspected
@Deserializable
@Serdeable.Serializable
data class Veiculo(
        val id: Long,
        val modelo: String,
        val marca: String,
        val placa: String
)