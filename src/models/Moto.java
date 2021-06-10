package models;

import models.enums.TipoCorEnum;
import models.enums.TipoMotoEnum;

import java.math.BigDecimal;

public class Moto extends Veiculo{

 

	private TipoMotoEnum tipo;

    private BigDecimal seguroAdicional;

    public Moto(){}

    
 
    public Moto(Integer id, String placa, String marca, String modelo, TipoCorEnum cor, long kilometragem,
			int quantidadePassageiros, TipoMotoEnum tipo) {
		super(id, placa, marca, modelo, cor, kilometragem, quantidadePassageiros);
		this.tipo = tipo;
	}


    public Moto(Integer id, String placa, boolean alugado, String marca, String modelo, TipoCorEnum cor,
			long kilometragem, int quantidadePassageiros, BigDecimal valorDiaria, TipoMotoEnum tipo,
			BigDecimal seguroAdicional) {
		super(id, placa, alugado, marca, modelo, cor, kilometragem, quantidadePassageiros, valorDiaria);
		this.tipo = tipo;
		this.seguroAdicional = seguroAdicional;
	}




	

	public TipoMotoEnum getTipo() {
        return tipo;
    }


     public void setTipo(TipoMotoEnum tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getSeguroAdicional() {
        return seguroAdicional;
    }

    public void setSeguroAdicional(BigDecimal seguroAdicional) {
        this.seguroAdicional = seguroAdicional;
    }
    
    

	@Override
	public String toString() {
		return "Moto tipo=" + tipo + ", seguroAdicional=" + seguroAdicional + super.toString();
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
