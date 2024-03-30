package br.com.curso.service

import br.com.curso.dto.output.Veiculo
import br.com.curso.http.VeiculoHttp
import io.lettuce.core.RedisClient
import io.micronaut.serde.ObjectMapper
import jakarta.inject.Singleton

@Singleton
class VeiculoService(
    private val veiculoHttp: VeiculoHttp,
    private val redisClient: RedisClient,
    private val objectMapper: ObjectMapper
) {
    fun getVeiculo(veiculo: Long): Veiculo {
        val veiculo = veiculoHttp.findById(veiculo).get()
        gravarCache(veiculo)
        return veiculo
    }

    fun gravarCache(veiculo: Veiculo) {
        val connection = redisClient.connect()
        val syncCommands = connection.sync()
        val veiculoJSON = objectMapper.writeValueAsString(veiculo)
        syncCommands.set(veiculo.id.toString(), veiculoJSON)
        connection.close()
    }
}