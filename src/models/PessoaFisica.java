package models;

import java.util.Calendar;
import java.util.Date;

public class PessoaFisica extends Pessoa{

    private String cpf;

    private Date dataNascimento;

    private String cnh;

    public PessoaFisica() {
    }

    public PessoaFisica(Integer id, String nome, String endereco, boolean ativo, String cpf, Date dataNascimento, String cnh) {
        super(id, nome, endereco, ativo);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.cnh = cnh;
    }

    public int getIdade(){
        Calendar dataNascimento = Calendar.getInstance();

        dataNascimento.setTime(this.dataNascimento);

        Calendar hoje = Calendar.getInstance();

        int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);

        if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
            idade--;
        }
        else
        {
            if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
                idade--;
            }
        }

        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    @Override
    public String toString() {
        return 	"PessoaFisica:" +super.toString()+"\n"+
                "Cpf=" + cpf + '\'' +
                "\nData de Nascimento=" + dataNascimento +
                "\nCnh='" + cnh + '\'';
           
    }
}
