package Repositorys;

import java.util.ArrayList;

import models.Model;
import models.Veiculo;

public class VeiculoDAO extends DAO{

    private static VeiculoDAO uniqueInstance;

    public VeiculoDAO(){

    }
    
    @Override
    public synchronized VeiculoDAO getInstancia() {
        if(uniqueInstance == null) {
            uniqueInstance = new VeiculoDAO();
            uniqueInstance.setRepositorio(new ArrayList());
        }
        return this.uniqueInstance;
    }

    @Override
    public Veiculo consultar(Integer id){
        Model model = super.consultar(id);
        if(model == null){
            System.out.println("Cliente não encontrado");
        }
        return (Veiculo) model;
    }

}
