package co.edu.uniquindio.SOLID.utils.Mappers;

import co.edu.uniquindio.SOLID.Model.Proveedor;
import co.edu.uniquindio.SOLID.Model.DTO.ProveedorDTO;

public class ProveedorMapper {

	public static ProveedorDTO toDTO(Proveedor proveedor) {
		if (proveedor == null) return null;
		return new ProveedorDTO(
				proveedor.getNit(),
				proveedor.getNombre(),
				proveedor.getContacto(),
				proveedor.getEmail(),
				proveedor.getTelefono(),
				proveedor.isActivo()
		);
	}

	public static Proveedor toEntity(ProveedorDTO dto) {
		if (dto == null) return null;
		Proveedor proveedor = new Proveedor(
				dto.getNit(),
				dto.getNombre(),
				dto.getContacto(),
				dto.getEmail(),
				dto.getTelefono()
		);
		if (!dto.isActivo()) {
			proveedor.inactivar();
		}
		return proveedor;
	}

	public static void updateEntityFromDTO(Proveedor proveedor, ProveedorDTO dto) {
		if (proveedor == null || dto == null) return;
		proveedor.setNombre(dto.getNombre());
		proveedor.setContacto(dto.getContacto());
		proveedor.setEmail(dto.getEmail());
		proveedor.setTelefono(dto.getTelefono());
		if (dto.isActivo()) proveedor.activar(); else proveedor.inactivar();
	}
}
