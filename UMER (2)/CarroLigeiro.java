import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class CarrosLigeiros here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class CarroLigeiro extends Taxi implements Serializable
{
    public CarroLigeiro(){
        super();
    }
    
    public CarroLigeiro(int id,double ve, double p, double f, Ponto2D c,Motorista m, List<Viagem> historico){
        super(id,ve,p,f,c,m,historico);
    }
    
    public CarroLigeiro(CarroLigeiro c){
        super(c);
    }
    
}
