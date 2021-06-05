package Repositorys;

import models.Model;
import models.Pessoa;

import java.util.List;

public abstract class DAO implements IDAO{

    private List<Model> repositorio;

    public abstract DAO getInstancia();

    protected List<Model> getRepository(){
        return repositorio;
    }

    protected void setRepositorio(List list){
        this.repositorio = list;
    }

    public int inserir(Model obj) {
        int id = getProximoIdDisponivel();
        obj.setId(id);
        getRepository().add(obj);
        return id;
    }

    protected int getProximoIdDisponivel(){
        int totalSavo = this.getRepository().size();
        return totalSavo + 1;
    }

    public Model atualizar(Model objAtualizado) {
        Model modelDesatualizado = consultar(objAtualizado.getId());

        //Sempre eh bom validar o null para evitar o mizeravi do NullPointException
        if(modelDesatualizado != null){
            getRepository().remove(modelDesatualizado);
            getRepository().add(objAtualizado);

        } else if(objAtualizado.getId() != null) {
            //CASO NAO TENHA ENCONTRADO O MODEL COM O ID INDICADO ELE INSERE UM NOVO
            getRepository().add(objAtualizado);

        } else {
            //CASO O ID DO OBJ A SER ATUALIZAR ESTEJA NULL, VAI INSERIR UM OBJ NOVO
            inserir(objAtualizado);
        }
        return objAtualizado;
    }

    public Model consultar(Integer id) {

        Model modelEncontrado = null;

        for (Model model : getRepository()) {
            if(model.getId().compareTo(id) == 0){
                modelEncontrado = model;
                break;
            }
        }

        return modelEncontrado;
    }

    public void deletar(Integer id) {
        Model modelSalvo = consultar(id);

        //Sempre eh bom validar o null para evitar o mizeravi do NullPointException
        if(modelSalvo != null){
            getRepository().remove(modelSalvo);
        }
    }
}
