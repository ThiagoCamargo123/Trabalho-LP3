
package bancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class BD {
	private Connection con;
	private Statement stm;
        private Statement stm2;
	private String sgbd;
	public BD(){
		con = null;
		stm = null;
                stm2 = null;
	}
	public void conecta() {
		try {
			Class.forName("org.postgresql.Driver");
			//con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
                        con = DriverManager.getConnection("jdbc:postgresql://ec2-34-195-115-225.compute-1.amazonaws.com:5432/d7gbh9tbts0r7j","zuidrqukwykbwd","8f82c803a029137f140288c3d133e854bdf76d61b948c7ad1365552d7f058d69");
			System.out.println("AcessoBD> Conexão bem sucedida!!");
			stm = con.createStatement();
                        stm2 = con.createStatement();
		}
		catch(ClassNotFoundException | SQLException e){
			System.err.println("Excessão: " + e.toString());
		}
	}

        public void executa(String sql){
    try{
            stm2.executeUpdate(sql); 
    }
    catch(SQLException e){
            System.err.println("Excessão: " + e.toString());
    }
}

public ResultSet consulta(String sql){
	ResultSet rs = null;
	try{
		rs = stm.executeQuery(sql);
	}
	catch (SQLException e) {
		System.err.println("Excessão: " + e.toString());
	}
	return rs;
}

public void desconecta(){
	try{
		stm.close();
		con.close();
	}
	catch(SQLException e){
		System.err.println("Excessão: " + e.toString());
	}
}
public static void main(String[] args){
	System.out.println("AcessoBD> Teste de conexão JDBC...");
	BD acessoBD = new BD();
	acessoBD.conecta();
	String sql;
	sql = "insert into cliente (nome,endereco,rg,telefone,email) values('Lucas Moraes','Rua Brasil, 256','8978','989','lucas@gmail.com')";
	acessoBD.executa(sql);

	sql = "select * from cliente";

	ResultSet rs = acessoBD.consulta(sql);
	String codigo, nome, endereco;
	try{
            while(rs.next()){
		codigo = rs.getString("codigo");
		nome = rs.getString("nome");
		endereco = rs.getString("endereco");
		System.out.println("Codigo: " + codigo);
		System.out.println("Nome: " + nome);
		System.out.println("Endereco: " + endereco);
		System.out.println("");
            }   
        }
        catch(SQLException e){
            System.err.println("Excessão: " + e.toString());
        }
    }
}
