
package ecommerce.estoquista.dao;

import java.util.List;


public interface IEstoquista {
    public List lerEstoquistas();
    void cadastrarEstoquista(MEstoquista estoquista);
}
