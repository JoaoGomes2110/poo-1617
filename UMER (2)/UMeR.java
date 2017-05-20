import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
/**
 * Escreva a descriçao da classe UMeR aqui.
 * 
 * @author (seu nome) 
 * @version (numero de versao ou data)
 */

public class UMeR {
    
    private Ator sessao;
    private HashMap<String,Cliente>   clientes;
    private HashMap<String,Motorista> motoristas;
    private HashMap<Integer,Taxi> taxis;
    
    public UMeR() {
       
        sessao          = null;
        this.clientes   = new HashMap<>();
        this.motoristas = new HashMap<>();       
        this.taxis      = new HashMap<>();
    }
   
    public static UMeR initApp() {
       
        UMeR nova = new UMeR();
       
        nova.sessao = null;
        return nova;
    
    }
   
    /**
     * variavel 'a' -> 1 = cliente
     *              -> 2 = motorista 
     */
    public void iniciaSessao(String email,String pass,int a) throws SemAutorizacaoException {
       
        if(a==1) sessao = clientes.get(email);
        if(a==2) sessao = motoristas.get(email);
       
        if(sessao!=null){
            if(!sessao.getPass().equals(pass)){
                sessao = null;
                throw new SemAutorizacaoException("\nPassword Incorreta!");
            }
        } else {
            throw new SemAutorizacaoException("O e-mail " + email + " nao esta registado!");
        }
        System.out.println("\nLogin efetuado com sucesso!");
    
    }
    
    public boolean sessaoIniciada() {
        
        return(sessao != null);
    
    }
    
    /**
     * nao podem ter o mesmo email mesmo que sejam atores diferentes
     */
    public void registarAtor(Ator a) throws UtilizadorExistenteException {
        
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
        } else{
            Motorista m = (Motorista) a;
            motoristas.put(m.getEmail(),m);
        }
        System.out.println("\nRegistado com Sucesso!");
        
    }
    
    public HashMap<Integer,Motorista> getDisponiveis(){
        HashMap<Integer,Motorista> disponiveis = new HashMap<>();
        for(Taxi t: taxis.values()){
            Motorista m = t.getMotorista();
            if(m.getDisponibilidade() == true){
                disponiveis.put(t.getIdTaxi(),m);
            }
        }
        return disponiveis;
    }
    
    public void setDisponiveis(Taxi t){
        Motorista m = t.getMotorista();
        m.setDisponibilidade(true);
    }
    /*
        public String toString() {
        StringBuilder sb = new StringBuilder("********* Clientes *********\n");
        sb.append(this.clientes.values()
                               .stream()
                               .map(Cliente::toString)
                               .collect(joining("\n")));
        return sb.toString();
    }
    
    // Metodos para gravar em ficheiro de objecto e de texto;
    public void gravaObj(String fich) throws IOException { 
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fich)); 
        oos.writeObject(this); 
        
        oos.flush(); 
        oos.close(); 
    } 
    
    public static UMeR leObj(String fich) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fich));
      
        UMeR te= (UMeR) ois.readObject();
        
        ois.close();
        return te;
    }

    public void log(String f, boolean ap) throws IOException {
        FileWriter fw = new FileWriter(f, ap);
        fw.write("\n----------- LOG - LOG - LOG - LOG - LOG ----------------\n");
        fw.write(this.toString());
        fw.write("\n----------- LOG - LOG - LOG - LOG - LOG ----------------\n");
        fw.flush();
        fw.close();
    }*/
    
}
