package br.com.curso.controller

import br.com.curso.model.Veiculo
import br.com.curso.service.VeiculoService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*

@Controller("/veiculo")
class VeiculoController(
    private val veiculoService: VeiculoService
) {

    @Post
    fun create(@Body veiculo: Veiculo): HttpResponse<Veiculo> {
        return HttpResponse.created(veiculoService.create(veiculo))
    }

    @Get(value = "{id}")
    fun findById(@PathVariable id: Long): Veiculo {
        return veiculoService.findById(id)
    }
}