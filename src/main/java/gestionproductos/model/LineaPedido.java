package gestionproductos.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class LineaPedido {

    @NotNull(message = "Debe seleccionar un producto")
    private Producto producto;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser mayor a cero")
    private Integer cantidad;

    public LineaPedido() {
    }

    public LineaPedido(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double calcularSubtotal() {
        return producto.getPrecio() * cantidad;
    }
}