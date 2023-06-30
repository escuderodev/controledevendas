package br.com.escuderodev.vendas.models.cliente;

import java.time.LocalDate;

public record DadosCadastroCliente(
        Long idcliente,
        String empresa,
        String contato,
        String telefone,
        String email,
        LocalDate dataContato,
        String resumo) {
}
