/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.produto;

import bancoDados.NovaConecta;
import ecommerce.compra.MCarrinho;
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
            stm = con.prepareStatement(
                    "select "
                            + "produto.id as id,"
                            + "produto.altura as altura,"
                            + "produto.descricao as descricao,"
                            + "produto.estocado as estocado,"
                            + "produto.largura as largura,"
                            + "produto.naoestocado as naoestocado,"
                            + "produto.preco as preco,"
                            + "produto.preco_final as preco_final,"
                            + "produto.profundidade as profundidade,"
                            + "produto.volume as volume,"
                            + "tipoProduto.descricao as tipo "
                            + "from produto "
                            + "inner join "
                            + "tipoProduto "
                            + "on (produto.tipo = tipoProduto.id)");
            rs = stm.executeQuery();
            while (rs.next()) {
                mp = new MProduto();
                mp.setId(rs.getInt("id"));
                mp.setAltura(rs.getInt("altura"));
                mp.setDescricao(rs.getString("descricao"));
                mp.setEstocado(rs.getInt("estocado"));
                mp.setLargura(rs.getInt("largura"));
                mp.setNaoestocado(rs.getInt("naoestocado"));
                mp.setPreco(rs.getDouble("preco"));
                mp.setPreco_final(rs.getDouble("preco_final"));
                mp.setProfundidade(rs.getInt("profundidade"));
                mp.setVolume(rs.getDouble("volume"));
                mp.setTipo(rs.getString("tipo"));
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
            stm = con.prepareStatement("SELECT descricao FROM tipoProduto");
            rs = stm.executeQuery();
            while (rs.next()) {
                mtp = new MTipoProduto();
                mtp.setDescricao(rs.getString("descricao"));
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
