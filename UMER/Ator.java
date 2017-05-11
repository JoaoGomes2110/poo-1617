import java.util.GregorianCalendar;
/**
 * Escreva a descrição da classe Ator aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Ator
{
   private String email;
   private String nome;
   private String pass;
   private String morada;
   private GregorianCalendar dataNasc;
   
   // Construtores
   public Ator() {
     this.email = "";
     this.nome = "";
     this.pass = "";
     this.morada = "";
     this.dataNasc = new GregorianCalendar();
   } 
   
   public Ator(String email, String nome, String pass, String morada, GregorianCalendar dataNasc) {
     this.email = email;
     this.nome = nome;
     this.pass = pass;
     this.morada = morada;
     this.dataNasc = dataNasc;
   } 
   
   public Ator(Ator a){
     this.email = a.getEmail();
     this.nome = a.getNome();
     this.pass = a.getPass();
     this.morada = a.getMorada();
     this.dataNasc = a.getDataNasc();
    }
   
   public String getEmail(){
       return this.email;
    }
    
   public String getNome(){
       return this.nome;
    }
    
   public String getPass(){
       return this.pass;
    } 
    
   public String getMorada(){
       return this.morada;
    } 
    
   public GregorianCalendar getDataNasc(){
       return this.dataNasc;
    }  
    
   public String toString(){
       StringBuilder s = new StringBuilder();
       s.append("Email: ");
       s.append(this.email);
       s.append("\n");
       s.append("Nome: ");
       s.append(this.nome);
       s.append("\n");
       s.append("Pass: ");
       s.append(this.pass);
       s.append("\n");
       s.append("Morada");
       s.append(this.morada);
       s.append("\n");
       s.append("Data de Nascimento: ");
       s.append(this.dataNasc);
       s.append("\n");
       return s.toString();
    }
    
   public  Ator clone(){
     return new Ator(this);  
    }
    
   public boolean equals(Object o){
       if(o == this)
        return true;
       if(o == null || o.getClass() != this.getClass())
        return false;
       Ator a = (Ator)o;
       return (a.getEmail().equals(this.email) && a.getNome().equals(this.nome) && a.getPass().equals(this.pass) && a.getMorada().equals(this.morada) && a.getDataNasc().equals(this.dataNasc));
   }
    
    
   
    
    
    
    
    
    
    
    
    
}
