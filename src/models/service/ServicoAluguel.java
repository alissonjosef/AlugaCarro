package models.service;

import models.Fatura;
import models.Reserva;
import models.service.TaxaServico;

public class ServicoAluguel {

	private Double precoDia;
	private Double precoHora;
	
	
	private TaxaServico taxaServico;   // associaçao com a interface


	public ServicoAluguel(Double precoDia, Double precoHora, TaxaServico taxaServico) {
		super();
		this.precoDia = precoDia;
		this.precoHora = precoHora;
		this.taxaServico = taxaServico;
	}

	public void processoFatura(Reserva reserva) {                   // gera a fatura
		
		long tempo1= reserva.getInicio().getTime();                // getTime em milisegundos
		long tempo2=reserva.getFim().getTime();
		double horas = (double)(tempo2-tempo1)/1000 /60/60;        // converter miliseg para segundos(/1000) de seg. minutos(/60)e seg. para horas  (/60)         
		
		double pagamentoBasico;	
		
		
		if(horas <=12.0) {
			pagamentoBasico=Math.ceil(horas)*precoHora;
		
		}else {
			pagamentoBasico=Math.ceil(horas/24)*precoDia;
			
		}
		
		double taxa = taxaServico.taxa(pagamentoBasico);                      // cacular o valor do imposto a partir da quantidade passada como parametro
			
			reserva.setFatura(new Fatura(pagamentoBasico,taxa));
		}
	
	

}

