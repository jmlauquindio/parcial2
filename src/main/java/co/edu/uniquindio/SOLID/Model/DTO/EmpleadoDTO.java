package co.edu.uniquindio.SOLID.Model.DTO;

public class EmpleadoDTO {
	private String id;
	private String nombre;
	private String rol;
	private boolean activo;

	public EmpleadoDTO() {}

	public EmpleadoDTO(String id, String nombre, String rol, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.rol = rol;
		this.activo = activo;
	}

	public String getId() { return id; }
	public void setId(String id) { this.id = id; }

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public String getRol() { return rol; }
	public void setRol(String rol) { this.rol = rol; }

	public boolean isActivo() { return activo; }
	public void setActivo(boolean activo) { this.activo = activo; }
}
