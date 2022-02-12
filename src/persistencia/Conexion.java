
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    
    private Statement statement;
    private Connection connection;
    private String jdbc;
    private String ruta;
    private String usuario;
    private String contra;
    
    public Conexion() {
        this.connection = null;
        this.statement = null;
        // Para la versión 5 del drver que incluye netbenas en /ide/modules/ext/ se usa el la anterior sintaxis:
        // this.jdbc = "com.mysql.jdbc.Driver";
        this.jdbc = "com.mysql.jdbc.Driver";
        this.ruta = "jdbc:mysql://localhost:3306/productosframe?serverTimezone=UTC";
        this.usuario = "USER";
        this.contra = "PASSWORD";
    }
    
    //  Crea una conexión a la base de datos
    private void abrirConexion() {
        try {
            Class.forName(this.jdbc);
            this.connection = DriverManager.getConnection(this.ruta, this.usuario, this.contra);
            //  Crea un objeto que permite enviar sentencias SQL
            this.statement = this.connection.createStatement();
        } catch (SQLException e) {
            // Se produce si no es posible realizar una conexión a la base de datos
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // Se produce si no encuentra la clase para crear conexión a la base de datos
            // com.mysqljdbc.Driver
            e.printStackTrace();
        }
    }
    
    // Permite enviar una sentencia SQL que recibe como parámetro
    // INSERT, UPDATE, DELETE
    public String ejecutar(String sentencia) {
        try {
            this.abrirConexion();
            // abrir conexión mediante executeUpdate
            this.statement.executeUpdate(sentencia);
            return "Operación exitosa";
        } catch (SQLException e) {
            // Controla los siguientes casos:
            // - Agrega registro cuya id ya existe
            // - Eliminación registro que no existe
            // - Actualización de un registro que no existe
            // - Error sintaxis de la sentencia
            // - Sentencia tabla que no existe
            // - Sentencia columna que no existe
            return e.toString();
        }
    }
    
    // Envia una sentencia SQL que recibe como parámetro
    // SELECT
    public ResultSet consultar(String sentencia) {
        ResultSet resultado = null;
        try {
            this.abrirConexion();
            // Abrir conexión mediante executeQuery
            resultado = statement.executeQuery(sentencia);
        } catch (SQLException e) {
            // Controla los siguientes casos:
            // - Error de sintaxis
            // - Sentencia tabla que no existe
            // - Sentencia columna que no existe
            e.printStackTrace();
        }
        return  resultado;
    }
    
}
