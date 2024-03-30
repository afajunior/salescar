package br.com.curso.service

import br.com.curso.dto.input.VendaInput
import br.com.curso.dto.output.Parcela
import br.com.curso.dto.output.Venda
import br.com.curso.http.VeiculoHttp
import br.com.curso.producer.VendaProducer
import io.micronaut.serde.ObjectMapper
import jakarta.inject.Singleton
import java.time.LocalDate
import java.util.UUID

@Singleton
class VendaService(
    private val veiculoService: VeiculoService,
    private val vendaProducer: VendaProducer,
    private val objectMapper: ObjectMapper
) {
    fun realizarVenda(vendaInput: VendaInput): Venda {
        val veiculo = veiculoService.getVeiculo(vendaInput.veiculo)
        val valorParcela = vendaInput.valor.divide(vendaInput.quantidadeParcelas.toBigDecimal())

        var parcelas: List<Parcela> = ArrayList()
        var dataVencimento = LocalDate.now().plusMonths(1)

        for(i in 1..vendaInput.quantidadeParcelas) {
            val parcela = Parcela(valorParcela, dataVencimento.toString())
            parcelas = parcelas.plus(parcela)
            dataVencimento = dataVencimento.plusMonths(1)
        }

        val venda = Venda(vendaInput.cliente, veiculo, vendaInput.valor, parcelas)
        println(venda)
        confirmarVenda(venda)
        return venda
    }

    fun confirmarVenda(venda: Venda) {
        val vendaJSON = objectMapper.writeValueAsString(venda)
        vendaProducer.publicarVenda(UUID.randomUUID().toString(), vendaJSON)
    }
}