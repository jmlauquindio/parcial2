package co.edu.uniquindio.SOLID.utils.Mappers;

import co.edu.uniquindio.SOLID.Model.MovimientoInventario;
import co.edu.uniquindio.SOLID.Model.DTO.MovimientoInventarioDTO;

public class MovimientoInventarioMapper {

	public static MovimientoInventarioDTO toDTO(MovimientoInventario movimiento) {
		if (movimiento == null) return null;
		return new MovimientoInventarioDTO(
				movimiento.getId(),
				movimiento.getTipo().name(),
				movimiento.getFecha(),
				movimiento.getProducto().getSku(),
				movimiento.getCantidad(),
				movimiento.getReferencia()
		);
	}
}
