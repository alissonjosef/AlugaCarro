package models;

import models.enums.TipoCarroEnum;
import models.enums.TipoCorEnum;

import java.math.BigDecimal;

public class Carro extends Veiculo{

    private TipoCarroEnum tipo;

    public Carro(){}

    public Carro(Integer id, String placa, boolean alugado, TipoCorEnum cor, long kilometragem, BigDecimal valorDiaria, String marca, TipoCarroEnum tipo) {
        super(id, placa, alugado, cor, kilometragem, valorDiaria, marca, 4);
        this.tipo = tipo;
    }

    public Carro(String placa, TipoCorEnum cor, String marca, long kilometragem, BigDecimal valorDiaria, TipoCarroEnum tipo) {
        super(placa, cor, marca, kilometragem, valorDiaria, 4);
        this.tipo = tipo;
    }

    public TipoCarroEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoCarroEnum tipo) {
        this.tipo = tipo;
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
