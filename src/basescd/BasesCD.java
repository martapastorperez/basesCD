
package basescd;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class BasesCD {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       InterfaceSQlite miBD=new InterfaceSQlite("jdbc:sqlite:clase.db");
       miBD.conectar();
       if (miBD.conectar()){
           System.out.println("Conectado");
       }else{
           System.out.println("Hubo un problema");
       }
//       miBD.insertar(Integer.parseInt(Integer.parseInt(JOptionPane.showInputDialog("numero")),JOptionPane.showInputDialog("Nombre"));
//       miBD.consultar();
//       miBD.borrar();
//       miBD.cerrar();
      int op=0;
    
      do{
  
            try{
        op = Integer.parseInt(JOptionPane.showInputDialog("***MENU*** \n1. Insertar \n2. Borrar \n3. Consultar \n4. cerrar conexion \n5.Salir "));
       
            }catch(Exception e){
                System.out.println(e.getMessage());
                op = 0;
            }
                switch (op) {

            case 1:
               miBD.insertar(Integer.parseInt(JOptionPane.showInputDialog("numero")),JOptionPane.showInputDialog("nombre"));;
                break;
            case 2:
                 miBD.borrar();
                break;
            case 3:
               miBD.consultar();
                break;
            case 4:
                miBD.cerrar();
                break;
          
            case 5:
                System.exit(0);
        
                }
    }while (op<5);
}
    }
    

