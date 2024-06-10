package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "imagen_promocion")

public class ImagenPromocion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

    @Column(name = "denominacion")
    private String denominacion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_promocion")
    private Promocion promocion;

    public ImagenPromocion() {
    }

    public ImagenPromocion(String denominacion) {
        this.denominacion = denominacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
    //Getter and setter de la relacion

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }
}
