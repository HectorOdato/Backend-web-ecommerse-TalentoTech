package gestionproductos.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import gestionproductos.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}