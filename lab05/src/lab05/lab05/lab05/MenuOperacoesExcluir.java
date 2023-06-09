package lab05;
public enum MenuOperacoesExcluir{
    VOLTAR (0) ,
    EXCLUIR_CLIENTE (1) ,
    EXCLUIR_VEICULO(2),
    EXCLUIR_SINISTRO (3) ;

    public final int operacao ;
    MenuOperacoesExcluir (int operacao) {
        this.operacao = operacao ;
    }

    public int getOperacao() {
        return this.operacao ;
    }
    public String toString() {
		return "{MenuOperacoesExcluir{operacao: "+Integer.toString(operacao)+"}}";
	}
}