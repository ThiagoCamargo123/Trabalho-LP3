/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.estoquista.dao;

import bancoDados.NovaConecta;
import ecommerce.produto.dao.MProduto;
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
                estoquista.setId(rs.getInt("id"));
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

    @Override
    public void atualizarEstoquista(MEstoquista estoquista) {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        try {
            if(estoquista.getSenhaAcesso() == 0){
                stm = con.prepareStatement("UPDATE estoquista SET nome=?,cpf=?,numerocontrato=? WHERE cpf = ?");
                stm.setString(1, estoquista.getNome());
                stm.setString(2, estoquista.getCpf());
                stm.setInt(3, estoquista.getNumeroContrato());
                stm.setString(4, estoquista.getCpfAntigo());
                stm.executeUpdate();
            }else{
                stm = con.prepareStatement("UPDATE estoquista SET nome=?,cpf=?,numerocontrato=?,senha_acesso=? WHERE cpf = ?");
                stm.setString(1, estoquista.getNome());
                stm.setString(2, estoquista.getCpf());
                stm.setInt(3, estoquista.getNumeroContrato());
                stm.setInt(4, estoquista.getSenhaAcesso());
                stm.setString(5, estoquista.getCpfAntigo());
            }
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm);
        }
    }

    @Override
    public void excluirEstoquista(String cpf,String nome) {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        
        try {
            stm = con.prepareStatement("DELETE from estoquista where cpf = '"+cpf+"'");
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, nome+ " Excluido com Sucesso" );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
    }
    
}
