/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.produto.dao;

import java.util.List;

/**
 *
 * @author Ivan Farina
 */
public interface IProduto {
    public List lerProduto();
    void CadProduto(MProduto mp);
    void atualizaProduto(MProduto mp);
    void excluirProduto(MProduto mp);
    public List produtosPorPrateleira();
    public List produtosNaoEstocado();
    public List buscarProdutoPorTipo(String tipo);
    public List produtosVendidos(String dataCompra);
}
