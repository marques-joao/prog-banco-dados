package fatec.progbd.pizzaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataEntrega;
    private LocalTime horaEntrega;
    private String tipoPagamento;
    private String codigoDeEntrega;

    @OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL)
    private List<Pedido> pedidos = new ArrayList<>();

}