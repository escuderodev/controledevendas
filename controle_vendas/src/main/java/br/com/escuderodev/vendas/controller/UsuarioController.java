package br.com.escuderodev.vendas.controller;

import br.com.escuderodev.vendas.models.usuario.DadosAtualizaUsuario;
import br.com.escuderodev.vendas.models.usuario.DadosCadastroUsuario;
import br.com.escuderodev.vendas.models.usuario.Usuario;
import br.com.escuderodev.vendas.models.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("formulario")
    public String loadFormPage(Long id, Model model) {
        if (id != null) {
            var usuario = repository.getReferenceById(id);
            model.addAttribute("usuario", usuario);
        }
        return "usuario/formulario";
    }

    @GetMapping
    public String loadListPage(Model model) {
        List<Usuario> usuarios = repository.findAll();
        var usuario = new Usuario();
        model.addAttribute("listaDeUsuarios", usuarios);
        return "usuario/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraUsuario(DadosCadastroUsuario dados) {
        var usuario = new Usuario(dados);
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        repository.save(usuario);
        return "redirect:/pedido";
    }

    @PutMapping
    @Transactional
    public String atualizaDadosUsuario(DadosAtualizaUsuario dados) {
        var usuario = repository.getReferenceById(dados.idusuario());
        usuario.atualizaDados(dados);
        return "redirect:/pedido";
    }

    @DeleteMapping
    @Transactional
    public String deletaUsuario(Long idusuario) {
        repository.deleteById(idusuario);

        return"redirect:/pedido";
    }
}
