package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario_empleado")
public class UsuarioEmpleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "auth0_oid")
    private String auth0Id;

    @Column(name = "username")
    private String username;

    public UsuarioEmpleado() {
    }

    public UsuarioEmpleado(String auth0Id, String username) {
        this.auth0Id = auth0Id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuth0Id() {
        return auth0Id;
    }

    public void setAuth0Id(String auth0Id) {
        this.auth0Id = auth0Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
