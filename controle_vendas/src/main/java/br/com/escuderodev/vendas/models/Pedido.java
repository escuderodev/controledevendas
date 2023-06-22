package br.com.escuderodev.vendas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpedido;
    private String cliente;
    private String trabalho;
    private String orcamento;
    private String calculo;
    private BigDecimal valor;
    private BigDecimal percentual;
    private BigDecimal comissao;
    private LocalDate dataEnvioNF;
    private LocalDate dataVencimentoBoleto;
    private int prazoPagamento;
    private String numeroOP;

    public Pedido(DadosCadastroPedido dados) {
        this.idpedido = dados.idpedido();
        this.cliente = dados.cliente();
        this.trabalho = dados.trabalho();
        this.orcamento = dados.orcamento();
        this.calculo = dados.calculo();
        this.valor = dados.valor();
        this.percentual = dados.percentual();
        this.dataEnvioNF = dados.dataEnvioNF();
//        this.dataVencimentoBoleto = dados.dataVencimentoBoleto();
        this.prazoPagamento = dados.prazoPagamento();
        this.numeroOP = dados.numeroOP();
    }

    public Pedido() {
    }

    public void atualizaDados(DadosAtualizaPedido dados) {
        this.cliente = dados.cliente();
        this.trabalho = dados.trabalho();
        this.orcamento = dados.orcamento();
        this.calculo = dados.calculo();
        this.valor = dados.valor();
        this.percentual = dados.percentual();
        this.dataEnvioNF = dados.dataEnvioNF();
//        this.dataVencimentoBoleto = dados.dataVencimentoBoleto();
        this.prazoPagamento = dados.prazoPagamento();
        this.numeroOP = dados.numeroOP();
    }

}
