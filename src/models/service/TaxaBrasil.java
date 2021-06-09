package models.service;

public class TaxaBrasil implements TaxaServico{

	
	public double taxa(double valor) {
		
		if(valor <=100) {
			
			return valor * 0.2;
		}else {
			
			return valor * 0.15;
		}
	}
	}

