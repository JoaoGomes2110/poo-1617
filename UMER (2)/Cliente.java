import java.util.*;

/**
 * Escreva a descriçao da classe Cliente aqui.
 * 
 * @author (seu nome) 
 * @version (numero de versao ou data)
 */

public class Cliente extends Ator {
    
    private Ponto2D coordenadas;
    private List<Viagem> historico;
    
    public Cliente() {
        
        super();
        this.coordenadas = new Ponto2D();
        this.historico   = new ArrayList<Viagem>();
    
    }
    
    public Cliente(String e, String n, String p, String m, GregorianCalendar d) {
        
        super(e,n,p,m,d);
        this.coordenadas = new Ponto2D();
        this.historico   = new ArrayList<Viagem>();
        
    }
    
    public Cliente(Cliente c) {
        
        super(c);
        this.coordenadas = c.getCoordenadas();
        this.historico   = c.getHistorico();
        
    }
    
    public Ponto2D getCoordenadas() {
        
        return this.coordenadas;
    
    }
    
    public List<Viagem> getHistorico() {
        
        ArrayList<Viagem> aux = new ArrayList<Viagem>(this.historico.size());
        for(Viagem v: this.historico)
            aux.add(v.clone());
            
        return aux;
        
    }
    
    public Cliente clone(){
        return new Cliente(this);
    }
    
    public boolean equals(Object o){
        if(o == this)
            return true;
        if(o == null || o.getClass() != this.getClass())
            return false;
        Cliente c = (Cliente)o;
        return (super.equals(c) && c.getCoordenadas().equals(this.coordenadas) && c.getHistorico().equals(this.historico));
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Coordenadas: ");
        sb.append(this.coordenadas.toString());
        sb.append("\n");
        sb.append("Historico ");
        sb.append(this.historico.toString());
        sb.append("\n");
        return sb.toString();
    }
    
}
