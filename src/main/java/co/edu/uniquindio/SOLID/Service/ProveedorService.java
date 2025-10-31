package co.edu.uniquindio.SOLID.Service;

import co.edu.uniquindio.SOLID.Model.Minimercado;
import co.edu.uniquindio.SOLID.Model.Proveedor;
import java.util.List;

public class ProveedorService {
    private final Minimercado minimercado;

    public ProveedorService() {
        this.minimercado = Minimercado.getInstancia();
    }

    public List<Proveedor> obtenerProveedores() {
        return minimercado.getProveedores();
    }

    public Proveedor crearProveedor(String nit, String nombre, String contacto, String email, String telefono) {
        if (buscarProveedor(nit) != null) {
            throw new IllegalArgumentException("Ya existe un proveedor con ese NIT");
        }
        Proveedor proveedor = new Proveedor(nit, nombre, contacto, email, telefono);
        minimercado.getProveedores().add(proveedor);
        return proveedor;
    }

    public Proveedor buscarProveedor(String nit) {
        for (Proveedor p : minimercado.getProveedores()) {
            if (p.getNit().equals(nit)) return p;
        }
        return null;
    }

    public Proveedor actualizarProveedor(String nit, String nombre, String contacto, String email, String telefono, Boolean activo) {
        Proveedor p = buscarProveedor(nit);
        if (p == null) {
            throw new IllegalArgumentException("Proveedor no encontrado: " + nit);
        }
        if (nombre != null) p.setNombre(nombre);
        if (contacto != null) p.setContacto(contacto);
        if (email != null) p.setEmail(email);
        if (telefono != null) p.setTelefono(telefono);
        if (activo != null) { if (activo) p.activar(); else p.inactivar(); }
        return p;
    }

    public void eliminarProveedor(String nit) {
        Proveedor p = buscarProveedor(nit);
        if (p == null) {
            throw new IllegalArgumentException("Proveedor no encontrado: " + nit);
        }
        minimercado.getProveedores().remove(p);
    }
}
