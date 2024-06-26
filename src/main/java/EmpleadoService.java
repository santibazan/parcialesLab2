import java.util.List;

public class EmpleadoService {
    private EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Empleado obtenerEmpleadoPorId(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    public List<Empleado> listarTodosLosEmpleados() {
        return empleadoRepository.findAll();
    }

    public void eliminarEmpleadoPorId(Long id) {
        empleadoRepository.deleteById(id);
    }

}
