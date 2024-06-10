package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Articulo_manufacturado_detalle")

public class ArticuloManufacturadoDetalle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_articulo_insumo")
    private ArticuloInsumo articuloInsumo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_articulo_manufacturado")
    private ArticuloManufacturado articuloManufacturado;

    public ArticuloManufacturadoDetalle() {
    }
    public ArticuloManufacturadoDetalle(Integer cantidad){
        this.cantidad=cantidad;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    //Getter and setter de la relacion


    public ArticuloInsumo getArticuloInsumo() {
        return articuloInsumo;
    }

    public void setArticuloInsumo(ArticuloInsumo articuloInsumo) {
        this.articuloInsumo = articuloInsumo;
    }

    public ArticuloManufacturado getArticuloManufacturado() {
        return articuloManufacturado;
    }

    public void setArticuloManufacturado(ArticuloManufacturado articuloManufacturado) {
        this.articuloManufacturado = articuloManufacturado;
    }
}
