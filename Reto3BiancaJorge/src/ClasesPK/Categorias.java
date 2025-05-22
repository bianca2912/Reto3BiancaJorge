package ClasesPK;

/**
 * Clase para las categorías.
 * 
 * @author [Bianca y Jorge]
 */
public class Categorias {
	private int idCategoria;
	private String nombre;

	/**
	 * Constructor con nombre.
	 * 
	 * @param nombre Nombre de la categoría
	 */
	public Categorias(String nombre) {
		super();
		this.nombre = nombre;
	}

	/**
	 * Devuelve el id de la categoría.
	 * 
	 * @return idCategoria
	 */
	public int getIdCategoria() { 
		return idCategoria;
	}

	/**
	 * Establece el id de la categoría.
	 * 
	 * @param idCategoria Id a asignar
	 */
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
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
}
