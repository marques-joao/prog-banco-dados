package fatec.progbd.pizzaria;

import fatec.progbd.pizzaria.entity.*;
import fatec.progbd.pizzaria.service.ClienteService;
import fatec.progbd.pizzaria.service.EntregaService;
import fatec.progbd.pizzaria.service.ItemPedidoService;
import fatec.progbd.pizzaria.service.PedidoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class InitDB implements CommandLineRunner {

    private final ClienteService clienteService;
    private final PedidoService pedidoService;
    private final EntregaService entregaService;
    private final ItemPedidoService itemPedidoService;

    public InitDB(ClienteService clienteService, PedidoService pedidoService, EntregaService entregaService, ItemPedidoService itemPedidoService) {
        this.clienteService = clienteService;
        this.pedidoService = pedidoService;
        this.entregaService = entregaService;
        this.itemPedidoService = itemPedidoService;
    }

    @Override
    public void run(String... args) {

        /* ------------------- Primeiro Cliente ------------------- */

        Entrega entrega1 = new Entrega(LocalDate.now(), LocalTime.now(), "débito", "123", StatusEntrega.EM_PREPARACAO);
        entregaService.adicionarEntrega(entrega1);

        Cliente cliente1 = new Cliente("João", "(11) 90102-0304", "Rua A, 283", entrega1.getCodigoDeEntrega());
        clienteService.adicionarCliente(cliente1);

        List<ItemPedido> itensPedido1 = new ArrayList<>();
        itensPedido1.add(new ItemPedido("pizza de calabresa", new BigDecimal("39.99"), 2));
        itensPedido1.add(new ItemPedido("pizza de mussarela", new BigDecimal("39.99"), 1));
        itensPedido1.add(new ItemPedido("coca-cola 2L", new BigDecimal("17.00"), 1));

        Pedido pedido1 = new Pedido(cliente1, entrega1, LocalDate.now(), LocalTime.now(), itensPedido1, itensPedido1.size(), pedidoService.calcularTotal(itensPedido1));
        pedidoService.adicionarPedido(pedido1);

        /* ------------------- Segundo Cliente ------------------- */

        Entrega entrega2 = new Entrega(LocalDate.now(), LocalTime.now(), "pix", "456", StatusEntrega.EM_PREPARACAO);
        entregaService.adicionarEntrega(entrega2);

        Cliente cliente2 = new Cliente("Anderson", "(11) 90506-0708", "Rua C, 14", entrega2.getCodigoDeEntrega());
        clienteService.adicionarCliente(cliente2);

        List<ItemPedido> itensPedido2 = new ArrayList<>();
        itensPedido2.add(new ItemPedido("pizza de frango com catupiry", new BigDecimal("39.99"), 1));
        itensPedido2.add(new ItemPedido("pizza de chocolate com morango", new BigDecimal("49.99"), 1));
        itensPedido2.add(new ItemPedido("pepsi 2L", new BigDecimal("17.00"), 1));

        Pedido pedido2 = new Pedido(cliente2, entrega2, LocalDate.now(), LocalTime.now(), itensPedido2, itensPedido2.size(), pedidoService.calcularTotal(itensPedido2));
        pedidoService.adicionarPedido(pedido2);


        /* ------------------- Terceiro Cliente ------------------- */

        Entrega entrega3 = new Entrega(LocalDate.now(), LocalTime.now(), "crédito", "789", StatusEntrega.EM_PREPARACAO);
        entregaService.adicionarEntrega(entrega3);

        Cliente cliente3 = new Cliente("Marília", "(11) 90910-1112", "Rua X, 45", entrega3.getCodigoDeEntrega());
        clienteService.adicionarCliente(cliente3);

        List<ItemPedido> itensPedido3 = new ArrayList<>();
        itensPedido3.add(new ItemPedido("pizza de calabresa", new BigDecimal("39.99"), 2));
        itensPedido3.add(new ItemPedido("pizza de frango com catupiry", new BigDecimal("39.99"), 1));
        itensPedido3.add(new ItemPedido("pizza de chocolate com morango", new BigDecimal("49.99"), 2));
        itensPedido3.add(new ItemPedido("coca-cola 2L", new BigDecimal("17.00"), 1));

        Pedido pedido3 = new Pedido(cliente3, entrega3, LocalDate.now(), LocalTime.now(), itensPedido3, itensPedido3.size(), pedidoService.calcularTotal(itensPedido3));
        pedidoService.adicionarPedido(pedido3);

    }

}