package fatec.progbd.pizzaria.repository;

import fatec.progbd.pizzaria.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}