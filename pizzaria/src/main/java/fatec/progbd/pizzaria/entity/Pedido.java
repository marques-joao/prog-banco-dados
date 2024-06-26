package fatec.progbd.pizzaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;
    private LocalTime hora;
    private int quantidadeItens;
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "entrega_id")
    private Entrega entrega;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(Cliente cliente, Entrega entrega, LocalDate data, LocalTime hora, List<ItemPedido> itens, int quantidadeItens, BigDecimal valorTotal) {
        this.cliente = cliente;
        this.entrega = entrega;
        this.data = data;
        this.hora = hora;
        this.itens = itens;
        this.quantidadeItens = quantidadeItens;
        this.valorTotal = valorTotal;
    }

}