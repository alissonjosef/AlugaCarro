package Repositorys;

import models.Model;
import models.Pessoa;
import models.PessoaFisica;
import models.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;

public class PessoaDAO extends DAO{

    private static PessoaDAO uniqueInstance;

    public PessoaDAO() {
    }

    @Override
    public synchronized PessoaDAO getInstancia() {
        if(uniqueInstance == null) {
            uniqueInstance = new PessoaDAO();
            uniqueInstance.setRepositorio(new ArrayList());
        }
        return this.uniqueInstance;
    }

    @Override
    public Pessoa consultar(Integer id){
        Model model = super.consultar(id);
        if(model == null){
            System.out.println("Cliente não encontrado");
        }
        return (Pessoa) model;
    }

    public Pessoa consultar(String cpjCnpj){
        Pessoa pessoaEncontrada = null;

        for (Model model : getRepository()){

            Pessoa pessoa = (Pessoa) model;
            // SE USA instanceof PARA VERIFICAR QUAL A INSTANCIA DA CLASSE PAI
            if(pessoa instanceof PessoaFisica){
                PessoaFisica pf = (PessoaFisica) pessoa;
                if(pf.getCpf().equalsIgnoreCase(cpjCnpj)){
                    pessoa = pf;
                    break;
                }

            } else if( pessoa instanceof PessoaJuridica){
                PessoaJuridica pj = (PessoaJuridica) pessoa;
                if(pj.getCnpj().equalsIgnoreCase(cpjCnpj)){
                    pessoa = pj;
                    break;
                }
            }

        }
        return pessoaEncontrada;
    }

}
