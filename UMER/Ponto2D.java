
/**
 * Escreva a descrição da classe Ponto2D aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Ponto2D
{
    private int x; // ou double??
    private int y;
    
    public Ponto2D(){ 
        this.x = 0;
        this.y = 0;
    }
    
    public Ponto2D(int x, int y) { 
        this.x = x; this.y = y; 
    }
    
    public Ponto2D(Ponto2D p) { 
        x = p.getX(); 
        y = p.getY(); 
    }
    
    public int getX() { return this.x; }
    public int getY() { return this.y; }
    
}
