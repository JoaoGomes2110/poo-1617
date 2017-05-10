import java.util.*;
/**
 * Escreva a descrição da classe Taxi aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Taxi
{
    private double velocidade;
    private double preco;
    private double fiabilidade;
    private Ponto2D coordenadas;
    private List<Viagem> historico;
    
    public Taxi(){
        this.velocidade=0;
        this.preco=0;
        this.fiabilidade=0;
        
    }
}
