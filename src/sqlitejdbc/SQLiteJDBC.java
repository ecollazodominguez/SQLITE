/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlitejdbc;

import java.sql.*;

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
    public static void main(String[] args) {
       Métodos met = new Métodos();
       // met.connect();
       // met.createNewDatabase("prueba");
//       met.createNewTable("prueba");


        //especificamos las lineas a añadir a la tabla
//        met.insert("6461", "Eduard", 10);
//        met.insert("6057", "Rafi", 9);
        met.selectAll();
    }
    
}
