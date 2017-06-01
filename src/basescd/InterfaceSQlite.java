
package basescd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class InterfaceSQlite {
    private String url="jdbc:sqlite:clase.db";
    Connection connection;

    public InterfaceSQlite(Connection connection) {
        this.connection = connection;
    }
    
    
    

    public InterfaceSQlite(String url) {
        this.url = url;
       // this.connection = connection;
    }
/**
 * Se conecta con la base de datos sqlite si conecta devuelve true si no false
 * @return
 * @throws ClassNotFoundException
 * @throws SQLException 
 */

    public boolean conectar() throws ClassNotFoundException, SQLException{
        //url="jdbc:sqlite:clase.db";
      // Class.forName("org.sqlite.JDBC");
       try{
         connection = DriverManager.getConnection(url);
         return true;
       }catch(SQLException e){
      return false;
    }
    }
    /**
     * Inserta en la tabla clase numero y nombre del alumno
     * @param numero
     * @param Nombre
     * @throws SQLException 
     */
    public void insertar(int numero, String Nombre) throws SQLException{
        String inser="insert into clase values("+numero+",'"+Nombre+"')";
        Statement statement = connection.createStatement();
        
         statement.executeUpdate("drop table if exists clase");
        statement.executeUpdate("create table clase(numero Integer,Nombre String)");
        statement.executeUpdate("insert into clase values(23, 'Laura')");
        statement.executeUpdate("insert into clase values(14, 'Diego')");
         statement.executeUpdate(inser);
       // statement.executeUpdate("insert into clase values("+Integer.parseInt(JOptionPane.showInputDialog("numero"))+","+JOptionPane.showInputDialog("Nombre")+")");
       ResultSet rs = statement.executeQuery("select * from clase");
        
    }
   /**
    * Borra por numero del alumno
    * @throws SQLException 
    */
    public void borrar() throws SQLException{
         Statement statement = connection.createStatement();
         statement.executeUpdate("delete from clase where numero="+JOptionPane.showInputDialog("numero"));
    }
    /**
     * Realiza consultas por nombre o numero
     * @throws SQLException 
     */
    public void consultar() throws SQLException{
         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery("select * from clase");
          while(rs.next())
      {
        System.out.println("Nombre = " + rs.getString("Nombre"));
        System.out.println("numero = " + rs.getInt("numero"));
      }
    }
    /**
     * Cierrre de la conexion a la base
     */
    public void cerrar(){
      try
      {
        if(connection != null)
          connection.close();
      }
      catch(SQLException e)
      {
        // connection close failed.
        System.err.println(e);
      }
}
}