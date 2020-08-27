
package InteligenciaArtificial;

import InteligenciaArtificial.model.CategoriaLucro;
import InteligenciaArtificial.model.MaisVendido;
import InteligenciaArtificial.model.ProdutoBanco;
import InteligenciaArtificial.model.ResultadoPrioridade;
import bancoDados.BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.Collectors;


public class OrganizarPrateleira {   
    
        Connection con = null;
        Statement statment = null; 
        ResultSet resultSet = null; String s;
        
    public List<ProdutoBanco> armazenaOsProdutosComPrioridadeMaior() throws Exception{
        List<ProdutoBanco> ordemASerEstocada = new ArrayList();
        
        List<ProdutoBanco> resultadoPrioridade = calculaPrioridadeCategoriaPorMaisVendidaEMaiorLucroEMenorVolume();
        List<ProdutoBanco> produtosNaoEstocados = validaProdutoNaoEstocado();
        
        for(int i=0;i<resultadoPrioridade.size();i++){
            List<ProdutoBanco> produtoComMesmaCategoria = new ArrayList();
            
            for(int j=0;j<produtosNaoEstocados.size();j++){
                if(resultadoPrioridade.get(i).getIdCategoria().equals(produtosNaoEstocados.get(j).getIdCategoria())){
                    produtoComMesmaCategoria.add(produtosNaoEstocados.get(j));
                }
            }
                List<ProdutoBanco> prioridadeVolume = new ArrayList();
            
                if(produtoComMesmaCategoria.size() > 1){ //Preciso definir prioridade com base no volume
                    prioridadeVolume = produtoComMesmaCategoria
                            .stream()
                            .sorted(Comparator.comparing(ProdutoBanco::getVolumeProduto))
                            .collect(Collectors.toList());
                }
                
                for(ProdutoBanco produto: prioridadeVolume){
                    ordemASerEstocada.add(produto);
                }
        }
        
        return ordemASerEstocada;
    } //LEMBRAR QUE A ORDEM DO JAVA 8 TA ERRADA
    
    public List<ProdutoBanco> calculaPrioridadeCategoriaPorMaisVendidaEMaiorLucroEMenorVolume() throws Exception {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://ec2-34-195-115-225.compute-1.amazonaws.com:5432/d7gbh9tbts0r7j","zuidrqukwykbwd","8f82c803a029137f140288c3d133e854bdf76d61b948c7ad1365552d7f058d69");
        statment = con.createStatement();
        
        List<MaisVendido> categoriaMaisVendida = calculaMaisVendido();
        
        List<ProdutoBanco> resultadoPrioridade = new ArrayList();
        
        List<ProdutoBanco> produtoPorMaiorLucro = calculaMaiorLucroPorProduto();
        
        for(int i=0;i<categoriaMaisVendida.size();i++){
            for(int j=0;j<produtoPorMaiorLucro.size();j++){
                if(categoriaMaisVendida.get(i).getIdCategoria().equals(produtoPorMaiorLucro.get(j).getIdCategoria())){
                    ProdutoBanco produto = produtoPorMaiorLucro.get(j);
                    
                    resultadoPrioridade.add(produto);
                }
            }
        }
        
        for(int i=0;i<resultadoPrioridade.size();i++){ //Valida se possui o mesmo lucro e mesma categoria, se estiver o que tiver menor volume prioriza
            for(int j=i+1;j<resultadoPrioridade.size();j++){
                if(resultadoPrioridade.get(i).getIdCategoria() == resultadoPrioridade.get(j).getIdCategoria()
                        && resultadoPrioridade.get(i).getLucro()== resultadoPrioridade.get(j).getLucro()){
                    
                    if(resultadoPrioridade.get(i).getVolumeProduto() > resultadoPrioridade.get(j).getVolumeProduto()){
                        ProdutoBanco aux = new ProdutoBanco();
                        
                        aux = resultadoPrioridade.get(i);
                        
                        resultadoPrioridade.get(i).setIdCategoria(resultadoPrioridade.get(j).getIdCategoria());
                        resultadoPrioridade.get(i).setIdProduto(resultadoPrioridade.get(j).getIdProduto());
                        resultadoPrioridade.get(i).setPreco(resultadoPrioridade.get(j).getPreco());
                        resultadoPrioridade.get(i).setPrecoFinal(resultadoPrioridade.get(j).getPrecoFinal());
                        resultadoPrioridade.get(i).setVolumeProduto(resultadoPrioridade.get(j).getVolumeProduto());
                        resultadoPrioridade.get(i).setLucro(resultadoPrioridade.get(j).getLucro());
                                
                        
                        resultadoPrioridade.get(j).setIdCategoria(aux.getIdCategoria());
                        resultadoPrioridade.get(j).setIdProduto(aux.getIdProduto());
                        resultadoPrioridade.get(j).setPreco(aux.getPreco());
                        resultadoPrioridade.get(j).setPrecoFinal(aux.getPrecoFinal());
                        resultadoPrioridade.get(j).setVolumeProduto(aux.getVolumeProduto());
                        resultadoPrioridade.get(j).setLucro(aux.getLucro());
                    }
                }
            }
        }
        
        return resultadoPrioridade;
    }
    
