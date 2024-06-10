import entities.*;
import entities.enums.Estado;
import entities.enums.FormaPago;
import entities.enums.Rol;
import entities.enums.TipoEnvio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;

public class main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Empleado emp1= new Empleado("Jorge", "Games", "2615480612", "jorgitogames@gmail.com", LocalDate.of(2002,1, 4), Rol.COCINERO);
            ImagenEmpleado imagenEmpleado1= new ImagenEmpleado("Foto empleado 1");
            UsuarioEmpleado usuarioEmpleado = new UsuarioEmpleado("UE1", "userEmpleado1");
            Sucursal suc1 = new Sucursal("Lomitos", LocalTime.of(20,30), LocalTime.of(02,00), true);
            Sucursal suc2 = new Sucursal("Jhonny Rockets", LocalTime.of(11,00), LocalTime.of(23,59), true);

            emp1.setImagenEmpleado(imagenEmpleado1);
            emp1.setUsuarioEmpleado(usuarioEmpleado);
            emp1.setSucursal(suc1);

            entityManager.persist(emp1);

            Cliente cliente1 = new Cliente("Matias", "Garcia","2613297612", "matigarcia@gmail.com", LocalDate.of(2002,07, 19), Rol.CLIENTE);
            ImagenCliente imagenCliente1 = new ImagenCliente("imagenCliente1");
            UsuarioCliente usuarioCliente1 = new UsuarioCliente("usuarioCliente1", "userCliente1");

            Pais pais1 = new Pais("Argentina");
            Provincia provincia1 = new Provincia("Mendoza", pais1);
            Provincia provincia2 = new Provincia("Cordoba", pais1);
            Localidad localidad1 = new Localidad("Godoy Cruz", provincia1);
            Localidad localidad2 = new Localidad("Rio Cuarto", provincia2);

            Domicilio dom1 = new Domicilio("Doctor Carrillo", 3090,5500, localidad1);
            Domicilio dom2 = new Domicilio("Avenida Italia", 1300,1398, localidad2);

            cliente1.setImagenCliente(imagenCliente1);
            cliente1.setUsuarioCliente(usuarioCliente1);

            cliente1.getDomicilioCliente().add(dom1);
            cliente1.getDomicilioCliente().add(dom2);

            entityManager.persist(cliente1);

            Empresa Emp1 = new Empresa("Villavicencio", "envasadora", 30-70854276-4);
            Empresa Emp2 = new Empresa("Unilever", "Higiene", 30-50109269-6);

            suc1.setEmpresa(Emp1);
            suc2.setEmpresa(Emp2);

            Pedido ped1= new Pedido(LocalTime.of(17, 15), 10000.00, 7000.00, Estado.PREPARACION, TipoEnvio.TAKEAWAY, FormaPago.EFECTIVO, LocalDate.of(2024, 6, 3));

            ped1.setEmpleado(emp1);
            ped1.setCliente(cliente1);
            ped1.setDomicilio(dom1);
            ped1.setSucursal(suc1);

            Factura fac1 = new Factura(LocalDate.of(2024, 5, 30), 222, 222, "santiagob1" ,FormaPago.MERCADOPAGO, 2000.00 );

            ped1.setFactura(fac1);

            entityManager.persist(ped1);


            entityManager.flush();
            entityManager.getTransaction().commit();
        }catch ( Exception e){
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
