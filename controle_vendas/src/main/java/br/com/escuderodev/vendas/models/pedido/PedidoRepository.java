package br.com.escuderodev.vendas.models.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findAllByDataVencimentoBoletoGreaterThanEqualAndDataVencimentoBoletoLessThanEqual(LocalDate startDate, LocalDate endDate);

}
