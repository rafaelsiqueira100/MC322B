package lab05;
public enum MenuOperacoesCadastrar{

    VOLTAR (0) ,
    CADASTRAR_CLIENTE (1) ,
    CADASTRAR_VEICULO(2),
    CADASTRAR_SEGURADORA (3) ;

    public final int operacao ;
    MenuOperacoesCadastrar (int operacao) {
        this.operacao = operacao ;
    }

    public int getOperacao() {
        return this.operacao ;
    }
}