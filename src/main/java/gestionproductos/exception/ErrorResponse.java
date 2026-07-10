package gestionproductos.exception;

import java.util.List;

public class ErrorResponse {
    private int estado;
    private String mensaje;
    private List<String> detalles;

    public ErrorResponse(int estado, String mensaje, List<String> detalles) {
        this.estado = estado;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

    public int getEstado() { return estado; }
    public String getMensaje() { return mensaje; }
    public List<String> getDetalles() { return detalles; }
}