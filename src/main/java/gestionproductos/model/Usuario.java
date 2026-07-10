package gestionproductos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;


@Document(collection = "usuarios")
public class Usuario {
    @Id
    private String id;

    @NotBlank(message = "El nombre de usuario no puede estar vacío.")
    private String nombreUsuario;

    @NotBlank(message = "El mail es obligatorio.")
    private String mail;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String mail) {
        this.nombreUsuario = nombreUsuario;
        this.mail = mail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
