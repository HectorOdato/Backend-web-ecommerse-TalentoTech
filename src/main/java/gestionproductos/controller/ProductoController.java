package gestionproductos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import gestionproductos.model.Producto;
import gestionproductos.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
    public Producto guardarProducto(@Valid @RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }

    @GetMapping("/{id}")
    public Producto buscarPorId(@PathVariable String id) {
        return productoService.buscarPorId(id);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Producto> obtenerPorCategoria(@PathVariable String categoriaId) {
        return productoService.obtenerPorCategoria(categoriaId);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable String id) {
        productoService.eliminarProducto(id);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable String id, @Valid @RequestBody Producto productoActualizado) {
        return productoService.actualizarProducto(id, productoActualizado);
    }
}