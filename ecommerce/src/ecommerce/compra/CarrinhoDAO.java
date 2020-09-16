/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.compra;

import bancoDados.NovaConecta;
import ecommerce.produto.ProdutoDAO;
import ecommerce.usuario.session;
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
public class CarrinhoDAO implements ICarrinho{

    @Override
    public List lerCarrinho() {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<MCarrinho> listaCarrinho = new ArrayList<>();
        MCarrinho mc = null;
        try {
            stm = con.prepareStatement("select id_produto AS ID, SUM(quant) AS Quantidade, SUM(preco_total) AS Preco from carrinho where cpf_cliente = '"+session.getInstance().getCPF()+"' AND aberto = 's' group by id_produto");
            rs = stm.executeQuery();
            while (rs.next()) {
                mc = new MCarrinho();
                mc.setId_produto(rs.getInt("ID"));
                mc.setQuant(rs.getInt("Quantidade"));
                mc.setPreco_total(rs.getDouble("Preco"));
                listaCarrinho.add(mc);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler do SGBD!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm, rs);
            return listaCarrinho;
        }
    }
    
    public boolean ProdutoCarrinho(MCarrinho mc){
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = con.prepareStatement("SELECT * FROM produto where id = ?");
            stm.setInt(1, mc.getId_produto());
            rs = stm.executeQuery();
            int id=0;
            while (rs.next()) {
                id=rs.getInt("id");
                if(id==0){
                    return false;
                }
                else{
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

    @Override
    public boolean addCarrinho(MCarrinho c) {
        ProdutoDAO pdao = new ProdutoDAO();
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        int id = c.getId_produto();
        if(pdao.ProdutoExiste(id)){
            try {
                stm = con.prepareStatement("INSERT INTO Carrinho (id_produto,cpf_cliente,quant,aberto,preco_total,preco_unit) VALUES(?,?,?,?,?,?)");
                stm.setInt(1, c.getId_produto());
                stm.setString(2, c.getCpf_Cliente());
                stm.setInt(3, c.getQuant());
                stm.setString(4, c.getAberto());
                stm.setDouble(5, c.getPreco_total());
                stm.setDouble(6, c.getPreco_unit());            
                stm.executeUpdate();
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar!!" + ex);
                return false;
            } finally {
                NovaConecta.closeConnection(con, stm);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Produto Inválido!!");
        }
        return false;
    }

    @Override
    public void atualizaCarrinho(MCarrinho c) {
        
    }

    @Override
    public void excluirCarrinho(MCarrinho c) {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("DELETE FROM carrinho where id_produto = ? aberto = 's' cpf_cliente = ?");
            stm.setInt(1, c.getId_produto());
            stm.setString(2, c.getCpf_Cliente());
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm);
        }
    }
    
}
