package co.edu.uniquindio.SOLID.utils.Mappers;

import co.edu.uniquindio.SOLID.Model.Empleado;
import co.edu.uniquindio.SOLID.Model.DTO.EmpleadoDTO;

public class EmpleadoMapper {

	public static EmpleadoDTO toDTO(Empleado empleado) {
		if (empleado == null) return null;
		return new EmpleadoDTO(
				empleado.getId(),
				empleado.getNombre(),
				empleado.getRol().name(),
				empleado.isActivo()
		);
	}

	public static Empleado toEntity(EmpleadoDTO dto) {
		if (dto == null) return null;
		Empleado.Rol rol = Empleado.Rol.valueOf(dto.getRol());
		Empleado empleado = new Empleado(dto.getId(), dto.getNombre(), rol);
		if (!dto.isActivo()) empleado.inactivar();
		return empleado;
	}

	public static void updateEntityFromDTO(Empleado empleado, EmpleadoDTO dto) {
		if (empleado == null || dto == null) return;
		empleado.setNombre(dto.getNombre());
		empleado.setRol(Empleado.Rol.valueOf(dto.getRol()));
		if (dto.isActivo()) empleado.activar(); else empleado.inactivar();
	}
}
