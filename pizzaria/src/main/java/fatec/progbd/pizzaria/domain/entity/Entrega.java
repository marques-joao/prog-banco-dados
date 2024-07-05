package fatec.progbd.pizzaria.domain.entity;

import fatec.progbd.pizzaria.domain.enums.StatusEntrega;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
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
    private boolean pagamentoConfirmado;

    @Enumerated(EnumType.STRING)
    private StatusEntrega statusEntrega;

    @OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

}