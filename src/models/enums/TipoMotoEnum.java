package models.enums;

public enum TipoMotoEnum {

    NAKED('H',"Naked"),
    SCOOTER('S',"Scooter"),
    TRAIL('T',"Trail");

    private int codigo;
    private String descricao;

    TipoMotoEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static TipoMotoEnum fromCodigo(int codigo){
        TipoMotoEnum retorno = null;

        for (TipoMotoEnum tipo : values()){

            if(tipo.getCodigo() == codigo){
                retorno = tipo;
                break;
            }

        }
        return retorno;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
