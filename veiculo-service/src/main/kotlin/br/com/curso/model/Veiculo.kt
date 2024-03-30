package br.com.curso.model

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "veiculo")
@Serdeable.Deserializable
@Serdeable.Serializable
data class Veiculo(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val modelo: String,
    val marca: String,
    val placa: String
)