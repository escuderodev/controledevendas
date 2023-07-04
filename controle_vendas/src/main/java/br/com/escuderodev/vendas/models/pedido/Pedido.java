package br.com.escuderodev.vendas.models.pedido;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
    private BigDecimal totalPedido;
    private BigDecimal totalComissao;

    public Pedido(DadosCadastroPedido dados) {
        this.idpedido = dados.idpedido();
        this.cliente = dados.cliente();
        this.trabalho = dados.trabalho();
        this.orcamento = dados.orcamento();
        this.calculo = dados.calculo();
        this.valor = dados.valor();
        this.percentual = dados.percentual();
        this.dataEnvioNF = dados.dataEnvioNF();
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
        this.prazoPagamento = dados.prazoPagamento();
        this.numeroOP = dados.numeroOP();
    }

     public BigDecimal calculaTotalPedidos(List<Pedido> pedidos) {
         BigDecimal totalPedidos = new BigDecimal(0);
         for (int i = 0; i < pedidos.size(); i ++) {
             totalPedidos = totalPedidos.add(pedidos.get(i).getValor());
         }
         return totalPedidos;
     }

     public BigDecimal calculaTotalComissao(List<Pedido> pedidos) {
         BigDecimal totalComissao = new BigDecimal(0);
         for (int i = 0; i < pedidos.size(); i ++) {
             totalComissao = totalComissao.add(pedidos.get(i).getComissao());
         }
         return totalComissao;
     }
}
