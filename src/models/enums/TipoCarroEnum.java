package models.enums;

public enum TipoCarroEnum {

    HATCH('H',"Hatch"),
    SEDAN('S',"Sedan"),
    PICAPE('P',"Picape");

    private char codigo;
    private String descricao;

    TipoCarroEnum(char codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static TipoCarroEnum fromCodigo(char codigo){
        TipoCarroEnum retorno = null;

        for (TipoCarroEnum tipo : values()){

            if(tipo.getCodigo()== codigo){
                retorno = tipo;
                break;
            }

        }
        return retorno;
    }

    public char getCodigo() {
        return codigo;
    }

    public void setCodigo(char codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
