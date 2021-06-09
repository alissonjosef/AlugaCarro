package models;

import java.math.BigDecimal;

public class Fatura {

    private Double pagamentoBasico;

    private Double pagamentoTaxa;

 //   private Reserva reserva;

    public Fatura(){}

    public Fatura(Double pagamentoBasico,Double pagamentoTaxa) {
        this.pagamentoBasico = pagamentoBasico;
        this.pagamentoTaxa = pagamentoTaxa;
      
    }
/*
    public BigDecimal getValorFatura(){
        long dias = this.reserva.getDiasReservados();
        return this.reserva.getVeiculo().getValorAluguel(dias);
    }
*/
    
  

	public Double getPagamentoBasico() {
		return pagamentoBasico;
	}

	public void setPagamentoBasico(Double pagamentoBasico) {
		this.pagamentoBasico = pagamentoBasico;
	}

	public Double getPagamentoTaxa() {
		return pagamentoTaxa;
	}

	public void setPagamentoTaxa(Double pagamentoTaxa) {
		this.pagamentoTaxa = pagamentoTaxa;
	}
	
	public Double getpagamentoTotal() {
		
		return getPagamentoBasico() + getPagamentoTaxa();
	}
}    
    
