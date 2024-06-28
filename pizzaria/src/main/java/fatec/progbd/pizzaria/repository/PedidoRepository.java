package fatec.progbd.pizzaria.repository;

import fatec.progbd.pizzaria.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
