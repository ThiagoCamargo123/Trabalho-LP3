/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.compra.Vender;

/**
 *
 * @author Ivan Farina
 */
public class MVender {
    int id_produto, quant;
    String cpf_Cliente, dataLocal,horarioLocal;
    double preco_total;

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public String getCpf_Cliente() {
        return cpf_Cliente;
    }

    public void setCpf_Cliente(String cpf_Cliente) {
        this.cpf_Cliente = cpf_Cliente;
    }

    public String getDataLocal() {
        return dataLocal;
    }

    public void setDataLocal(String dataLocal) {
        this.dataLocal = dataLocal;
    }

    public String getHorarioLocal() {
        return horarioLocal;
    }

    public void setHorarioLocal(String horarioLocal) {
        this.horarioLocal = horarioLocal;
    }

    public double getPreco_total() {
        return preco_total;
    }

    public void setPreco_total(double preco_total) {
        this.preco_total = preco_total;
    }
    
}
