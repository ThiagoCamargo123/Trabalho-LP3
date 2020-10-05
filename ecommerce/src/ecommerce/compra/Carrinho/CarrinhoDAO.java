/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.compra.Carrinho;

import bancoDados.NovaConecta;
import ecommerce.compra.Vender.MVender;
import ecommerce.compra.Vender.VenderDAO;
import ecommerce.usuario.Session;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
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
            stm = con.prepareStatement("select * from carrinho where cpf_cliente = '"+Session.getInstance().getCPF()+"' AND aberto = 's'");
            rs = stm.executeQuery();
            while (rs.next()) {
                mc = new MCarrinho();
                mc.setId_produto(rs.getInt("id_produto"));
                mc.setQuant(rs.getInt("quant"));
                mc.setPreco_total(rs.getDouble("preco_total"));
                mc.setAberto(rs.getString("aberto"));
                mc.setCpf_Cliente(rs.getString("cpf_cliente"));
                mc.setPreco_unit(rs.getDouble("preco_unit"));
                listaCarrinho.add(mc);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler do SGBD!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm, rs);
            return listaCarrinho;
        }
    }
    //Verifica se o produto existe
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
    //verifica se esse produto ja esta no carrinho
    public int verificaProdutoCarrinho(int id){
        List<MCarrinho> listacarrinho = lerCarrinho();
        for(MCarrinho c : listacarrinho) {
            if (c.getId_produto() == id) {
               return c.getQuant();
            }
        }
        return 0;
    }
    //atualiza quantidade ou insere produto no carrinho
    @Override
    public boolean addCarrinho(MCarrinho c) {
        int quant = verificaProdutoCarrinho(c.getId_produto());
        if(quant!=0){
            excluirCarrinho(c);
        }
        Connection con = NovaConecta.getConnection();
            PreparedStatement stm = null;
            try {
                stm = con.prepareStatement("INSERT INTO carrinho (id_produto,cpf_cliente,quant,aberto,preco_total,preco_unit) VALUES (?,?,?,?,?,?)");
                stm.setInt(1, c.getId_produto());
                stm.setString(2, c.getCpf_Cliente());
                stm.setInt(3, c.getQuant());
                stm.setString(4, "s");
                stm.setDouble(5, c.getPreco_total());
                stm.setDouble(6, c.getPreco_unit());
                stm.executeUpdate();
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao apagar!!" + ex);
            } finally {
                NovaConecta.closeConnection(con, stm);
            }
        return false;
    }
    
    //atualiza produto
    @Override
    public boolean atualizaCarrinho(MCarrinho c) {
        excluirCarrinho(c);
        if(c.getQuant()>0){
            addCarrinho(c);
        }
        else{
            JOptionPane.showMessageDialog(null, "Apagado com sucesso!!");
        }
        return false;
    }

    @Override
    public void excluirCarrinho(MCarrinho c) {
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("DELETE FROM carrinho where id_produto = ? AND cpf_cliente = ? AND aberto ='s'");
            stm.setInt(1, c.getId_produto());
            stm.setString(2, c.getCpf_Cliente());
            stm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm);
        }
    }
    
    //executado sempre depois da compra para atualizar produto no carrinho para como comprado
    public void alteraAberto(MCarrinho c){
        MVender mv = new MVender();
        mv.setId_produto(c.getId_produto());
        VenderDAO vdao = new VenderDAO();
        vdao.alteraAbertoAtualizado(mv);
    }
    
    public void comprar(MCarrinho c){
        LocalDate dataLocal = LocalDate.now();
        LocalTime horaLocal = LocalTime.now();
        String horarioLocal = horaLocal.toString();
        String DataLocal = dataLocal.toString();
        
        MVender mv = new MVender();
        mv.setCpf_Cliente(c.getCpf_Cliente());
        mv.setDataLocal(DataLocal);
        mv.setHorarioLocal(horarioLocal);
        mv.setId_produto(c.getId_produto());
        mv.setPreco_total(c.getPreco_total());
        mv.setQuant(c.getQuant());
        
        VenderDAO vdao = new VenderDAO();
        vdao.incluirVenda(mv);
    }
    
    public void atualizaEstoque(MCarrinho c){
        int estoque = this.getEstoque(c);
        estoque = estoque - c.getQuant();
        VenderDAO vdao = new VenderDAO();
        vdao.atualizaEstoque(c.getId_produto(), estoque);
    }
    
    private int getEstoque(MCarrinho c){
        Connection con = NovaConecta.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = con.prepareStatement("SELECT estocado FROM produto where id = ?");
            stm.setInt(1, c.getId_produto());
            rs = stm.executeQuery();
            int estocado = 0;
            while (rs.next()) {
                estocado=rs.getInt("estocado");
                return estocado;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler do SGBD!!" + ex);
        } finally {
            NovaConecta.closeConnection(con, stm, rs);
        }
        return 0;
    }
    
}
