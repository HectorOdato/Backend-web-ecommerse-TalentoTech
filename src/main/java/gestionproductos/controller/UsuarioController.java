package gestionproductos.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import gestionproductos.model.Usuario;
import gestionproductos.model.Pedido;
import gestionproductos.service.UsuarioService;
import gestionproductos.service.PedidoService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final PedidoService pedidoService;

    public UsuarioController(UsuarioService usuarioService, PedidoService pedidoService) {
        this.usuarioService = usuarioService;
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @DeleteMapping("/{id}")
    public Usuario eliminarUsuario(@PathVariable String id) {
        return usuarioService.eliminarUsuario(id);
    }

    @GetMapping("/{usuarioId}/pedidos")
    public List<Pedido> obtenerPedidosDeUsuario(@PathVariable String usuarioId) {
        usuarioService.buscarPorId(usuarioId); 
        return pedidoService.obtenerPedidosPorUsuario(usuarioId);
    }
}