    public List<MaisVendido> calculaMaisVendido() throws SQLException{
        String categoriaVendida = "select tipoproduto.id,count(id_produto) as conta \n" +
            "from compra\n" +
            "inner join produto on produto.id = compra.id_produto\n" +
            "inner join tipoproduto on tipoproduto.id = produto.tipo\n" +
            "group by tipoproduto.id\n" +
            "order by conta desc";
        resultSet = statment.executeQuery(categoriaVendida);
        
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int numeroColunas = resultSetMetaData.getColumnCount();
        
        List<MaisVendido> categoriaMaisVendida = new ArrayList();
        
            while(resultSet.next()) {
                MaisVendido produtoAtual = new MaisVendido();
                produtoAtual.setIdCategoria(Integer.valueOf(resultSet.getString(1)));
                produtoAtual.setVezesVendido(resultSet.getString(2));
                categoriaMaisVendida.add(produtoAtual);
            }
            
        return categoriaMaisVendida;
    }
    
    public List<ProdutoBanco> validaProdutoNaoEstocado() throws SQLException{
        String produtoNaoEstocado = "select id,volume,tipo,preco,preco_final from produto where estocado = 'NAO'";
        
        resultSet = statment.executeQuery(produtoNaoEstocado);
        
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int numeroColunas = resultSetMetaData.getColumnCount();
        
        List<ProdutoBanco> produtosNaoEstocadoList = new ArrayList();
        
            while(resultSet.next()) {
                ProdutoBanco produtoBanco = new ProdutoBanco();
                
                produtoBanco.setIdProduto(Integer.valueOf(resultSet.getString(1)));
                produtoBanco.setVolumeProduto(Double.valueOf(resultSet.getString(2)));
                produtoBanco.setIdCategoria(Integer.valueOf(resultSet.getString(3)));
                produtoBanco.setPreco(Double.valueOf(resultSet.getString(4)));
                produtoBanco.setPrecoFinal(Double.valueOf(resultSet.getString(5)));
                
                produtosNaoEstocadoList.add(produtoBanco);
            }
            
        return produtosNaoEstocadoList;
    }
    
    public List<CategoriaLucro> calculoLucroPorCategoria() throws SQLException{
        String categoriaLucroSql = "select p.tipo as Categoria,sum(p.preco_final-p.preco) as Lucro\n" +
                                "from	produto p\n" +
                                "inner join\n" +
                                "		compra c\n" +
                                "on(p.id=c.id_produto)\n" +
                                "GROUP BY p.tipo\n" +
                                "ORDER BY Lucro desc";
        
        resultSet = statment.executeQuery(categoriaLucroSql);
        
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int numeroColunas = resultSetMetaData.getColumnCount();
        
        List<CategoriaLucro> categoriaLucroList = new ArrayList();
        
            while(resultSet.next()) {
                CategoriaLucro categoriaLucro = new CategoriaLucro();
                
                categoriaLucro.setIdCategoria(resultSet.getString(1));
                categoriaLucro.setLucro(Double.valueOf(resultSet.getString(2)));
                
                categoriaLucroList.add(categoriaLucro);
            }
            
        return categoriaLucroList;
    }
    
    public List<ProdutoBanco> calculaMaiorLucroPorProduto() throws SQLException{
        List<ProdutoBanco> produtosNaoEstocado = validaProdutoNaoEstocado();
        
        for(ProdutoBanco produto: produtosNaoEstocado){
            produto.setLucro(produto.getPrecoFinal() - produto.getPreco());
        }
        
        List<ProdutoBanco> produtosComMaisPrioridadeDeLucro = produtosNaoEstocado
                .stream()
                .sorted(Comparator.comparing(ProdutoBanco::getLucro))
                .collect(Collectors.toList());
        
        Collections.reverse(produtosComMaisPrioridadeDeLucro); //Inverter ordem, pois está ordenado do menor para maior
        
        return produtosComMaisPrioridadeDeLucro;
    }
}
    