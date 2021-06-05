package Controllers;

import Repositorys.VeiculoDAO;
import models.Carro;
import models.Model;
import models.Pessoa;
import models.Veiculo;

public class VeiculoController {

    private VeiculoDAO veiculoDAO;

    public VeiculoController(){
        this.veiculoDAO = new VeiculoDAO().getInstancia();

    }
    
    public int criarVeiculo(Veiculo veiculo){
        System.out.println("[Controller] Metodo Criar Veiculo");
        veiculo.setId(null);
        int id = this.veiculoDAO.inserir(veiculo);
        return id;
    }

    public Veiculo consultarVeiculo(Integer id){
        Veiculo veiculo = (Veiculo) this.veiculoDAO.consultar(id);
        return veiculo;
    }

   /*  public void consultarVeiculo(String placa){
        this.veiculoDAO.consultar(placa);
    } */

    public Veiculo atualziarVeiculo(Veiculo veiculoParaAtualizar){
        Veiculo veiculoSalva = consultarVeiculo(veiculoParaAtualizar.getId());

        veiculoSalva.setKilometragem(veiculoParaAtualizar.getKilometragem());
        veiculoSalva.setMarca(veiculoParaAtualizar.getMarca());
        
        
        if(veiculoSalva instanceof Carro){
            Carro c = (Carro) veiculoSalva;
            Carro pfPraAtualizar = (Carro) veiculoParaAtualizar; 
            
            c.setMarca(pfPraAtualizar.getMarca());
            
        }
        
        Model model = this.veiculoDAO.atualizar(veiculoSalva);
        return (Veiculo)model;
    }
    
    public void deletar(Integer id){
        this.veiculoDAO.deletar(id);
    }

    public Pessoa consultarVeiculo(String id) {
        return null;
    }
}
