package co.edu.uniquindio.SOLID.Service;

import co.edu.uniquindio.SOLID.Model.Empleado;
import co.edu.uniquindio.SOLID.Model.Minimercado;
import java.util.List;

public class EmpleadoService {
    private final Minimercado minimercado;

    public EmpleadoService() {
        this.minimercado = Minimercado.getInstancia();
    }

    public List<Empleado> obtenerEmpleados() {
        return minimercado.getEmpleados();
    }

    public Empleado crearEmpleado(String id, String nombre, String rolStr) {
        if (buscarEmpleado(id) != null) {
            throw new IllegalArgumentException("Ya existe un empleado con ese ID");
        }
        Empleado empleado = new Empleado(id, nombre, Empleado.Rol.valueOf(rolStr));
        minimercado.getEmpleados().add(empleado);
        return empleado;
    }

    public Empleado buscarEmpleado(String id) {
        for (Empleado e : minimercado.getEmpleados()) {
            if (e.getId().equals(id)) return e;
        }
        return null;
    }

    public Empleado actualizarEmpleado(String id, String nombre, String rolStr, Boolean activo) {
        Empleado e = buscarEmpleado(id);
        if (e == null) {
            throw new IllegalArgumentException("Empleado no encontrado: " + id);
        }
        if (nombre != null) e.setNombre(nombre);
        if (rolStr != null) e.setRol(Empleado.Rol.valueOf(rolStr));
        if (activo != null) { if (activo) e.activar(); else e.inactivar(); }
        return e;
    }

    public void eliminarEmpleado(String id) {
        Empleado e = buscarEmpleado(id);
        if (e == null) {
            throw new IllegalArgumentException("Empleado no encontrado: " + id);
        }
        minimercado.getEmpleados().remove(e);
    }
}
