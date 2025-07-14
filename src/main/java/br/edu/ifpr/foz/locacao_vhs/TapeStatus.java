package br.edu.ifpr.foz.locacao_vhs;

public enum TapeStatus {

    DISPONIVEL("Disponível"),
    ALUGADO("Alugado"),
    MANUTENCAO("Em Manutenção"),
    PERDIDO("Perdido");
   
    private final String descricao;

    TapeStatus(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
