/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDados;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan Farina
 */
public class NovaConecta {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://ec2-34-195-115-225.compute-1.amazonaws.com:5432/d7gbh9tbts0r7j";
    private static final String USER = "zuidrqukwykbwd"; // alterar o login.
    private static final String PASS = "8f82c803a029137f140288c3d133e854bdf76d61b948c7ad1365552d7f058d69"; // alterar a senha.
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASS);
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }
    }
    public static void closeConnection(Connection con) {
        try {
            if (con != null) { con.close(); }
        } catch (SQLException ex) {
            Logger.getLogger(NovaConecta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void closeConnection(Connection con, PreparedStatement stm) {
        closeConnection(con);
        try {
            if (stm != null) {stm.close();}
        } catch (SQLException ex) {
            Logger.getLogger(NovaConecta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stm, ResultSet rs) {
        closeConnection(con, stm);
        try {
            if (rs != null) {rs.close(); }
        } catch (SQLException ex) {
            Logger.getLogger(NovaConecta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
