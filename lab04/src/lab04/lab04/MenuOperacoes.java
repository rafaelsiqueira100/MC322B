
public enum MenuOperacoes{
    CADASTRAR (1) ,
    LISTAR(operacao:2),
    EXCLUIR (3) ,
    GERAR_SINISTRO (operacao:4),
    TRANSFERIR_SEGURO(5),
    CALCULAR_RECEITA_SEGURADORA(6),
    SAIR (0) ;

    public final int operacao ;
    MenuOperacoes (int operacao) {
        this.operacao = operacao ;
    }

    public int getOperacao() {
        return this.operacao ;
    }
}

public enum MenuOperacoesCadastrar{
    CADASTRAR_CLIENTE (1) ,
    CADASTRAR_VEICULO(operacao:2),
    CADASTRAR_SEGURADORA (3) ,
    VOLTAR (4) ;

    public final int operacao ;
    MenuOperacoesCadastrar (int operacao) {
        this.operacao = operacao ;
    }

    public int getOperacao() {
        return this.operacao ;
    }
}
public enum MenuOperacoesListar{
    LISTAR_CLIENTE (1) ,
    LISTAR_SINISTROS_SEGURADORA(operacao:2),
    LISTAR_SINISTROS_CLIENTE (3) ,
    LISTAR_VEICULOS_CLIENTE(4),
    LISTAR_VEICULOS_SEGURADORA(5),
    VOLTAR (6) ;

    public final int operacao ;
    MenuOperacoesCadastrar (int operacao) {
        this.operacao = operacao ;
    }

    public int getOperacao() {
        return this.operacao ;
    }
}
public enum MenuOperacoesExcluir{
    EXCLUIR_CLIENTE (1) ,
    EXCLUIR_VEICULO(operacao:2),
    EXCLUIR_SINISTRO (3) ,
    VOLTAR (4) ;

    public final int operacao ;
    MenuOperacoesCadastrar (int operacao) {
        this.operacao = operacao ;
    }

    public int getOperacao() {
        return this.operacao ;
    }
}