/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.usuario;

/**
 *
 * @author Ivan Farina
 */



//Usar "session.getInstance().getCPF()" para pegar o CPF
public class session {
   private static session instance = null;
   private String cpf,tipo;
   

   public session(){
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
   
   public static session getInstance(){
         if(instance == null){
               instance = new session();
         }
        return instance;
   }
}
