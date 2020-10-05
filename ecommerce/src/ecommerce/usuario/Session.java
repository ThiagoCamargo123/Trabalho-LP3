/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.usuario;

import bancoDados.BD;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ivan Farina
 */



//Usar "session.getInstance().getCPF()" para pegar o CPF
public class Session {
   private static Session instance = null;
   private String cpf,tipo;
   
   BD bd = new BD();
   public Session(){
       bd.conecta();
   }

   public void setCPF(String cpf){
      this.cpf=cpf;
   }

   public String getCPF(){
       return this.cpf;
   }
   
   public void settipo(String tipo){
      this.tipo=tipo;
   }

   public String gettipo(){
       return this.tipo;
   }
   
   public String getnome(){
        String sql = "select nome from cliente where cpf = '" + this.cpf + "'";
        ResultSet rs = bd.consulta(sql);
        String nome = null;
	try{
            while(rs.next()){
		nome = rs.getString("nome");
            }   
        }
        catch(SQLException e){
            System.err.println("Excessão: " + e.toString());
        }
        return nome;
   }
   
    public static Session logoff(){
        instance = null;
        return instance;
    }
    public static Session getInstance(){
         if(instance == null){
               instance = new Session();
         }
        return instance;
    }
}
