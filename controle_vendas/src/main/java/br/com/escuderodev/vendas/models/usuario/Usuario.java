package br.com.escuderodev.vendas.models.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;
    private String login;
    private String senha;

    public Usuario(DadosCadastroUsuario dados) {
        this.idusuario = dados.idusuario();
        this.login = dados.login();
        this.senha = dados.senha();
    }

    public Usuario() {
    }

    public void atualizaDados(DadosAtualizaUsuario dados) {
        this.login = dados.login();
        this.senha = dados.senha();
    }
}
