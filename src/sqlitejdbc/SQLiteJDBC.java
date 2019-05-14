/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlitejdbc;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ecollazodominguez
 * sqltutorial.net para tutoriales
 * sqliteonline.com para visualizar el .db
 */
public class SQLiteJDBC {
    
     /**
     * Conectar a DB, haciendo clase interna
     */

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
       Métodos met = new Métodos();
       int opcion;
       do{
       opcion=Integer.parseInt(JOptionPane.showInputDialog("SQLITEJDBC"
                                              +"\n1- Crear BD"
                                              +"\n2- Crear tabla(dam1)"
                                              +"\n3- Crear linea(dam1)"
                                              +"\n4- Consulta de tabla general(dam1)"
                                              +"\n5- Actualizar linea(dam1)"
                                              +"\n6- Borrar linea(dam1)"));
       
           switch (opcion){
               case 1:
                   Métodos.createNewDatabase(JOptionPane.showInputDialog("Nombra da DB"));
                   break;
               case 2:
                   Métodos.createNewTable(JOptionPane.showInputDialog("Nombra da DB"));
                   break;
               case 3:
                   met.insert(JOptionPane.showInputDialog("ID alumno"), JOptionPane.showInputDialog("Nome alumno"), Integer.parseInt(JOptionPane.showInputDialog("Nota")));
                   break;
               case 4:
                   met.selectAll();
                   break;
               case 5:
                   met.update(JOptionPane.showInputDialog("ID alumno a cambiar"), JOptionPane.showInputDialog("Nome alumno nuevo"), Integer.parseInt(JOptionPane.showInputDialog("Nota nueva")));
                   break;
               case 6:
                   met.delete(JOptionPane.showInputDialog("ID alumno a borrar"));
                   break;
           }
       }while(opcion>6);

    }
}
