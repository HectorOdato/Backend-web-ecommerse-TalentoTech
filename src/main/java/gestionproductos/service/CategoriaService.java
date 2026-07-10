package gestionproductos.service;

import java.util.List;
import org.springframework.stereotype.Service;
import gestionproductos.model.Categoria;
import gestionproductos.repository.CategoriaRepository;
import gestionproductos.exception.ResourceNotFoundException;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    public Categoria buscarPorId(String id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con ID: " + id));
    }

    public void eliminarCategoria(String id) {
        categoriaRepository.deleteById(id);
    }

    public Categoria actualizarCategoria(String id, Categoria categoriaActualizada) {
        Categoria categoria = categoriaRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con ID: " + id));

        categoria.setNombre(categoriaActualizada.getNombre());
        categoria.setDescripcion(categoriaActualizada.getDescripcion());

        return categoriaRepository.save(categoria);
    }
}