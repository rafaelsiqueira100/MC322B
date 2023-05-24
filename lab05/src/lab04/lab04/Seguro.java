public class Seguro{
    private final int Id;
    private Date dataInicio;
    private Date dataFim;
    private Seguradora seguradora;
    private ArrayList listaSinistros;
    private ArrayList listaCondutores;
    private int valorMensal;
    private static ultimoId = -1;
    public Seguro(Date dataInicio, Date dataFim, Seguradora seguradora,
    int valorMensal){
        this.Id = ++ultimoId;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList();
        this.listaCondutores = new ArrayList();
        this.valorMensal = calculaValor();
    }
    public void desautorizarCondutor();
    public void autorizarCondutor();
    public void calcularValor(){
        (VALOR_BASE * FATOR_IDADE * (1+1))
    }
    public Sinistro gerarSinistro();
}