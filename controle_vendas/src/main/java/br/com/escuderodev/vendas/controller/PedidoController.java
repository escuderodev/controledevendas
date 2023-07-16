package br.com.escuderodev.vendas.controller;

import br.com.escuderodev.vendas.models.pedido.DadosAtualizaPedido;
import br.com.escuderodev.vendas.models.pedido.DadosCadastroPedido;
import br.com.escuderodev.vendas.models.pedido.Pedido;
import br.com.escuderodev.vendas.models.pedido.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping("formulario")
    public String loadFormPage(Long id, Model model) {
        if (id != null) {
            var pedido = repository.getReferenceById(id);
            model.addAttribute("pedido", pedido);
        }
        return "pedido/formulario";
    }

    @GetMapping
    public String loadListPage(Model model) {
        List<Pedido> pedidos = repository.findAll();
        var pedido = new Pedido();
        BigDecimal totalPedidos = pedido.calculaTotalPedidos(pedidos);
        BigDecimal totalComissao = pedido.calculaTotalComissao(pedidos);
        model.addAttribute("listaDePedidos", pedidos);
        model.addAttribute("totalPedidos", totalPedidos);
        model.addAttribute("totalComissao", totalComissao);
        return "pedido/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraPedido(DadosCadastroPedido dados) {
        var pedido = new Pedido(dados);
        pedido.setComissao((pedido.getPercentual().divide(new BigDecimal(100))).multiply(pedido.getValor()));
        pedido.setDataVencimentoBoleto(pedido.getDataEnvioNF().plusDays(pedido.getPrazoPagamento()));
        repository.save(pedido);
        return "redirect:/pedido";
    }

    @PutMapping
    @Transactional
    public String atualizaDadosPedido(DadosAtualizaPedido dados) {
        var pedido = repository.getReferenceById(dados.idpedido());
        pedido.atualizaDados(dados);
        pedido.setComissao((pedido.getPercentual().divide(new BigDecimal(100))).multiply(pedido.getValor()));
        pedido.setDataVencimentoBoleto(pedido.getDataEnvioNF().plusDays(pedido.getPrazoPagamento()));
        return "redirect:/pedido";
    }

    @DeleteMapping
    @Transactional
    public String deletaPedido(Long idpedido) {
        repository.deleteById(idpedido);

        return"redirect:/pedido";
    }

}
