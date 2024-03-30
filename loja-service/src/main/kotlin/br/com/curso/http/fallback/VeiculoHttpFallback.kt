package br.com.curso.http.fallback

import br.com.curso.dto.output.Veiculo
import br.com.curso.http.VeiculoHttp
import io.lettuce.core.RedisClient
import io.micronaut.retry.annotation.Fallback
import io.micronaut.serde.ObjectMapper
import java.util.concurrent.CompletableFuture

@Fallback
class VeiculoHttpFallback(
    private val redisClient: RedisClient,
    private val objectMapper: ObjectMapper
): VeiculoHttp {
    override fun findById(id: Long): CompletableFuture<Veiculo> {
        val connection = redisClient.connect()
        val syncCommands = connection.sync()
        val veiculoJSON = syncCommands.get(id.toString())
        val veiculo = objectMapper.readValue(veiculoJSON, Veiculo::class.java)

        val asyncVeiculo = CompletableFuture<Veiculo>()
        asyncVeiculo.complete(veiculo)
        return asyncVeiculo
    }
}