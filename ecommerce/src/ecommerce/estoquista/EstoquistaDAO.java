/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.estoquista;

import bancoDados.NovaConecta;
import ecommerce.produto.MProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class EstoquistaDAO implements IEstoquista{

    @Override
    public List lerEstoquistas() {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<MEstoquista> listaEstoquistas = new ArrayList<>();
        MEstoquista estoquista = null;
        
        try {
            stm = con.prepareStatement("select * from estoquista");
            rs = stm.executeQuery();
            while (rs.next()) {
                estoquista = new MEstoquista();
                estoquista.setCpf(rs.getString("cpf"));
                estoquista.setNome(rs.getString("nome"));
                estoquista.setNumeroContrato(rs.getInt("numerocontrato"));
                listaEstoquistas.add(estoquista);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler do SGBD!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm, rs);
            return listaEstoquistas;
        }
    }

    @Override
    public void cadastrarEstoquista(MEstoquista estoquista) {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        
        try {
            stm = con.prepareStatement("INSERT INTO estoquista VALUES('"+estoquista.getId()+"','"+estoquista.getCpf()+"','"+estoquista.getNome()+"','"+estoquista.getNumeroContrato()+"','"+estoquista.getCpfGerente()+"','"+estoquista.getSenhaAcesso()+"')");
            stm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, estoquista.getNome()+ " Salvo com Sucesso" );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
    }
    
}
