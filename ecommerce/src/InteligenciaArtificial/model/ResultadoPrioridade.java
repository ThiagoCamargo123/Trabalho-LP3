
package InteligenciaArtificial.model;


public class ResultadoPrioridade {
    private String idCategoria;
    private String nomeCategoria;
    private Integer somatoria;

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Integer getSomatoria() {
        return somatoria;
    }

    public void setSomatoria(Integer somatoria) {
        this.somatoria = somatoria;
    }
    
    

    public ResultadoPrioridade(String idCategoria, String nomeCategoria, Integer somatoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
        this.somatoria = somatoria;
    }

    
}
