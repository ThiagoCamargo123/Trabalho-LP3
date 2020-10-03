/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.cliente;

import bancoDados.NovaConecta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivan Farina
 */
public class ClienteDAO implements ICliente{
    
    @Override
    public List lerClientes() {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<MCliente> listaClientes = new ArrayList<>();
        MCliente mc = null;
        try {
            stm = con.prepareStatement("SELECT * FROM cliente");
            rs = stm.executeQuery();
            while (rs.next()) {
                mc = new MCliente();
                mc.setCpf(rs.getString("cpf"));
                mc.setNome(rs.getString("nome"));
                mc.setTelefone(rs.getString("telefone"));
                mc.setRua(rs.getString("rua"));
                mc.setBairro(rs.getString("bairro"));
                mc.setCidade(rs.getString("cidade"));
                mc.setCep(rs.getString("cep"));
                mc.setEmail(rs.getString("email"));
                mc.setSenha(rs.getString("senha"));
                listaClientes.add(mc);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler do SGBD!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm, rs);
            return listaClientes;
        }
    }
    
    public boolean ClienteEspecifico(MCliente mc) {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = con.prepareStatement("SELECT * FROM cliente where cpf=?");
            stm.setString(1, mc.getCpf());
            rs = stm.executeQuery();
            while (rs.next()) {
                if(!rs.getString("nome").isEmpty()){
                    return true;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler do SGBD!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm, rs);
        }
        return false;
    }
    
    public String ClienteSenha(String cpf) {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = con.prepareStatement("SELECT * FROM cliente where cpf=?");
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
    public void cadastrarCliente(MCliente mc) {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("INSERT INTO cliente (cpf,nome,telefone,rua,bairro,cidade,cep,email,senha,estado) VALUES(?,?,?,?,?,?,?,?,?,?)");
            stm.setString(1, mc.getCpf());
            stm.setString(2, mc.getNome());
            stm.setString(3, mc.getTelefone());
            stm.setString(4, mc.getRua());
            stm.setString(5, mc.getBairro());
            stm.setString(6, mc.getCidade());
            stm.setString(7, mc.getCep());
            stm.setString(8, mc.getEmail());
            stm.setString(9, mc.getSenha());
            stm.setString(10, mc.getEstado());
            
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm);
        }
    }

    @Override
    public void alterarCliente(MCliente mc) {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("UPDATE cliente SET nome=?,telefone=?,rua=?,bairro=?,cidade=?,cep=?,email=?,estado=? WHERE cpf = ?");
            stm.setString(1, mc.getNome());
            stm.setString(2, mc.getTelefone());
            stm.setString(3, mc.getRua());
            stm.setString(4, mc.getBairro());
            stm.setString(5, mc.getCidade());
            stm.setString(6, mc.getCep());
            stm.setString(7, mc.getEmail());
            stm.setString(8, mc.getEstado());
            stm.setString(9, mc.getCpf());
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm);
        }
    }
    
    public boolean alterarSenha(MCliente mc) {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("UPDATE cliente SET senha=? WHERE cpf = ?");
            stm.setString(1, mc.getSenha());
            stm.setString(2, mc.getCpf());
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm);
            return true;
        }
    }

    @Override
    public void exluirCliente(MCliente mc) {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("DELETE FROM cliente WHERE cpf = ?");
            stm.setString(1, mc.getCpf());
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm);
        }
    }    
}
