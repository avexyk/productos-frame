
package logica;

import java.sql.ResultSet;
import java.sql.SQLException;

import persistencia.Conexion;
import persistencia.ProductoDAO;

public class Producto {
    
    private int id;
    private String nombre;
    private int cantidad;
    private long precio;

    // Constructor para el frame FIBuscarProducto
    public Producto() {
        
    }
    
    // Constructor para el frame FIConsultarProducto
    public Producto(int id) {
        this.id = id;
    }
    
    // Constructor para el frame FIAgregarProducto
    public Producto(int id, String nombre, int cantidad, long precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public int getCantidad() {
        return this.cantidad;
    }

    public long getPrecio() {
        return this.precio;
    } 
    
    public String insertar() {
        Conexion conexion = new Conexion();
        ProductoDAO productoDAO = new ProductoDAO(this.id, this.nombre, this.cantidad, this.precio);
        return conexion.ejecutar(productoDAO.insertar());
    }
    
    public String eliminar() {
        Conexion conexion = new Conexion();
        ProductoDAO productoDAO = new ProductoDAO(this.id);
        return conexion.ejecutar(productoDAO.eliminar());
    }
    
    public boolean consultar() {
        Conexion conexion = new Conexion();
        ProductoDAO productoDAO = new ProductoDAO(this.id);
        ResultSet resultado = conexion.consultar(productoDAO.consultar());
        try {
            if (resultado.next()) {
                this.nombre = resultado.getString("nombre");
                this.cantidad = resultado.getInt("cantidad");
                this.precio = resultado.getLong("precio");
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public String actualizar() {
        Conexion conexion = new Conexion();
        ProductoDAO productoDAO = new ProductoDAO(this.id, this.nombre, this.cantidad, this.precio);
        return conexion.ejecutar(productoDAO.actualizar());
    }
    
    public String[][] buscar(String filtro) {
        Conexion con = new Conexion();
        ProductoDAO productoDAO = new ProductoDAO();
        ResultSet resultado = con.consultar(productoDAO.buscar(filtro));
        String[][] datos = null;
        try {
            resultado.last();
            datos = new String[resultado.getRow()][4];
            resultado.beforeFirst();
            int i = 0;
            while (resultado.next()) {                
                datos[i][0] = resultado.getString("id");
                datos[i][1] = resultado.getString("nombre");
                datos[i][2] = resultado.getString("cantidad");
                datos[i][3] = resultado.getString("precio");
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datos;
    }

}
