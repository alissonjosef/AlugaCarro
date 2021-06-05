package Controllers;

import Repositorys.DAO;
import Repositorys.PessoaDAO;
import models.Model;
import models.Pessoa;
import models.PessoaFisica;
import models.PessoaJuridica;

public class ClienteController {

    private PessoaDAO pessoaDAO;

    public ClienteController(){
        this.pessoaDAO = new PessoaDAO().getInstancia();

    }

    public int criarCliente(Pessoa pessoa){
        System.out.println("[Controller] Metodo Criar Cliente");
        pessoa.setId(null);
        int id = this.pessoaDAO.inserir(pessoa);
        return id;
    }

    public Pessoa consultarCliente(Integer id){
        Pessoa pessoa = this.pessoaDAO.consultar(id);
        return pessoa;
    }

    public void consultarCliente(String cpfCnpj){
        this.pessoaDAO.consultar(cpfCnpj);
    }
    
    public Pessoa atualziarCliente(Pessoa pessoaParaAtualizar){
        Pessoa pessoaSalva = consultarCliente(pessoaParaAtualizar.getId());

        pessoaSalva.setEndereco(pessoaParaAtualizar.getEndereco());
        pessoaSalva.setNome(pessoaParaAtualizar.getNome());
        pessoaSalva.setAtivo(pessoaParaAtualizar.isAtivo());
        
        if(pessoaSalva instanceof PessoaFisica){
            PessoaFisica pf = (PessoaFisica) pessoaSalva;
            PessoaFisica pfPraAtualizar = (PessoaFisica) pessoaParaAtualizar; 
            
            pf.setCpf(pfPraAtualizar.getCpf());
            pf.setCnh(pfPraAtualizar.getCnh());
            pf.setDataNascimento(pfPraAtualizar.getDataNascimento());
            
        } else if(pessoaSalva instanceof PessoaJuridica){
            PessoaJuridica pj = (PessoaJuridica) pessoaSalva;
            PessoaJuridica pjPraAtualizar = (PessoaJuridica) pessoaParaAtualizar;
            
            pj.setCnpj(pjPraAtualizar.getCnpj());
        }
        
        Model model = this.pessoaDAO.atualizar(pessoaSalva);
        return (Pessoa)model;
    }
    
    public void deletar(Integer id){
        this.pessoaDAO.deletar(id);
    }
}
