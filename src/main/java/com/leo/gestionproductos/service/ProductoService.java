package com.leo.gestionproductos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.leo.gestionproductos.model.Producto;
import com.leo.gestionproductos.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }
}