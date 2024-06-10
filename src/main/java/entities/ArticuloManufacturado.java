package entities;

import javax.persistence.*;

@Entity
@Table(name="Articulo_manufacturado")

public class ArticuloManufacturado extends Articulo{

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="tiempo_estimado_minutos")
    private int tiempoEstimadoMinutos;

    @Column(name="preparacion")
    private String preparacion;

    public ArticuloManufacturado() {
    }

    public ArticuloManufacturado(String denominacion, double precioVenta, String descripcion, int tiempoEstimadoMinutos, String preparacion) {
        super(denominacion, precioVenta);
        this.descripcion = descripcion;
        this.tiempoEstimadoMinutos = tiempoEstimadoMinutos;
        this.preparacion = preparacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTiempoEstimadoMinutos() {
        return tiempoEstimadoMinutos;
    }

    public void setTiempoEstimadoMinutos(int tiempoEstimadoMinutos) {
        this.tiempoEstimadoMinutos = tiempoEstimadoMinutos;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }
}
