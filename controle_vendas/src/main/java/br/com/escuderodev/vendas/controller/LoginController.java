package br.com.escuderodev.vendas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
    @GetMapping
    public String loadLoginPage() {

        return "login/formulario";
    }

    @PostMapping
    public String efetuarLogin() {

        return "redirect:/pedido";
    }
}