package gestionproductos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import gestionproductos.model.Pedido;

public interface PedidoRepository extends MongoRepository<Pedido, String> {

    
}

