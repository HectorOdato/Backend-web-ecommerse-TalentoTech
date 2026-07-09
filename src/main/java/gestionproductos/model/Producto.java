package gestionproductos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.DecimalMin;
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
    @DecimalMin(value = "0.0", message = "El precio no puede ser negativo.")
    private Double precio;

    @NotNull(message = "el stock es obligatorio.")
    @Min(value = 0, message = "El stock no puede ser negativo.")
    private Integer stock;

public Producto() {
}

public Producto(String descripcion, String nombre, Double precio, Integer stock) {

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
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
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