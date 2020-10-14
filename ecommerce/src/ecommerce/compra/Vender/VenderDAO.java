package ecommerce.compra.Vender;


import bancoDados.NovaConecta;
import ecommerce.prateleira.dao.PrateleiraDAO;
import ecommerce.produto.dao.MProduto;
import ecommerce.usuario.Session;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ivan Farina
 */
public class VenderDAO implements IVender{
    @Override
    public void incluirVenda(MVender mv) {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("INSERT INTO compra (id_produto,cpf_cliente,data_compra,hora_compra,valor_total,quantidade) VALUES (?,?,?,?,?,?)");
            stm.setInt(1, mv.getId_produto());
            stm.setString(2, mv.getCpf_Cliente());
            stm.setString(3, mv.getDataLocal());
            stm.setString(4, mv.getHorarioLocal());
            stm.setDouble(5, mv.getPreco_total());
            stm.setInt(6, mv.getQuant());            
            stm.executeUpdate();
            
            stm = con.prepareStatement("select produto_prateleira.id_produto,produto_prateleira.id_prateleira,volume from produto_prateleira \n" +
                                        "inner join produto on produto.id = produto_prateleira.id_produto\n" +
                                        "where id_produto = "+mv.getId_produto()+" and produto_prateleira.estocado = 'SIM' \n" +
                                        "order by id_prateleira");
            ResultSet rs = stm.executeQuery();
            List<MProduto> produtos = new ArrayList();
            while(rs.next()){
                MProduto produto = new MProduto();
                produto.setId(rs.getInt("id_produto"));
                produto.setIdPrateleira("id_prateleira");
                produto.setVolume(rs.getDouble("volume"));
                produtos.add(produto);
                
                if(produtos.size() < 1){
                    PrateleiraDAO prateleira = new PrateleiraDAO();
                    prateleira.mudarStatusParaVendidoo(produto);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao comprar!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm);
        }
    }
    
    public void alteraAbertoAtualizado(MVender mv){
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("UPDATE carrinho SET aberto='n' WHERE id_produto = ? AND aberto = 's' AND cpf_cliente = '"+Session.getInstance().getCPF()+"'");
            stm.setInt(1, mv.getId_produto());
            stm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao comprar!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm);
        }
    }
    
    public void atualizaEstoque(int id,int estocado){
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("UPDATE produto SET estocado=? WHERE id = ?");
            stm.setInt(1, estocado);
            stm.setInt(2, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar estoque!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm);
        }
    }
}
