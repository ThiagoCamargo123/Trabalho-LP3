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
    Double volumeProduto;
    Integer idCategoria;
    Double preco;
    Double precoFinal;
    Double lucro;

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
