package co.edu.uniquindio.SOLID.Service.Fachadas;

import co.edu.uniquindio.SOLID.Model.Minimercado;
import co.edu.uniquindio.SOLID.Model.Producto;
import co.edu.uniquindio.SOLID.Model.Proveedor;
import co.edu.uniquindio.SOLID.Model.EntradaInventario;
import co.edu.uniquindio.SOLID.Model.MovimientoInventario;
import java.util.List;

public class InventarioFacade {
	private final Minimercado minimercado;

	public InventarioFacade() {
		minimercado = Minimercado.getInstancia();
	}

	public List<Producto> obtenerProductos() {
		return minimercado.getProductos();
	}

	public List<MovimientoInventario> obtenerMovimientos() {
		return minimercado.getMovimientos();
	}

	public EntradaInventario registrarEntrada(Proveedor proveedor, Producto producto, int cantidad) {
		return minimercado.registrarEntradaInventario(proveedor, producto, cantidad);
	}
}
