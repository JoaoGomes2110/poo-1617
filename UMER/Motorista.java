import java.util.*;
/**
 * Escreva a descrição da classe Motorista aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Motorista extends Ator
{
    private int fator;
    private int classificacao;
    private List<Viagem> historico;
    private double KmsTotal;
    private boolean disponibilidade;
    
    public Motorista(){
        super();
        this.fator = 0;
        this.classificacao = 0;
        this.KmsTotal = 0;
        this.disponibilidade = true;
        this.historico = new ArrayList<Viagem>();
    }
    
    public Motorista(String e, String n, String p, String m, GregorianCalendar d){
        super(e,n,p,m,d);
        this.fator = 0;
        this.classificacao = 0;
        this.KmsTotal = 0;
        this.disponibilidade = true;
        this.historico = new ArrayList<Viagem>();
    }
    
    public Motorista(String e, String n, String p, String m, GregorianCalendar d, int f, int cla, double kms, boolean disp, List<Viagem> historico){
        super(e,n,p,m,d);
        this.fator = f;
        this.classificacao = cla;
        this.KmsTotal = kms;
        this.disponibilidade = disp;
        this.historico = new ArrayList<Viagem>();
        for(Viagem v: historico)
            this.historico.add(v.clone());
    }
    
    public Motorista(Motorista m){
        super(m);
        this.fator = m.getFator();
        this.classificacao = m.getClassificacao();
        this.KmsTotal = m.getKms();
        this.disponibilidade = m.getDisponibilidade();
        this.historico = m.getHistorico();
    }
    
    public int getFator(){
        return this.fator;
    }
    
    public int getClassificacao(){
        return this.classificacao;
    }
    
    public double getKms(){
        return this.KmsTotal;
    }
    
    public boolean getDisponibilidade(){
        return this.disponibilidade;
    }
    
    public List<Viagem> getHistorico(){
        ArrayList<Viagem> aux = new ArrayList<Viagem>(this.historico.size());
        for(Viagem v: this.historico)
            aux.add(v.clone());
        return aux;
    }
    
    public Motorista clone(){
        return new Motorista(this);
    }
    
    public boolean equals(Object o){
        if(o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        Motorista m = (Motorista)o;
        return (super.equals(m) && m.getFator() == this.fator && m.getClassificacao() == this.classificacao && m.getKms() == this.KmsTotal && m.getDisponibilidade() == this.disponibilidade && m.getHistorico().equals(this.historico));
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Fator: ");
        sb.append(this.fator);
        sb.append("\n");
        sb.append("Classificacao: ");
        sb.append(this.classificacao);
        sb.append("\n");
        sb.append("Kms Totais: ");
        sb.append(this.KmsTotal);
        sb.append("\n");
        sb.append("Disponibilidade: ");
        sb.append(this.disponibilidade);
        sb.append("\n");
        sb.append("Historico: ");
        sb.append(this.historico.toString());
        sb.append("\n");
        return sb.toString();
    }
}
