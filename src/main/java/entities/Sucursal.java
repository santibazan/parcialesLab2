package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sucursal")

public class Sucursal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre_sucursal")
    private String nombre;

    @Column(name = "horario_apertura")
    private LocalTime horarioApertura;

    @Column(name = "horario_cierre")
    private LocalTime horarioCierre;

    @Column(name = "casa_matriz")
    private boolean casaMatriz;


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_sucursal_domicilio")
    private Domicilio domicilioSucursal;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_empresa")
    private Empresa empresa;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "sucursal_categoria",
            joinColumns = @JoinColumn(name = "fk_sucursal"),
            inverseJoinColumns = @JoinColumn(name = "fk_categoria")
    )
    private List<Categoria> categorias;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "sucursal_promocion",
            joinColumns = @JoinColumn(name = "fk_sucursal"),
            inverseJoinColumns = @JoinColumn(name = "fk_promocion")
    )
    private List<Promocion> promociones;

    public Sucursal() {
    }

    public Sucursal(String nombre, LocalTime horarioApertura, LocalTime horarioCierre, boolean casaMatriz) {
        this.nombre = nombre;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.casaMatriz = casaMatriz;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalTime getHorarioApertura() {
        return horarioApertura;
    }

    public void setHorarioApertura(LocalTime horarioApertura) {
        this.horarioApertura = horarioApertura;
    }

    public LocalTime getHorarioCierre() {
        return horarioCierre;
    }

    public void setHorarioCierre(LocalTime horarioCierre) {
        this.horarioCierre = horarioCierre;
    }

    public boolean getCasaMatriz() {
        return casaMatriz;
    }

    public void setCasaMatriz(boolean casaMatriz) {
        this.casaMatriz = casaMatriz;
    }

    //constructor, getter and setter de relaciones

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Promocion> getPromociones() {
        return promociones;
    }

    public Domicilio getDomicilioSucursal() {
        return domicilioSucursal;
    }

    public void setDomicilioSucursal(Domicilio domicilioSucursal) {
        this.domicilioSucursal = domicilioSucursal;
    }


    public List<Categoria> getCategorias() {
        return categorias;
    }


}
