package models;

import models.enums.TipoCarroEnum;
import models.enums.TipoCorEnum;

import java.math.BigDecimal;

public class Carro extends Veiculo{

    private TipoCarroEnum tipo;

    public Carro(){}

    
  

	public Carro(Integer id, String placa, String marca, String modelo, TipoCorEnum cor, long kilometragem,
			int quantidadePassageiros, TipoCarroEnum tipo) {
		super(id, placa, marca, modelo, cor, kilometragem, quantidadePassageiros);
		this.tipo = tipo;
	}

	

    public Carro(Integer id, String placa, boolean alugado, String marca, String modelo, TipoCorEnum cor,
			long kilometragem, int quantidadePassageiros, BigDecimal valorDiaria, TipoCarroEnum tipo) {
		super(id, placa, alugado, marca, modelo, cor, kilometragem, quantidadePassageiros, valorDiaria);
		this.tipo = tipo;
	}





	public TipoCarroEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoCarroEnum tipo) {
        this.tipo = tipo;
    }

	@Override
	public String toString() {
		return "Carro" + tipo +super.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	

//EXEMPLO DE SOBRECARGA DE METODO
//    public void setId() {
//
//        super.setId(Raom);
//    }
//
//    public void setId(String x, Integer y){
//
//    }
//
//    public void setId(){
//
//    }
    
    
    
}
