/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.produto.dao;

/**
 *
 * @author Ivan Farina
 */
public class MProduto {
    private int id, estocado,naoestocado;
    private String descricao,tipo,descricaoTipo,idPrateleira,jaEstocado;
    private double altura,largura,profundidade, preco, preco_final, volume;
    private String data, hora;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
    public String getJaEstocado() {
        return jaEstocado;
    }

    public void setJaEstocado(String jaEstocado) {
        this.jaEstocado = jaEstocado;
    }

    
    
    public String getDescricaoTipo() {
        return descricaoTipo;
    }

    public void setDescricaoTipo(String descricaoTipo) {
        this.descricaoTipo = descricaoTipo;
    }

    public String getIdPrateleira() {
        return idPrateleira;
    }

    public void setIdPrateleira(String idPrateleira) {
        this.idPrateleira = idPrateleira;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }    

    public int getEstocado() {
        return estocado;
    }

    public void setEstocado(int estocado) {
        this.estocado = estocado;
    }

    public int getNaoestocado() {
        return naoestocado;
    }

    public void setNaoestocado(int naoestocado) {
        this.naoestocado = naoestocado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(double profundidade) {
        this.profundidade = profundidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco_final() {
        return preco_final;
    }

    public void setPreco_final(double preco_final) {
        this.preco_final = preco_final;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
