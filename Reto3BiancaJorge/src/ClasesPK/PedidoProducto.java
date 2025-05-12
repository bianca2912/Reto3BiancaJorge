package ClasesPK;

public class PedidoProducto {
	private int idPedidoProducto;
	private int idPedido;
	private int idProducto;
	private int unidades;
	private double precio;
	public PedidoProducto(int idPedidoProducto, int idPedido, int idProducto, int unidades, double precio) {
		super();
		this.idPedidoProducto = idPedidoProducto;
		this.idPedido = idPedido;
		this.idProducto = idProducto;
		this.unidades = unidades;
		this.precio = precio;
	}
	public int getIdPedidoProducto() {
		return idPedidoProducto;
	}
	public void setIdPedidoProducto(int idPedidoProducto) {
		this.idPedidoProducto = idPedidoProducto;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
