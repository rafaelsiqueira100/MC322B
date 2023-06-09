//package lab05;
public enum CalcSeguro{
     VALOR_BASE (100.0),
     FATOR_18_30 (1.2),
     FATOR_30_60 (1.0), 
     FATOR_60_90 (1.5);
     public final double fator;
     CalcSeguro(double valor ){
          this.fator = valor;
     }
     public double getFator(){
          return fator;
          
     }
     public String toString() {
    	 return Double.toString(fator);
     }
}