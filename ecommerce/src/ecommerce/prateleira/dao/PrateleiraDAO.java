package ecommerce.prateleira.dao;

import InteligenciaArtificial.model.ProdutoBanco;
import bancoDados.NovaConecta;
import ecommerce.produto.dao.MProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PrateleiraDAO implements IPrateleira {

    @Override
    public void inserirPrateleira(MPrateleira prateleira) {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        int id = 0;
        try {
            stm = con.prepareStatement("INSERT INTO prateleira (volume,volume_max) VALUES(" + prateleira.getVolume() + "," + prateleira.getVolumeMaximo() + ")");
            stm.executeUpdate();

            JOptionPane.showMessageDialog(null, " Salvo com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }

    }

//    @Override
//    public void alterarPrateleira(MPrateleira prateleira) {
//        Connection con = NovaConecta.getConnection();
//        PreparedStatement stm = null;
//        try {
//            stm = con.prepareStatement("UPDATE prateleira SET volume=?,volume_max=? WHERE id = ?");
//            stm.setDouble(1, prateleira.getVolume());
//            stm.setDouble(2, prateleira.getVolumeMaximo());
//            stm.setInt(3, prateleira.getId());
//            stm.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!!");
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao atualizar!!" + ex);
//        } finally {
//            NovaConecta.closeConnection(con, stm);
//        }
//    }
    @Override
    public List<MPrateleira> listarPrateleira() {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<MPrateleira> listaPrateleiras = new ArrayList<>();
        MPrateleira prateleira;

        try {
            stm = con.prepareStatement("select * from prateleira order by id");
            rs = stm.executeQuery();
            while (rs.next()) {
                prateleira = new MPrateleira();
                prateleira.setId(rs.getInt("id"));
                prateleira.setVolumeString(rs.getString("volume"));
                prateleira.setVolumeMaximoString(rs.getString("volume_max"));
                listaPrateleiras.add(prateleira);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler do SGBD!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm, rs);
            return listaPrateleiras;
        }
    }

    @Override
    public void deletarPrateleira(Integer id) {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = con.prepareStatement("DELETE from prateleira where id= " + id + "");
            stm.executeUpdate();

            JOptionPane.showMessageDialog(null, " Apagado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
    }

    @Override
    public void mudarStatusParaArmazenado(String idPrateleira) {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("update produto_prateleira set estocado = 'SIM' where id_prateleira = '"+idPrateleira+"'");
            stm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm);
        }
    }

    @Override
    public void mudarStatusParaVendidoo(MProduto produto) {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("update produto_prateleira set estocado = 'VEN' where id_prateleira = '"+produto.getIdPrateleira()+"' and id_produto = "+produto.getId()+"");
            stm.executeUpdate();
            
            stm = con.prepareStatement("select volume from prateleira where id = '"+produto.getIdPrateleira()+"'");
            ResultSet rs = stm.executeQuery();
            Double volume = null;
            while(rs.next()){
                volume = rs.getDouble("volume");
            }
            
            Double volumeAtual = volume + produto.getVolume();
            
            stm = con.prepareStatement("update prateleira set volume = "+volumeAtual+" where id = '"+produto.getIdPrateleira()+"'");
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm);
        }
    }

}
