package gestionproductos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Document(collection = "productos")
public class Producto {
    @Id
    private String id;

    @NotBlank(message = "La descripción no puede estar vacía.")
    private String descripcion;

    @NotBlank(message = "El nombre es obligatorio.")
    private String nombre;

    @NotNull(message = "por favor ingrese un precio.")
    @Min(value = 0, message = "El precio no puede ser negativo.")
    private double precio;

    @NotNull(message = "el stock es obligatorio.")
    @Min(value = 0, message = "El stock no puede ser negativo.")
    private int stock;

public Producto() {
}

public Producto(String descripcion, String nombre, double precio, int stock) {

    setDescripcion(descripcion);
    setNombre(nombre);
    setPrecio(precio);
    setStock(stock);
}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía.");
        }
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Nombre: " + nombre +
                " | Descripcion: " + descripcion +
                " | Precio: $" + precio +
                " | Stock: " + stock;
    }
}