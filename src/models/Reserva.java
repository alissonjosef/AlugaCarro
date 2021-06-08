package models;

import java.util.Date;

public class Reserva extends Model{

    private Date inicio;
    private Date fim;
    private Pessoa cliente;
    private Veiculo veiculo;

    
   
    
    public Reserva(Integer id, Integer inicio, Integer fim, Pessoa cliente, Veiculo veiculo) {
		super(id);
		this.inicio = inicio;
		this.fim = fim;
		this.cliente = cliente;
		this.veiculo = veiculo;
	}

	

    public Integer getDiasReservados() {
        Integer dt = (this.fim.getTime() - this.inicio.getTime());
        Integer dias = (dt / 86400000L);
        return dias;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }



	@Override
	public String toString() {
		return "Reserva [inicio=" + inicio + ", fim=" + fim + ", cliente=" + cliente + ", veiculo=" + veiculo + "]";
	}
    
    
    
}
