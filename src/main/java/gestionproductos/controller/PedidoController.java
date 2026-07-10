package gestionproductos.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import gestionproductos.model.Pedido;
import gestionproductos.service.PedidoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @PostMapping
    public Pedido crearPedido(@Valid @RequestBody Pedido pedido) {
        return pedidoService.crearPedido(pedido);
    }

    @DeleteMapping("/{id}")
    public Pedido eliminarPedido(@PathVariable String id) {
        return pedidoService.eliminarPedido(id);
    }
}