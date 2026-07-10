package gestionproductos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import gestionproductos.model.Producto;
import gestionproductos.model.Categoria;
import gestionproductos.repository.ProductoRepository;
import gestionproductos.repository.CategoriaRepository;
import gestionproductos.exception.ResourceNotFoundException;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProductoService(ProductoRepository productoRepository, CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto guardarProducto(Producto producto) {
        Categoria categoria = categoriaRepository.findById(producto.getCategoria().getId())
            .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con ID: " + producto.getCategoria().getId()));

        producto.setCategoria(categoria);
        return productoRepository.save(producto);
    }

    public Producto buscarPorId(String id) {
        return productoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Este prodcuto no se encuentra: " + id));
    }

    public void eliminarProducto(String id) {
        productoRepository.deleteById(id);
    }

    public Producto actualizarProducto(String id, Producto productoActualizado) {

        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        producto.setNombre(productoActualizado.getNombre());
        producto.setDescripcion(productoActualizado.getDescripcion());
        producto.setImagenURL(productoActualizado.getImagenURL());
        producto.setPrecio(productoActualizado.getPrecio());
        producto.setStock(productoActualizado.getStock());

        if (productoActualizado.getCategoria() != null) {
            Categoria categoria = categoriaRepository.findById(productoActualizado.getCategoria().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con ID: " + productoActualizado.getCategoria().getId()));
            producto.setCategoria(categoria);
        }

        return productoRepository.save(producto);
    }
}