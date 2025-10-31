package co.edu.uniquindio.SOLID.Service.Fachadas;

import co.edu.uniquindio.SOLID.Model.Minimercado;
import co.edu.uniquindio.SOLID.Model.Empleado;
import co.edu.uniquindio.SOLID.Model.Proveedor;
import java.util.List;

public class EmpresaAdminFacade {
	private final Minimercado minimercado;

	public EmpresaAdminFacade() {
		minimercado = Minimercado.getInstancia();
	}

	public List<Empleado> obtenerEmpleados() {
		return minimercado.getEmpleados();
	}

	public Empleado crearEmpleado(String id, String nombre, String rolStr) {
		return minimercado.crearEmpleado(id, nombre, rolStr);
	}

	public Empleado buscarEmpleado(String id) {
		return minimercado.buscarEmpleado(id);
	}

	public Empleado actualizarEmpleado(String id, String nombre, String rolStr, Boolean activo) {
		return minimercado.actualizarEmpleado(id, nombre, rolStr, activo);
	}

	public void eliminarEmpleado(String id) {
		minimercado.eliminarEmpleado(id);
	}

	public List<Proveedor> obtenerProveedores() {
		return minimercado.getProveedores();
	}

	public Proveedor crearProveedor(String nit, String nombre, String contacto, String email, String telefono) {
		return minimercado.crearProveedor(nit, nombre, contacto, email, telefono);
	}

	public Proveedor buscarProveedor(String nit) {
		return minimercado.buscarProveedor(nit);
	}

	public Proveedor actualizarProveedor(String nit, String nombre, String contacto, String email, String telefono, Boolean activo) {
		return minimercado.actualizarProveedor(nit, nombre, contacto, email, telefono, activo);
	}

	public void eliminarProveedor(String nit) {
		minimercado.eliminarProveedor(nit);
	}
}
