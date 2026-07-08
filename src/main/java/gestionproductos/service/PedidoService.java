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

}
