package gestionproductos.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import gestionproductos.model.Categoria;

public interface CategoriaRepository extends MongoRepository<Categoria, String> {
}