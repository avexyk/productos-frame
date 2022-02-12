
package persistencia;

public class ProductoDAO {
    
    private int id;
    private String nombre;
    private int cantidad;
    private long precio;

    // Constructor para la clase Producto pedido del frame FIBuscarProducto
    public ProductoDAO() {
        
    }
    
    public ProductoDAO(int id) {
        this.id = id;
    }
    
    // Constructor para la clase Producto pedido del frame FIAgregarProducto
    public ProductoDAO(int id, String nombre, int cantidad, long precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    public String insertar() {
        return "INSERT INTO producto (id, nombre, cantidad, precio) VALUES ('"+this.id+"', '"+this.nombre+"', '"+this.cantidad+"', '"+this.precio+"')";
    }
    
    public String consultar() {
        return "SELECT * FROM producto WHERE id='"+this.id+"'";
    }
    
    public String actualizar() {
        return "UPDATE producto SET nombre='"+this.nombre+"', cantidad='"+this.cantidad+"', precio='"+this.precio+"' WHERE id='"+this.id+"'";
    }
    
    public String buscar(String filtro) {
        return "SELECT * FROM producto WHERE nombre LIKE '"+filtro+"%'";
    }
    
    public String eliminar() {
        return "DELETE FROM producto WHERE id='"+this.id+"'";
    }
}
