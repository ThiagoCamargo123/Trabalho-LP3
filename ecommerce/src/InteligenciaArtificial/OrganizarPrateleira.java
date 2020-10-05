
package InteligenciaArtificial;

import InteligenciaArtificial.model.*;
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
        BD bd = new BD();
        Connection con = null;
        Statement statment = null; 
        ResultSet resultSet = null; String s;
        
    public Prateleira armazenaOsProdutos(ProdutoBanco produto) throws Exception{
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://ec2-34-195-115-225.compute-1.amazonaws.com:5432/d7gbh9tbts0r7j","zuidrqukwykbwd","8f82c803a029137f140288c3d133e854bdf76d61b948c7ad1365552d7f058d69");
        statment = con.createStatement();
        
        List<Prateleira> prateleiras = consultaPrateleira();
        Prateleira retornoPrateleira = new Prateleira();
        boolean verificador = false;
        int indicePrateleira = 0;
        
        while(verificador == false){
            if(prateleiras.get(indicePrateleira).getVolumeDisponivel() > produto.getVolumeProduto()){
                Integer idProduto = produto.getIdProduto();
                String id = prateleiras.get(indicePrateleira).getId();
                String sql = "INSERT INTO produto_prateleira (id_produto,id_prateleira,estocado) values ("+idProduto+",'"+id+"','NAO')";
                statment.executeUpdate(sql);
                
                double volumeAtualPrateleira = prateleiras.get(indicePrateleira).getVolumeDisponivel();
                long volumeProduto = produto.getVolumeProduto().longValue();
                
                double volumeResultante = volumeAtualPrateleira - volumeProduto;
                
                statment.executeUpdate("UPDATE prateleira SET volume= '"+volumeResultante+"' where id ='"+prateleiras.get(indicePrateleira).getId()+"'");
                
                //Dando erro
                statment.executeUpdate("UPDATE produto SET naoestocado = "+produto.getQuantidadeNaoEstocado()+ 1 +" where id ="+produto.getIdProduto()+"");
                
                
                retornoPrateleira.setId(prateleiras.get(indicePrateleira).getId());
                retornoPrateleira.setVolumeDisponivel(volumeResultante);
                
                double porcentagem = (prateleiras.get(indicePrateleira).getVolumeDisponivel() / 1200000) * 100;
                String porcentagemString = String.valueOf(porcentagem);
                String res = porcentagemString+" %";
                if(porcentagemString.length()>5){
                    porcentagemString = porcentagemString.substring(0,5);
                }
                retornoPrateleira.setPorcentagem(res);
                
                verificador = true;
            }else{
                indicePrateleira++;
            }
        }
        
            

        return retornoPrateleira;
    }
    
    public List<ProdutoBanco> calculaPrioridadeCategoriaPorMaisVendidaEMaiorLucroEMenorVolume(String dataInicio,String dataFim) throws Exception {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://ec2-34-195-115-225.compute-1.amazonaws.com:5432/d7gbh9tbts0r7j","zuidrqukwykbwd","8f82c803a029137f140288c3d133e854bdf76d61b948c7ad1365552d7f058d69");
        statment = con.createStatement();
        
        List<MaisVendido> categoriaMaisVendida = calculaMaisVendido(dataInicio,dataFim);
        
        List<ProdutoBanco> resultadoPrioridade = new ArrayList();
        
        List<ProdutoBanco> produtoPorMaiorLucro = calculaMaiorLucroPorProduto();
        
        
        //Nesse for ele vai ver os produtos com maior lucro se estao na mesma categoria mais vendida, e add no resultado prioridade
        for(int i=0;i<categoriaMaisVendida.size();i++){
            for(int j=0;j<produtoPorMaiorLucro.size();j++){
                if(categoriaMaisVendida.get(i).getIdCategoria().equals(produtoPorMaiorLucro.get(j).getIdCategoria())){
                    ProdutoBanco produto = produtoPorMaiorLucro.get(j);
                    
                    resultadoPrioridade.add(produto);
                }
            }
        }
        
        //Nesse for ele vai alocar os produtos que nao estao na categoria mantendo a ordem de prioridade por lucro
        for(ProdutoBanco pro: produtoPorMaiorLucro){
            if(!resultadoPrioridade.contains(pro)){
                resultadoPrioridade.add(pro);
            }
        }
        
        
        //Nesse for valida se possui o mesmo lucro e mesma categoria, se estiver o que tiver menor volume prioriza
        for(int i=0;i<resultadoPrioridade.size();i++){ 
            for(int j=i+1;j<resultadoPrioridade.size();j++){
                if(resultadoPrioridade.get(i).getIdCategoria().equals(resultadoPrioridade.get(j).getIdCategoria())
                        && resultadoPrioridade.get(i).getLucro().equals(resultadoPrioridade.get(j).getLucro())){
                    
                    if(resultadoPrioridade.get(i).getVolumeProduto() > resultadoPrioridade.get(j).getVolumeProduto()){
                        ProdutoBanco aux = new ProdutoBanco();
                        
                        aux.setIdCategoria(resultadoPrioridade.get(i).getIdCategoria());
                        aux.setIdProduto(resultadoPrioridade.get(i).getIdProduto());
                        aux.setPreco(resultadoPrioridade.get(i).getPreco());
                        aux.setPrecoFinal(resultadoPrioridade.get(i).getPrecoFinal());
                        aux.setVolumeProduto(resultadoPrioridade.get(i).getVolumeProduto());
                        aux.setLucro(resultadoPrioridade.get(i).getLucro());
                        
                        resultadoPrioridade.get(i).setIdCategoria(resultadoPrioridade.get(j).getIdCategoria()); //ERRADO
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
    
    public List<MaisVendido> calculaMaisVendido(String dataInicio,String dataFim) throws SQLException{
        String categoriaVendida = "select tipoproduto.tipo_id as tipoId,count(id_produto) as conta from compra\n" +
                                    "inner join produto on produto.id = compra.id_produto\n" +
                                    "inner join tipoproduto on tipoproduto.tipo_id = produto.tipo\n" +
                                    "where data_compra between('"+dataInicio+"') AND ('"+dataFim+"')\n" +
                                    "group by tipoproduto.tipo_id\n" +
                                    "order by conta desc";
        resultSet = statment.executeQuery(categoriaVendida);
        
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int numeroColunas = resultSetMetaData.getColumnCount();
        
        List<MaisVendido> categoriaMaisVendida = new ArrayList();
        
            while(resultSet.next()) {
                MaisVendido produtoAtual = new MaisVendido();
                produtoAtual.setIdCategoria(Integer.valueOf(resultSet.getString("tipoId")));
                produtoAtual.setVezesVendido(resultSet.getString("conta"));
                categoriaMaisVendida.add(produtoAtual);
            }
            
        return categoriaMaisVendida;
    }
    
    public List<ProdutoBanco> calculaMaiorLucroPorProduto() throws SQLException{
        List<ProdutoBanco> produtosNaoEstocado = consultaTodosProdutos();
        
        for(ProdutoBanco produto: produtosNaoEstocado){
            produto.setLucro(produto.getPrecoFinal() - produto.getPreco());
        }
        
        List<ProdutoBanco> produtosComMaisPrioridadeDeLucro = produtosNaoEstocado
                .stream()
                .sorted(Comparator.comparing(ProdutoBanco::getLucro))
                .collect(Collectors.toList());
        
        Collections.reverse(produtosComMaisPrioridadeDeLucro); //Inverte a ordem, pois está ordenado do menor para maior
        
        return produtosComMaisPrioridadeDeLucro;
    }

    public List<ProdutoBanco> consultaTodosProdutos() throws SQLException{
        String produtoNaoEstocado = "select p.id,p.descricao_produto,p.volume,p.tipo,tipoproduto.tipo_descricao as descricaoTipo,p.preco,preco_final,p.estocado,p.naoestocado\n" +
                                    "from produto p\n" +
                                    "inner join tipoproduto on tipoproduto.tipo_id = p.tipo";

        resultSet = statment.executeQuery(produtoNaoEstocado);

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int numeroColunas = resultSetMetaData.getColumnCount();

        List<ProdutoBanco> produtosNaoEstocadoList = new ArrayList();

        while(resultSet.next()) {
            ProdutoBanco produtoBanco = new ProdutoBanco();

            produtoBanco.setIdProduto(Integer.valueOf(resultSet.getString("id")));
            produtoBanco.setDescricao(resultSet.getString("descricao_produto"));
            produtoBanco.setVolumeProduto(Double.valueOf(resultSet.getString("volume")));
            produtoBanco.setIdCategoria(Integer.valueOf(resultSet.getString("tipo")));
            produtoBanco.setDescricaoCategoria(resultSet.getString("descricaoTipo"));
            produtoBanco.setPreco(Double.valueOf(resultSet.getString("preco")));
            produtoBanco.setPrecoFinal(Double.valueOf(resultSet.getString("preco_final")));
            produtoBanco.setQuantidadeNaoEstocado(resultSet.getInt("naoestocado"));
            if(resultSet.getString("estocado")!= null){
                produtoBanco.setQuantidadeEstocado(Integer.valueOf(resultSet.getString("estocado")));
            }
            produtosNaoEstocadoList.add(produtoBanco);
        }

        return produtosNaoEstocadoList;
    }

    public List<Prateleira> consultaPrateleira() throws SQLException {
        String prateleiraSql = "select * from prateleira order by (id)";

        resultSet = statment.executeQuery(prateleiraSql);

        List<Prateleira> prateleiras = new ArrayList();

        while(resultSet.next()) {
            Prateleira prateleira = new Prateleira();

            prateleira.setId(resultSet.getString("id"));
            prateleira.setVolumeDisponivel(Double.valueOf(resultSet.getString("volume")));

            prateleiras.add(prateleira);
        }

        return prateleiras;
    }
}
    