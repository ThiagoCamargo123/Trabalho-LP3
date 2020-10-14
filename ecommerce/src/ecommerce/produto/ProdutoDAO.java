/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.produto;

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
public class ProdutoDAO implements IProduto{

    @Override
    public List lerProduto() {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<MProduto> listaProdutos = new ArrayList<>();
        MProduto mp = null;
        try {
            stm = con.prepareStatement("select * from produto inner join tipoProduto on (produto.tipo = tipoProduto.tipo_id)");
            rs = stm.executeQuery();
            while (rs.next()) {
                mp = new MProduto();
                mp.setAltura(rs.getDouble("altura"));
                mp.setDescricao(rs.getString("descricao_produto"));
                mp.setEstocado(rs.getInt("estocado"));
                mp.setId(rs.getInt("id"));
                mp.setLargura(rs.getDouble("largura"));
                mp.setNaoestocado(rs.getInt("naoestocado"));
                mp.setPreco(rs.getDouble("preco"));
                mp.setPreco_final(rs.getDouble("preco_final"));
                mp.setProfundidade(rs.getDouble("profundidade"));
                mp.setTipo(rs.getString("tipo_descricao"));
                mp.setVolume(rs.getDouble("volume"));
                listaProdutos.add(mp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler do SGBD!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm, rs);
            return listaProdutos;
        }
    }
    
    public List lerTipo() {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<MTipoProduto> listaTipoProduto = new ArrayList<>();
        MTipoProduto mtp = null;
        try {
            stm = con.prepareStatement("SELECT tipo_descricao FROM tipoProduto");
            rs = stm.executeQuery();
            while (rs.next()) {
                mtp = new MTipoProduto();
                mtp.setDescricao(rs.getString("tipo_descricao"));
                listaTipoProduto.add(mtp);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler do SGBD!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm, rs);
            return listaTipoProduto;
        }
    }
    
    public double lerPreco_unitario(int id){
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        if(ProdutoExiste(id)){
            try {
                stm = con.prepareStatement("select preco_final from produto where id = ?");
                stm.setInt(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    return rs.getDouble("preco_final");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao ler do SGBD!!" + ex);
            } finally {
                NovaConecta.closeConnection(con, stm, rs);
            }
        }
        return 0;
    }
    
    public boolean ProdutoExiste(int id_prod){
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = con.prepareStatement("SELECT * FROM produto where id = ?");
            stm.setInt(1, id_prod);
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
    public void CadProduto(MProduto mp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizaProduto(MProduto mp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluirProduto(MProduto mp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
