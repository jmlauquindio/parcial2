package co.edu.uniquindio.SOLID.Service.Fachadas;

import co.edu.uniquindio.SOLID.Model.Empleado;
import co.edu.uniquindio.SOLID.Model.Proveedor;
import co.edu.uniquindio.SOLID.Service.EmpleadoService;
import co.edu.uniquindio.SOLID.Service.ProveedorService;
import java.util.List;


public class EmpresaAdminFacade {
	private final EmpleadoService empleadoService;
	private final ProveedorService proveedorService;

	public EmpresaAdminFacade() {
		empleadoService = new EmpleadoService();
		proveedorService = new ProveedorService();
	}

	public List<co.edu.uniquindio.SOLID.Model.DTO.EmpleadoDTO> obtenerEmpleados() {
		return empleadoService.obtenerEmpleados();
	}

	public co.edu.uniquindio.SOLID.Model.DTO.EmpleadoDTO crearEmpleado(co.edu.uniquindio.SOLID.Model.DTO.EmpleadoDTO dto) {
		return empleadoService.crearEmpleado(dto);
	}

	public co.edu.uniquindio.SOLID.Model.DTO.EmpleadoDTO buscarEmpleado(String id) {
		return empleadoService.buscarEmpleado(id);
	}

	public co.edu.uniquindio.SOLID.Model.DTO.EmpleadoDTO actualizarEmpleado(co.edu.uniquindio.SOLID.Model.DTO.EmpleadoDTO dto) {
		return empleadoService.actualizarEmpleado(dto);
	}

	public co.edu.uniquindio.SOLID.Model.DTO.EmpleadoDTO activarEmpleado(String id) {
		return empleadoService.activarEmpleado(id);
	}

	public co.edu.uniquindio.SOLID.Model.DTO.EmpleadoDTO inactivarEmpleado(String id) {
		return empleadoService.inactivarEmpleado(id);
	}

	public void eliminarEmpleado(String id) {
		empleadoService.eliminarEmpleado(id);
	}

	public List<Proveedor> obtenerProveedores() {
		return proveedorService.obtenerProveedores();
	}

	public Proveedor crearProveedor(String nit, String nombre, String contacto, String email, String telefono) {
		return proveedorService.crearProveedor(nit, nombre, contacto, email, telefono);
	}

	public Proveedor buscarProveedor(String nit) {
		return proveedorService.buscarProveedor(nit);
	}

	public Proveedor actualizarProveedor(String nit, String nombre, String contacto, String email, String telefono, Boolean activo) {
		return proveedorService.actualizarProveedor(nit, nombre, contacto, email, telefono, activo);
	}

	public void eliminarProveedor(String nit) {
		proveedorService.eliminarProveedor(nit);
	}
}
