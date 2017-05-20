import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class CarrinhasDeNove here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CarrinhaDeNoveLugares extends Taxi implements Serializable
{
    public CarrinhaDeNoveLugares(){
        super();
    }
    
    public CarrinhaDeNoveLugares(int id,double ve, double p, double f, Ponto2D c,Motorista m, List<Viagem> historico){
        super(id,ve,p,f,c,m,historico);
    }
    
    public CarrinhaDeNoveLugares(CarrinhaDeNoveLugares c){
        super(c);
    }
}
