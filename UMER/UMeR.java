import java.util.Map;
import java.util.HashMap;
/**
 * Escreva a descrição da classe UMeR aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class UMeR
{
   private Ator sessao;
   private HashMap<String,Cliente> clientes;
   private HashMap<String,Motorista> motoristas;
   
   public UMeR(){
       sessao = null;
       this.clientes = new HashMap<>();
       this.motoristas = new HashMap<>();
    }
   
   public static UMeR initApp(){
       UMeR nova = new UMeR();
       
       nova.sessao = null;
       return nova;
    }
   
   /**
    * variavel 'a' -> 1 = cliente
    *              -> 2 = motorista 
    */
   public void iniciaSessao(String email,String pass,int a) throws SemAutorizacaoException{
       if(a==1) sessao = clientes.get(email);
       if(a==2) sessao = motoristas.get(email);
       
       if(sessao!=null){
           if(!sessao.getPass().equals(pass)){
               sessao = null;
               throw new SemAutorizacaoException("Password Incorreta.");
            }
        }else {
            throw new SemAutorizacaoException("O email " + email + " nao esta registado");
        }
        System.out.println("Login efetuado com sucesso");
    }
    
   public boolean sessaoIniciada() {
        return(sessao != null);
    }
    
   /**
    * nao podem ter o mesmo email mesmo que sejam atores diferentes
    */
   public void registarAtor(Ator a) throws UtilizadorExistenteException{
       boolean existe = clientes.containsKey(a.getEmail());
       if(!existe) {
           existe = motoristas.containsKey(a.getEmail());
        }
        
       if(existe) {
           throw new UtilizadorExistenteException();
        }
        
       if(a instanceof Cliente) {
           Cliente c = (Cliente) a;
           clientes.put(c.getEmail(),c);
        }else{
            Motorista m = (Motorista) a;
            motoristas.put(m.getEmail(),m);
        }
        System.out.println("Registado com Sucesso");
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
