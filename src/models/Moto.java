package models;

import models.enums.TipoCorEnum;
import models.enums.TipoMotoEnum;

import java.math.BigDecimal;

public class Moto extends Veiculo{

    private TipoMotoEnum tipo;

    private BigDecimal seguroAdicional;

    public Moto(){}

    public Moto(Integer id, String placa, boolean alugado, TipoCorEnum cor, long kilometragem, BigDecimal valorDiaria, String marca, TipoMotoEnum tipo) {
        super(id, placa, alugado, cor, kilometragem, valorDiaria, marca, 2);
        this.tipo = tipo;

    }

    public Moto(String placa, TipoCorEnum cor, String marca, long kilometragem, BigDecimal valorDiaria, TipoMotoEnum tipo) {
        super(placa, cor, marca, kilometragem, valorDiaria, 2);
        this.tipo = tipo;
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
