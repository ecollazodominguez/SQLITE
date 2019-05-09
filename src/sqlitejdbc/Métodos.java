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
 */
public class Métodos {
    
    /**
     * Conectar a DB, haciendo clase interna
     */
    public static Connection connect() {
        
        Connection conn = null;
        try {
            // parámetro DB
            String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/ecollazodominguez/NetBeansProjects/SQLiteJDBC/db/chinook.db";
            // Creando conexión a la DB
            conn = DriverManager.getConnection(url);
            
            System.out.println("La conexión a SQLite ha sido establecida");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return conn;
    }
    
    /**
     * Conectar y crear database
     *
     * @param fileName nombre de la database
     */
    public static void createNewDatabase(String fileName) {
 
        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/ecollazodominguez/NetBeansProjects/SQLiteJDBC/db/" + fileName+ ".db";
 
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("Una nueva DB ha sido creada");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Crear una tabla en la DB
     *
     */
    public static void createNewTable(String fileName) {
        // SQLite connection string
        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/ecollazodominguez/NetBeansProjects/SQLiteJDBC/db/" + fileName+ ".db";
        
        // Para crear una tabla usamos esta sintaxis
        String sql = "CREATE TABLE IF NOT EXISTS DAM1 (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	nota integer\n"
                + ");";
        
        // Conectamos a la DB
        try (Connection conn = DriverManager.getConnection(url);
         // Creamos un "Statement" que cogerá la sintaxis sql
                Statement stmt = conn.createStatement()) {
            // Creamos la tabla
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insert(String id, String name, int nota) {
        //Sintaxis del insert
        String sql = "INSERT INTO DAM1(id,name,nota) VALUES(?,?,?)";
        Connection conn = null;
        
        try {
            // parámetro DB
            String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/ecollazodominguez/NetBeansProjects/SQLiteJDBC/db/prueba.db";
            // Creando conexión a la DB
            conn = DriverManager.getConnection(url);
            
            System.out.println("La conexión a SQLite ha sido establecida");
            
            //añadimos los parametros
            PreparedStatement pstmt = conn.prepareStatement(sql); {
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, nota);
            pstmt.executeUpdate();

    }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
}
    }
}
