package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "domicilio")
public class Domicilio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre_calle")
    private String calle;

    @Column(name = "numero_calle")
    private Integer numero;

    @Column(name = "codigo_postal")
    private Integer cp;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;

    public Domicilio() {
    }

    public Domicilio(String calle, Integer numero, Integer cp, Localidad localidad) {
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.localidad = localidad;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }


    public int getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }


    public int getCp() {
        return cp;
    }
    public void setCp(Integer cp) {
        this.cp = cp;
    }

    //getter and setter de la relacion

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
}
