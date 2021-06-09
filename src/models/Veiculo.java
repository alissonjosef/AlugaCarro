package models;

import models.enums.TipoCorEnum;

import java.math.BigDecimal;

public abstract class Veiculo extends Model{

    private String placa;

    private boolean alugado = false;

    private String marca;
   
    private String modelo;

    private TipoCorEnum cor;

    private long kilometragem = 0;

    private int quantidadePassageiros = 0;

    //NO JAVA SEMPRE EH BOM UTILIZAR BIGDECIMAL PARA TRATAR DE VALORES FINANCEIROS
    private BigDecimal valorDiaria;

    public Veiculo(){}

    
  

   
	public Veiculo(Integer id, String placa, boolean alugado, String marca, String modelo, TipoCorEnum cor,
			long kilometragem, int quantidadePassageiros, BigDecimal valorDiaria) {
		super(id);
		this.placa = placa;
		this.alugado = alugado;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.kilometragem = kilometragem;
		this.quantidadePassageiros = quantidadePassageiros;
		this.valorDiaria = valorDiaria;
	}



	public Veiculo(Integer id, String placa, String marca, String modelo, TipoCorEnum cor, long kilometragem,
			int quantidadePassageiros) {
		super(id);
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.kilometragem = kilometragem;
		this.quantidadePassageiros = quantidadePassageiros;
	}




// atributo poderia passar para metodo e assim fazer a subscrita nas classes filhas
	
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

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
    
}
