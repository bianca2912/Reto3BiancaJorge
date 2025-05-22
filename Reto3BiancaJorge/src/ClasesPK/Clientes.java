package ClasesPK;

/**
 * Clase para los clientes.
 * 
 * @author [Bianca y Jorge]
 */
public class Clientes {
	private int idCliente;
	private String nombre;
	private String direccion;
	private int codigo;

	/**
	 * Constructor con nombre, dirección y código.
	 * 
	 * @param nombre Nombre del cliente
	 * @param direccion Dirección del cliente
	 * @param codigo Código del cliente
	 */
	public Clientes(String nombre, String direccion, int codigo) {
	    this.nombre = nombre;
	    this.direccion = direccion;
	    this.codigo = codigo;
	}

	/**
	 * Devuelve el id del cliente.
	 * 
	 * @return idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}

	/**
	 * Establece el id del cliente.
	 * 
	 * @param idCliente Id a asignar
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * Devuelve el nombre.
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre.
	 * 
	 * @param nombre Nombre a asignar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve la dirección.
	 * 
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Establece la dirección.
	 * 
	 * @param direccion Dirección a asignar
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Devuelve el código.
	 * 
	 * @return codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Establece el código.
	 * 
	 * @param codigo Código a asignar
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Devuelve los datos del cliente como texto.
	 * 
	 * @return Datos del cliente
	 */
	@Override
	public String toString() {
		return "Clientes [idCliente=" + idCliente + ", nombre=" + nombre + ", direccion=" + direccion + ", codigo=" + codigo + "]";
	}
}
