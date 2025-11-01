package co.edu.uniquindio.SOLID.utils.Mappers;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.SOLID.Model.DTO.EntradaInventarioDTO;
import co.edu.uniquindio.SOLID.Model.DTO.ItemEntradaDTO;
import co.edu.uniquindio.SOLID.Model.EntradaInventario;
import co.edu.uniquindio.SOLID.Model.ItemEntrada;
import co.edu.uniquindio.SOLID.Model.Minimercado;
import co.edu.uniquindio.SOLID.Model.Producto;
import co.edu.uniquindio.SOLID.Model.Proveedor;

public class EntradaInventarioMapper {

	public static EntradaInventario toEntity(EntradaInventarioDTO dto) {
		if (dto == null) return null;
		Minimercado repo = Minimercado.getInstancia();

		Proveedor proveedor = repo.buscarProveedor(dto.getNitProveedor());
		if (proveedor == null) return null;

		EntradaInventario entrada = new EntradaInventario(dto.getId(), proveedor);
		List<ItemEntrada> items = new ArrayList<>();

		if (dto.getItems() != null) {
			for (ItemEntradaDTO itemDTO : dto.getItems()) {
				Producto producto = null;
				for (Producto p : repo.getProductos()) {
					if (p.getSku().equals(itemDTO.getSkuProducto())) { producto = p; break; }
				}
				if (producto != null && itemDTO.getCantidad() > 0) {
					items.add(new ItemEntrada(producto, itemDTO.getCantidad()));
				}
			}
		}

		for (ItemEntrada item : items) {
			entrada.getItems().add(item);
		}

		return entrada;
	}
}
