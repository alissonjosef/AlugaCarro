package models;

import java.math.BigDecimal;

public class Fatura {

    private BigDecimal pagamentoBasico;

    private BigDecimal pagamentoTaxa;

    private Reserva reserva;

    public Fatura(){}

    public Fatura(BigDecimal pagamentoBasico, BigDecimal pagamentoTaxa, Reserva reserva) {
        this.pagamentoBasico = pagamentoBasico;
        this.pagamentoTaxa = pagamentoTaxa;
        this.reserva = reserva;
    }

    public BigDecimal getValorFatura(){
        long dias = this.reserva.getDiasReservados();
        return this.reserva.getVeiculo().getValorAluguel(dias);
    }

}
