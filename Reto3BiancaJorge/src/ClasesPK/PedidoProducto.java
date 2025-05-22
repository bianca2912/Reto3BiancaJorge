package ClasesPK;

/**
 * Clase para representar un producto dentro de un pedido.
 * 
 * @author [Bianca y Jorge]
 */
public class PedidoProducto {
    private int idProducto;
    private int unidades;
    private double precio;

    /**
     * Constructor con id del producto, unidades y precio.
     * 
     * @param idProducto Id del producto
     * @param unidades Unidades del producto
     * @param precio Precio del producto
     */
    public PedidoProducto(int idProducto, int unidades, double precio) {
        this.idProducto = idProducto;
        this.unidades = unidades;
        this.precio = precio;
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
     * Devuelve las unidades.
     * 
     * @return unidades
     */
    public int getUnidades() {
        return unidades;
    }

    /**
     * Establece las unidades.
     * 
     * @param unidades Unidades a asignar
     */
    public void setUnidades(int unidades) {
        this.unidades = unidades;
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
}
