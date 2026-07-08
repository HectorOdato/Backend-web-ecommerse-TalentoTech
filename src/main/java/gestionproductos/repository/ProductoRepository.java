package gestionproductos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import gestionproductos.model.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String> {

}

