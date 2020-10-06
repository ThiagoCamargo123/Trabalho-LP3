/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.cliente.dao;

import java.util.List;

/**
 *
 * @author Ivan Farina
 */
public interface ICliente {
    public List lerClientes();
    void cadastrarCliente(MCliente mc);
    void alterarCliente(MCliente mc);
    void exluirCliente(MCliente mc);
}
