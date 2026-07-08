package gestionproductos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gestionproductos.model.Producto;
import gestionproductos.repository.ProductoRepository;

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

    public Producto buscarPorId(String id) {
        return productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Este prodcuto no se encuentra: " + id));
    }

    public void eliminarProducto(String id) {
        productoRepository.deleteById(id);
    }

    public Producto actualizarProducto(String id, Producto productoActualizado) {

        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setNombre(productoActualizado.getNombre());
        producto.setDescripcion(productoActualizado.getDescripcion());
        producto.setPrecio(productoActualizado.getPrecio());
        producto.setStock(productoActualizado.getStock());

        return productoRepository.save(producto);
    }
}