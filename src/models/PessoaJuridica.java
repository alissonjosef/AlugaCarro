package models;

public class PessoaJuridica extends Pessoa{
    private String cnpj;

    public PessoaJuridica() {
    }

    public PessoaJuridica(Integer id, String nome, String endereco, boolean ativo, String cnpj) {
        super(id, nome, endereco, ativo);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
