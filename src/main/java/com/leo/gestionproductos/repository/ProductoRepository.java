package com.leo.gestionproductos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.leo.gestionproductos.model.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String> {

}

