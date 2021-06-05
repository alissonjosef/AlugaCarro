package models.enums;

public enum TipoCorEnum {

    BRANCO("BRANCO","Branco"),
    PRETO("PRETO","Preto"),
    PRATA("PRATA","Prata"),
    VERMELHO("VERMELHO","Vermelho");

    private String codigo;
    private String descricao;

    TipoCorEnum(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static TipoCorEnum fromCodigo(String codigo){
        TipoCorEnum retorno = null;

        for (TipoCorEnum tipo : values()){

            if(tipo.getCodigo().equalsIgnoreCase(codigo)){
                retorno = tipo;
                break;
            }

        }
        return retorno;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
