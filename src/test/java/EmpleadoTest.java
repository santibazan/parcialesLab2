import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class EmpleadoTest {
    @Mock
    private EmpleadoRepository empleadoRepository;

    @InjectMocks
    private EmpleadoService empleadoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGuardarEmpleado() {

        Empleado empleado = new Empleado("Santiago", "Bazan", "2613297612", "Santiago.n.bazan@outlook.com", LocalDate.of(2002, 7, 19), Rol.Empleado);
        when(empleadoRepository.save(empleado)).thenReturn(empleado);

        Empleado empleadoGuardado = empleadoService.guardarEmpleado(empleado);


        assertThat(empleadoGuardado.getNombre()).isEqualTo("Santiago");
        assertThat(empleadoGuardado.getApellido()).isEqualTo("Bazan");
        assertThat(empleadoGuardado.getTelefono()).isEqualTo("2613297612");
        assertThat(empleadoGuardado.getEmail()).isEqualTo("Santiago.n.bazan@outlook.com");
        assertThat(empleadoGuardado.getFechaNacimiento()).isEqualTo(LocalDate.of(2002, 7, 19));
        assertThat(empleadoGuardado.getRol()).isEqualTo(Rol.Empleado);

        verify(empleadoRepository).save(empleado);

    }
    @Test
    void testobtenerEmpleadoPorId(){
        Empleado empleado = new Empleado("Santiago", "Bazan", "2613297612", "Santiago.n.bazan@outlook.com", LocalDate.of(2002, 7, 19), Rol.Empleado);
        when(empleadoRepository.findById(1L)).thenReturn(Optional.of(empleado));

        Empleado empleadoRetorno = empleadoService.obtenerEmpleadoPorId(1L);

        assertThat(empleadoRetorno).isNotNull();
        assertThat(empleadoRetorno.getNombre()).isEqualTo("Santiago");
        assertThat(empleadoRetorno.getApellido()).isEqualTo("Bazan");
        assertThat(empleadoRetorno.getTelefono()).isEqualTo("2613297612");
        assertThat(empleadoRetorno.getEmail()).isEqualTo("Santiago.n.bazan@outlook.com");
        assertThat(empleadoRetorno.getFechaNacimiento()).isEqualTo(LocalDate.of(2002, 7, 19));
        assertThat(empleadoRetorno.getRol()).isEqualTo(Rol.Empleado);

        verify(empleadoRepository).findById(1L);
    }
    @Test
    void testlistarTodosLosEmpleados(){
        Empleado empleado = new Empleado("Mario", "Bazan", "2616630994", "mariorbazan@gmail.com", LocalDate.of(1955, 4, 15), Rol.Empleado);
        Empleado empleado1 = new Empleado("Patricia", "Del Corso","2615938339","patriciadel1@gmail.com",LocalDate.of(1963,6,15),Rol.Empleado);
        Empleado empleado2 = new Empleado("Santiago", "Bazan","261765435","santiago@gmail.com",LocalDate.of(2002,7,21),Rol.Empleado);
        when(empleadoRepository.findAll()).thenReturn(Arrays.asList(empleado,empleado1,empleado2));

        List<Empleado> empleados = empleadoService.listarTodosLosEmpleados();

        assertThat(empleados).hasSize(3);
        assertThat(empleados).extracting(Empleado::getNombre).contains("Mario","Patricia","Santiago");

        verify(empleadoRepository).findAll();
    }
    @Test
    void testEliminarEmpleadoPorId(){
        empleadoService.eliminarEmpleadoPorId(1L);

        verify(empleadoRepository).deleteById(1L);
    }
    @Test
    public void testGuardarEmpleado_LanzaExcepcion() {

        Empleado empleado = new Empleado( "Santiago","Bazan", "2613297612", "Santiago@outlook.com", LocalDate.of(2002, 7, 19), Rol.Empleado);
        when(empleadoRepository.save(empleado)).thenThrow(new RuntimeException("Error al guardar el empleado"));

        try {
            empleadoService.guardarEmpleado(empleado);
        } catch (RuntimeException e) {
            Assertions.assertThat(e.getMessage()).isEqualTo("Error al guardar el empleado");
        }

        verify(empleadoRepository).save(empleado);
    }





}