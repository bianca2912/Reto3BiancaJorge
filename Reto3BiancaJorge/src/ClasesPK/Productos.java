package ClasesPK;

/**
 * Clase para los productos.
 * 
 * Representa un producto con información como categoría, nombre, precio,
 * descripción, color, talla y stock.
 * 
 * @author [Bianca y Jorge]
 */
public class Productos {
	private int idProducto;
	private int idCategoria;
	private String nombre;
	private double precio;
	private String descripcion;
	private String color;
	private String talla;
	private int stock;

	/**
	 * Constructor con categoría.
	 * 
	 * @param idCategoria Id de la categoría
	 * @param nombre Nombre del producto
	 * @param precio Precio del producto
	 * @param descripcion Descripción del producto
	 * @param color Color del producto
	 * @param talla Talla del producto
	 * @param stock Unidades disponibles
	 */
	public Productos(int idCategoria, String nombre, double precio, String descripcion, String color,
			String talla, int stock) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.color = color;
		this.talla = talla;
		this.stock = stock;
	}

	/**
	 * Constructor sin categoría.
	 * 
	 * @param nombre Nombre del producto
	 * @param precio Precio del producto
	 * @param descripcion Descripción del producto
	 * @param color Color del producto
	 * @param talla Talla del producto
	 * @param stock Unidades disponibles
	 */
	public Productos(String nombre, double precio, String descripcion, String color,
			String talla, int stock) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.color = color;
		this.talla = talla;
		this.stock = stock;
	}

	/**
	 * Devuelve el id del producto.
	 * 
	 * @return idProducto
	 */
	public int getIdProducto() {
		return idProducto;
	}

	/**
	 * Establece el id del producto.
	 * 
	 * @param idProducto Id a asignar
	 */
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
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
	 * @param idCategoria Id de la categoría
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

	/**
	 * Devuelve el precio.
	 * 
	 * @return precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio.
	 * 
	 * @param precio Precio a asignar
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Devuelve la descripción.
	 * 
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción.
	 * 
	 * @param descripcion Descripción a asignar
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Devuelve el color.
	 * 
	 * @return color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Establece el color.
	 * 
	 * @param color Color a asignar
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Devuelve la talla.
	 * 
	 * @return talla
	 */
	public String getTalla() {
		return talla;
	}

	/**
	 * Establece la talla.
	 * 
	 * @param talla Talla a asignar
	 */
	public void setTalla(String talla) {
		this.talla = talla;
	}

	/**
	 * Devuelve el stock.
	 * 
	 * @return stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * Establece el stock.
	 * 
	 * @param stock Unidades disponibles
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
}
