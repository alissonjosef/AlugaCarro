package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Reserva extends Model{

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	final Calendar cal = Calendar.getInstance();
	
    
	private Date inicio;
    private Date fim ;
    private Pessoa cliente;
    private Veiculo veiculo;

    private Fatura fatura;                    // reserva tem um  ( 0 ou 1 fatura)
   
   

	public Reserva() {
		
	}

// contrutor sem fatura
	public Reserva(Integer id, Date inicio, Date fim, Pessoa cliente, Veiculo veiculo) {
		super(id);
		this.inicio = inicio;
		this.fim = fim;
		this.cliente = cliente;
		this.veiculo = veiculo;
	}


   

// contrutor com fatura
	public Reserva(Integer id, Date inicio, Date fim, Pessoa cliente, Veiculo veiculo, Fatura fatura) {
		super(id);
		this.inicio = inicio;
		this.fim = fim;
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.fatura = fatura;
	}

/*
	public long getDiasReservados() {
        long dt = (this.fim.getTime() - this.inicio.getTime());
        long dias = (dt / 86400000L);
        return dias;
    }
*/
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

    public Fatura getFatura() {
		return fatura;
	}


	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}


	@Override
	public String toString() {
		return "Reserva [inicio=" + inicio + ", fim=" + fim + "\n cliente=" + cliente + ", veiculo=" + veiculo + "]";
	}
    
    
    
}
