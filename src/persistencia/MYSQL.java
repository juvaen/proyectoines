/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maslu
 */
// ************************************************************************
// Esto crea la conexión a la base de datos
// ************************************************************************
public class MYSQL {

    Connection con = null;

    public Connection getConnection() {
        try {
            String ruta = "jdbc:mysql://";
            String servidor = "localhost" + "/";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(ruta.concat(servidor).concat("registroempleados").concat("?autoReconnect=true&useSSL=false"), "root", "admin");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MYSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return con;
        }
    }
}
