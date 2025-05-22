package ClasesPK;

import java.util.Date;

/**
 * Clase para los pedidos.
 * 
 * @author [Bianca y Jorge]
 */
public class Pedidos {
	private int idPedido;
	private int idCliente;
	private double precioTotal;
	private String direccionEnvio;
	private Date fecha;

	/**
	 * Constructor con todos los campos.
	 * 
	 * @param idPedido Id del pedido
	 * @param idCliente Id del cliente
	 * @param precioTotal Precio total del pedido
	 * @param direccionEnvio Dirección de envío
	 * @param fecha Fecha del pedido
	 */
	public Pedidos(int idPedido, int idCliente, double precioTotal, String direccionEnvio, Date fecha) {
		super();
		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.precioTotal = precioTotal;
		this.direccionEnvio = direccionEnvio;
		this.fecha = fecha;
	}

	/**
	 * Devuelve el id del pedido.
	 * 
	 * @return idPedido
	 */
	public int getIdPedido() {
		return idPedido;
	}

	/**
	 * Establece el id del pedido.
	 * 
	 * @param idPedido Id a asignar
	 */
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
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
	 * Devuelve el precio total.
	 * 
	 * @return precioTotal
	 */
	public double getPrecioTotal() {
		return precioTotal;
	}

	/**
	 * Establece el precio total.
	 * 
	 * @param precioTotal Precio a asignar
	 */
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	/**
	 * Devuelve la dirección de envío.
	 * 
	 * @return direccionEnvio
	 */
	public String getDireccionEnvio() {
		return direccionEnvio;
	}

	/**
	 * Establece la dirección de envío.
	 * 
	 * @param direccionEnvio Dirección a asignar
	 */
	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	/**
	 * Devuelve la fecha del pedido.
	 * 
	 * @return fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Establece la fecha del pedido.
	 * 
	 * @param fecha Fecha a asignar
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
