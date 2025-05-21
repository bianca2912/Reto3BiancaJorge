package ClasesPK;

public class PedidoProducto {
    private int idProducto;
    private int unidades;
    private double precio;

    public PedidoProducto(int idProducto, int unidades, double precio) {
        this.idProducto = idProducto;
        this.unidades = unidades;
        this.precio = precio;
    }

    // Getters y setters
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

