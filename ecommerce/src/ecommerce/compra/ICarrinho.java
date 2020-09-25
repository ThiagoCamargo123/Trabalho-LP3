/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.compra;

import java.util.List;

/**
 *
 * @author Ivan Farina
 */
public interface ICarrinho {
    public List lerCarrinho();
    boolean addCarrinho(MCarrinho c);
    boolean atualizaCarrinho(MCarrinho c);
    void excluirCarrinho(MCarrinho c);
}
