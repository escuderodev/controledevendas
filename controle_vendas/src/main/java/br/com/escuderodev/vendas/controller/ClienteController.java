package br.com.escuderodev.vendas.controller;

import br.com.escuderodev.vendas.models.cliente.Cliente;
import br.com.escuderodev.vendas.models.cliente.ClienteRepository;
import br.com.escuderodev.vendas.models.cliente.DadosAtualizaCliente;
import br.com.escuderodev.vendas.models.cliente.DadosCadastroCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping("formulario")
    public String loadFormPage(Long id, Model model) {
        if (id != null) {
            var cliente = repository.getReferenceById(id);
            model.addAttribute("cliente", cliente);
        }
        return "cliente/formulario";
    }

    @GetMapping
    public String loadListPage(Model model) {
        model.addAttribute("listaDeClientes", repository.findAll());
        return "cliente/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraCliente(DadosCadastroCliente dados) {
        var cliente = new Cliente(dados);
        repository.save(cliente);
        return "redirect:/cliente";
    }

    @PutMapping
    @Transactional
    public String atualizaDadosCliente(DadosAtualizaCliente dados) {
        var cliente = repository.getReferenceById(dados.idcliente());
        cliente.atualizaDados(dados);
        return "redirect:/cliente";
    }

    @DeleteMapping
    @Transactional
    public String deletaCliente(Long idcliente) {
        repository.deleteById(idcliente);
        return"redirect:/cliente";
    }

}
