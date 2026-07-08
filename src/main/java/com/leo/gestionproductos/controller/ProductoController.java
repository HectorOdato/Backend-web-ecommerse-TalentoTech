package com.leo.gestionproductos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.leo.gestionproductos.model.Producto;
import com.leo.gestionproductos.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @PostMapping
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }
}