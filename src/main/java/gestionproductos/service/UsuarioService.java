package gestionproductos.service;

import java.util.List;
import org.springframework.stereotype.Service;
import gestionproductos.model.Usuario;
import gestionproductos.repository.UsuarioRepository;
import gestionproductos.exception.ResourceNotFoundException;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(String id) {
        return usuarioRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + id));
    }

    public Usuario eliminarUsuario(String id) {
        Usuario usuario = buscarPorId(id);
        usuarioRepository.delete(usuario);
        return usuario;
    }
}