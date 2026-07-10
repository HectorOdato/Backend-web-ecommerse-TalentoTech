package gestionproductos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import gestionproductos.model.Pedido;
import java.util.List;

public interface PedidoRepository extends MongoRepository<Pedido, String> {
    List<Pedido> findByUsuarioId(String usuarioId);
}

