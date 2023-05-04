
public enum MenuOperacoes{
    CADASTRAR (1) ,
    LISTAR(operacao:2),
    EXCLUIR (3) ,
    GERAR_SINISTRO (operacao:4),
    TRANSFERIRSINISTRO
    SAIR (0) ;

    public final int operacao ;
    MenuOperacoes (int operacao) {
        this.operacao = operacao ;
    }

    public int getOperacao() {
        return this.operacao ;
    }
}