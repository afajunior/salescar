package br.com.curso.http

import br.com.curso.dto.output.Veiculo
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.client.annotation.Client
import io.micronaut.retry.annotation.CircuitBreaker
import io.micronaut.retry.annotation.Recoverable
import java.util.concurrent.CompletableFuture

@Client("http://localhost:8080")
@Recoverable
@CircuitBreaker
interface VeiculoHttp {

    @Get("/veiculo/{id}")
    fun findById(@PathVariable id: Long): CompletableFuture<Veiculo>
}