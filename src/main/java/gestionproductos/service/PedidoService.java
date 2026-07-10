package gestionproductos.service;

import java.util.List;
import org.springframework.stereotype.Service;
import gestionproductos.model.LineaPedido;
import gestionproductos.model.Pedido;
import gestionproductos.model.Producto;
import gestionproductos.repository.PedidoRepository;
import gestionproductos.repository.ProductoRepository;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;

    public PedidoService(PedidoRepository pedidoRepository,
                        ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.productoRepository = productoRepository;
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> obtenerPedidosPorUsuario(String usuarioId) {
        return pedidoRepository.findByUsuarioId(usuarioId);
    }

    public Pedido crearPedido(Pedido pedido) {
        for (LineaPedido linea : pedido.getLineas()) {

            Producto productoDB = productoRepository.findById(linea.getProducto().getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + linea.getProducto().getId()));


            if (productoDB.getStock() < linea.getCantidad()) {
                throw new RuntimeException("Stock insuficiente para el producto: " + productoDB.getNombre());
            }

            productoDB.setStock(productoDB.getStock() - linea.getCantidad());
            productoRepository.save(productoDB);

            linea.setProducto(productoDB);
        }
        return pedidoRepository.save(pedido);
    }

    public Pedido eliminarPedido(String id) {
        Pedido pedido = pedidoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + id));
        pedidoRepository.delete(pedido);
        return pedido;
    }
}
