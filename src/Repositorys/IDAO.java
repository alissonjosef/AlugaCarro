package Repositorys;

import models.Model;

//DTO = DATA ACESS OBEJCT  -> Objeto de acesso a dados
public interface IDAO {

    IDAO getInstancia();

    int inserir(Model obj);

    Model atualizar(Model obj);

    Model consultar(Integer id);

    void deletar(Integer id);
}
