package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario_cliente")
public class UsuarioCliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "auth0_oid")
    private String auth0id;

    @Column(name = "username")
    private String username;

    public UsuarioCliente() {
    }

    public UsuarioCliente(String auth0id, String username) {
        this.auth0id = auth0id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuth0id() {
        return auth0id;
    }

    public void setAuth0id(String auth0id) {
        this.auth0id = auth0id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
