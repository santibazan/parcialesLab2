package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "denominacion")
    private String denoominacion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_categoria_propietario")
    private Categoria categoriaPropietario;

    public Categoria() {
    }

    public Categoria(String denoominacion) {
        this.denoominacion = denoominacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDenoominacion() {
        return denoominacion;
    }

    public void setDenoominacion(String denoominacion) {
        this.denoominacion = denoominacion;
    }
    //Getter and setter de la relacion

    public Categoria getCategoriaPropietario() {
        return categoriaPropietario;
    }

}
