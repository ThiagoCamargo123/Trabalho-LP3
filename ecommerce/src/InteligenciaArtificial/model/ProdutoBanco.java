/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InteligenciaArtificial.model;

/**
 *
 * @author Thiago
 */
public class ProdutoBanco {
    Integer idProduto;
    String descricao;
    Double volumeProduto;
    Integer idCategoria;
    String descricaoCategoria;
    Double preco;
    Double precoFinal;
    Double lucro;
    Integer quantidadeEstocado;
    Integer quantidadeNaoEstocado;

    public Integer getQuantidadeNaoEstocado() {
        return quantidadeNaoEstocado;
    }

    public void setQuantidadeNaoEstocado(Integer quantidadeNaoEstocado) {
        this.quantidadeNaoEstocado = quantidadeNaoEstocado;
    }

    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidadeEstocado() {
        return quantidadeEstocado;
    }

    public void setQuantidadeEstocado(Integer quantidadeEstocado) {
        this.quantidadeEstocado = quantidadeEstocado;
    }
    
    public Double getLucro() {
        return lucro;
    }

    public void setLucro(Double lucro) {
        this.lucro = lucro;
    }
    
    

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(Double precoFinal) {
        this.precoFinal = precoFinal;
    }

    

    public Double getVolumeProduto() {
        return volumeProduto;
    }

    public void setVolumeProduto(Double volumeProduto) {
        this.volumeProduto = volumeProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

  
    
    
}
