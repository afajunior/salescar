package br.com.curso.consumer

import br.com.curso.model.Venda
import br.com.curso.service.VendaService
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.serde.ObjectMapper

@KafkaListener
class VendaConsumer(
    private val objectMapper: ObjectMapper,
    private val vendaService: VendaService
) {

    @Topic("ms-vendas")
    fun receberVenda(id: String, vendaJSON: String) {
        val venda = objectMapper.readValue(vendaJSON, Venda::class.java)
        vendaService.create(venda)
        println(venda)
    }
}