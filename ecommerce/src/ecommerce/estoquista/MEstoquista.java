/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.estoquista;

/**
 *
 * @author Thiago
 */
public class MEstoquista {
    private Integer id;
    private String cpf;
    private String nome;
    private Integer numeroContrato;
    private String cpfGerente;
    private Integer senhaAcesso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(Integer numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getCpfGerente() {
        return cpfGerente;
    }

    public void setCpfGerente(String cpfGerente) {
        this.cpfGerente = cpfGerente;
    }

    public Integer getSenhaAcesso() {
        return senhaAcesso;
    }

    public void setSenhaAcesso(Integer senhaAcesso) {
        this.senhaAcesso = senhaAcesso;
    }
    
    
}
