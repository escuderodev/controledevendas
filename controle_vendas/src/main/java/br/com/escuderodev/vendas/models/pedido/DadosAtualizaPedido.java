package br.com.escuderodev.vendas.models.pedido;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosAtualizaPedido(
        Long idpedido,
        String cliente,
        String trabalho,
        String orcamento,
        String calculo,
        BigDecimal valor,
        BigDecimal percentual,
        BigDecimal comissao,
        LocalDate dataEnvioNF,
        int prazoPagamento,
        String numeroOP) {
}
