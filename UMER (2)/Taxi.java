import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Taxi implements Serializable{
    
    private int idTaxi;
    private double velocidade;
    private double preco;
    private double fiabilidade;
    private Ponto2D coordenadas;
    private Motorista motorista;
    private List<Viagem> historico;
    
    public Taxi() {
        
        this.idTaxi      = 0;  
        this.velocidade  = 0;
        this.preco       = 0;
        this.fiabilidade = 0;
        this.coordenadas = new Ponto2D();
        this.motorista = new Motorista();
        this.historico   = new ArrayList<Viagem>();
        
    }
    
    public Taxi(int id,double ve, double p, double f, Ponto2D c,Motorista m, List<Viagem> historico) {
        
        this.idTaxi      = id;
        this.velocidade  = ve;
        this.preco       = p;
        this.fiabilidade = f;
        this.coordenadas = c;
        this.motorista   = new Motorista(m);
        for(Viagem v: historico)
            this.historico.add(v.clone());
            
    }
    
    public Taxi(Taxi t) {
        
        this.idTaxi      = t.getIdTaxi();
        this.velocidade  = t.getVelocidade();
        this.preco       = t.getPreco();
        this.fiabilidade = t.getFiabilidade();
        this.coordenadas = t.getCoordenadas();
        this.motorista   = t.getMotorista();
        this.historico   = t.getHistorico();
        
    }
    
    public int getIdTaxi(){
        
        return this.idTaxi;
        
    }
    
    public double getVelocidade() {
        
        return this.velocidade;
        
    }
    
    public double getPreco() {
        
        return this.preco;
        
    }
    
    public double getFiabilidade() {
        
        return this.fiabilidade;
        
    }
    
    public Ponto2D getCoordenadas() {
        
        return this.coordenadas;
        
    }
    
    public Motorista getMotorista(){
        
        return this.motorista; 
    
    }
    
    public List<Viagem> getHistorico() {
        
        ArrayList<Viagem> aux = new ArrayList<Viagem>(this.historico.size());
        for(Viagem v: this.historico)
            aux.add(v.clone());
            
        return aux;
        
    }
    
    public Taxi clone(){
        return new Taxi(this);
    }
    
    public boolean equals(Object o){
        if(o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        Taxi t = (Taxi)o;
        return (t.getVelocidade() == this.velocidade && t.getPreco() == this.preco && t.getFiabilidade() == this.fiabilidade && t.getCoordenadas().equals(this.coordenadas) && t.getMotorista().equals(this.motorista) && t.getHistorico().equals(this.historico));
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Velocidade: ");
        sb.append(this.velocidade);
        sb.append("\n");
        sb.append("Preco: ");
        sb.append(this.preco);
        sb.append("\n");
        sb.append("Fiabilidade: ");
        sb.append(this.fiabilidade);
        sb.append("\n");
        sb.append("Coordenadas: ");
        sb.append(this.coordenadas.toString());
        sb.append("\n");
        sb.append("Motorista: ");
        sb.append(this.motorista.toString());
        sb.append("\n");
        sb.append("Historico ");
        sb.append(this.historico.toString());
        sb.append("\n");
        return sb.toString();
    }
    
}