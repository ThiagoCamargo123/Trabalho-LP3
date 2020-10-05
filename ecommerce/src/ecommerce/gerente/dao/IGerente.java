/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.gerente.dao;

import java.util.List;

/**
 *
 * @author Thiago
 */
public interface IGerente {
    public boolean incluirGerente(MGerente gerente);
    public boolean atualizarGerente(MGerente gerente);
    public List<MGerente> listar();
    public String buscarSenha(String cpf);
}
