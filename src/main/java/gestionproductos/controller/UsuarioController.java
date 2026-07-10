package gestionproductos.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import gestionproductos.model.Pedido;
import gestionproductos.service.PedidoService;

@RestController
@RequestMapping("/api/usuarios") 
public class UsuarioController {

    private final PedidoService pedidoService;

    public UsuarioController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/{usuarioId}/pedidos")
    public List<Pedido> obtenerPedidosDeUsuario(@PathVariable String usuarioId) {
        return pedidoService.obtenerPedidosPorUsuario(usuarioId);
    }
}