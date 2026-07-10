package gestionproductos.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import gestionproductos.model.Categoria;
import gestionproductos.service.CategoriaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    @PostMapping
    public Categoria guardarCategoria(@Valid @RequestBody Categoria categoria) {
        return categoriaService.guardarCategoria(categoria);
    }
}