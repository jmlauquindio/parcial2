package co.edu.uniquindio.SOLID.Service;

import co.edu.uniquindio.SOLID.Model.Empleado;
import co.edu.uniquindio.SOLID.Model.Minimercado;
import co.edu.uniquindio.SOLID.Model.DTO.EmpleadoDTO;
import co.edu.uniquindio.SOLID.utils.Mappers.EmpleadoMapper;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoService {
    private final Minimercado minimercado;

    public EmpleadoService() {
        this.minimercado = Minimercado.getInstancia();
    }

    public List<EmpleadoDTO> obtenerEmpleados() {
        List<EmpleadoDTO> dtos = new ArrayList<>();
        for (Empleado e : minimercado.getEmpleados()) {
            dtos.add(EmpleadoMapper.toDTO(e));
        }
        return dtos;
    }

    public EmpleadoDTO crearEmpleado(EmpleadoDTO dto) {
        if (buscarEmpleado(dto.getId()) != null) {
            throw new IllegalArgumentException("Ya existe un empleado con ese ID");
        }
        Empleado empleado = EmpleadoMapper.toEntity(dto);
        minimercado.getEmpleados().add(empleado);
        return EmpleadoMapper.toDTO(empleado);
    }

    public EmpleadoDTO buscarEmpleado(String id) {
        for (Empleado e : minimercado.getEmpleados()) {
            if (e.getId().equals(id)) return EmpleadoMapper.toDTO(e);
        }
        return null;
    }

    public EmpleadoDTO actualizarEmpleado(EmpleadoDTO dto) {
        Empleado e = null;
        for (Empleado emp : minimercado.getEmpleados()) {
            if (emp.getId().equals(dto.getId())) { e = emp; break; }
        }
        if (e == null) throw new IllegalArgumentException("Empleado no encontrado: " + dto.getId());
        EmpleadoMapper.updateEntityFromDTO(e, dto);
        return EmpleadoMapper.toDTO(e);
    }

    public EmpleadoDTO activarEmpleado(String id) {
        Empleado e = null;
        for (Empleado emp : minimercado.getEmpleados()) { if (emp.getId().equals(id)) { e = emp; break; } }
        if (e == null) throw new IllegalArgumentException("Empleado no encontrado: " + id);
        e.activar();
        return EmpleadoMapper.toDTO(e);
    }

    public EmpleadoDTO inactivarEmpleado(String id) {
        Empleado e = null;
        for (Empleado emp : minimercado.getEmpleados()) { if (emp.getId().equals(id)) { e = emp; break; } }
        if (e == null) throw new IllegalArgumentException("Empleado no encontrado: " + id);
        e.inactivar();
        return EmpleadoMapper.toDTO(e);
    }

    public void eliminarEmpleado(String id) {
        Empleado e = null;
        for (Empleado emp : minimercado.getEmpleados()) { if (emp.getId().equals(id)) { e = emp; break; } }
        if (e == null) throw new IllegalArgumentException("Empleado no encontrado: " + id);
        minimercado.getEmpleados().remove(e);
    }
}
