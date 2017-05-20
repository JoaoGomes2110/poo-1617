import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Motos here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Moto extends Taxi implements Serializable
{
    public Moto(){
        super();
    }
    
    public Moto(int id,double ve, double p, double f, Ponto2D c,Motorista m, List<Viagem> historico){
        super(id,ve,p,f,c,m,historico);
    }
    
    public Moto(Moto m){
        super(m);
    }
}
