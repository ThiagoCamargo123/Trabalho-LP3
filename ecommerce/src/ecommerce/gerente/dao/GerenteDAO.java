/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.gerente.dao;

import bancoDados.NovaConecta;
import ecommerce.estoquista.dao.MEstoquista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Thiago
 */
public class GerenteDAO implements IGerente{

    @Override
    public boolean incluirGerente(MGerente gerente) {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        
        try {
            stm = con.prepareStatement("INSERT INTO gerente (id,nome,cpf,senha) VALUES('"+gerente.getLogin()+"','"+gerente.getNome()+"','"+gerente.getCpf()+"','"+gerente.getSenha()+"')");
            stm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, gerente.getNome()+ " Salvo com Sucesso" );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
        
        return true;
    }

    @Override
    public boolean atualizarGerente(MGerente gerente) {
        
        
        return true;
    }

    @Override
    public String buscarSenha(String cpf) {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = con.prepareStatement("SELECT * FROM gerente where cpf=?");
            stm.setString(1, cpf);
            rs = stm.executeQuery();
            while (rs.next()) {
                if(!rs.getString("senha").isEmpty()){
                    return rs.getString("senha");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler do SGBD!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm, rs);
        }
        return null;
    }

    @Override
    public List<MGerente> listar() {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<MGerente> listaGerentes = new ArrayList<>();
        MGerente gerente;
        
        try {
            stm = con.prepareStatement("select * from gerente");
            rs = stm.executeQuery();
            while (rs.next()) {
                gerente = new MGerente();
                gerente.setCpf(rs.getString("cpf"));
                gerente.setNome(rs.getString("nome"));
                gerente.setLogin(rs.getInt("id"));
                gerente.setSenha(rs.getString("senha"));
                listaGerentes.add(gerente);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler do SGBD!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm, rs);
            return listaGerentes;
        }
    }
    
}
