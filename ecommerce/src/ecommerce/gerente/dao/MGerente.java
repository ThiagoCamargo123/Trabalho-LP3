/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.gerente.dao;

/**
 *
 * @author Thiago
 */
public class MGerente {
    private String nome, cpf, senha,cpfAntigo;
    
    private Integer login;

    public String getCpfAntigo() {
        return cpfAntigo;
    }

    public void setCpfAntigo(String cpfAntigo) {
        this.cpfAntigo = cpfAntigo;
    }
    
    

    public Integer getLogin() {
        return login;
    }

    public void setLogin(Integer login) {
        this.login = login;
    }

    

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    
    
}
