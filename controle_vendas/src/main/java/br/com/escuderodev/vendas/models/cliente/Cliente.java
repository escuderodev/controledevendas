package br.com.escuderodev.vendas.models.cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@ToString
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcliente;
    private String empresa;
    private String contato;
    private String telefone;
    private String email;
    private LocalDate dataContato;
    private String resumo;

    public Cliente(DadosCadastroCliente dados) {
        this.idcliente = dados.idcliente();
        this.empresa = dados.empresa();
        this.contato = dados.contato();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.dataContato = dados.dataContato();
        this.resumo = dados.resumo();
    }
    public Cliente() {
    }

    public void atualizaDados(DadosAtualizaCliente dados) {
        this.empresa = empresa;
        this.contato = contato;
        this.telefone = telefone;
        this.email = email;
        this.dataContato = dataContato;
        this.resumo = resumo;
    }

}
