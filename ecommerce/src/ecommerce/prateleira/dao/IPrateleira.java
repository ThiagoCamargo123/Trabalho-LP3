
package ecommerce.prateleira.dao;

import InteligenciaArtificial.model.ProdutoBanco;
import java.util.List;


public interface IPrateleira {
    public void inserirPrateleira(MPrateleira prateleira);
//    public void alterarPrateleira(MPrateleira prateleira);
    public List<MPrateleira> listarPrateleira();
    public void deletarPrateleira(Integer id);
    public List<ProdutoBanco> MostrarIetnsArmazenados();
}
