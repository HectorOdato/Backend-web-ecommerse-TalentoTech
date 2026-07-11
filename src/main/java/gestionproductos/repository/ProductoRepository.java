package gestionproductos.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import gestionproductos.model.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String> {
    List<Producto> findByCategoria_Id(String categoriaId);

}

    