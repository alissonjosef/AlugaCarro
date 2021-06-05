package models;

import models.enums.TipoCorEnum;

import java.math.BigDecimal;

public abstract class Veiculo extends Model{

    private String placa;

    private boolean alugado = false;

    private String marca;

    private TipoCorEnum cor;

    private long kilometragem = 0;

    private int quantidadePassageiros = 0;

    //NO JAVA SEMPRE EH BOM UTILIZAR BIGDECIMAL PARA TRATAR DE VALORES FINANCEIROS
    private BigDecimal valorDiaria;

    public Veiculo(){}

    public Veiculo(Integer id, String placa, boolean alugado, TipoCorEnum cor, long kilometragem, BigDecimal valorDiaria, String marca, int quantidadePassageiros) {
        super(id);
        this.placa = placa;
        this.alugado = alugado;
        this.cor = cor;
        this.kilometragem = kilometragem;
        this.valorDiaria = valorDiaria;
        this.marca = marca;
        this.quantidadePassageiros = quantidadePassageiros;
    }

    //Sobrecarga de metodo utilizada para inserir um novo veiculo
    public Veiculo(String placa, TipoCorEnum cor, String marca, long kilometragem, BigDecimal valorDiaria, int quantidadePassageiros) {
        this.placa = placa;
        this.cor = cor;
        this.marca = marca;
        this.kilometragem = kilometragem;
        this.valorDiaria = valorDiaria;
        this.quantidadePassageiros = quantidadePassageiros;
    }

    public BigDecimal getValorAluguel(long quantidadeDeDias){
        return this.valorDiaria.multiply(new BigDecimal(quantidadeDeDias));
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public TipoCorEnum getCor(){
        return this.cor;
    }

    public void setCor(TipoCorEnum cor){
        this.cor = cor;
    }

    public long getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(long kilometragem) {
        this.kilometragem = kilometragem;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public int getQuantidadePassageiros() {
        return quantidadePassageiros;
    }

    public void setQuantidadePassageiros(int quantidadePassageiros) {
        this.quantidadePassageiros = quantidadePassageiros;
    }
}
