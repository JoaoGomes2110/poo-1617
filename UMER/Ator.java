
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
   private String dataNasc;
   
   // Construtores
   public Ator() {
     this.email = "";
     this.nome = "";
     this.pass = "";
     this.morada = "";
     this.dataNasc = "";
   } 
   
   public Ator(String email, String nome, String pass, String morada, String dataNasc) {
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
    
   public String getDataNasc(){
       return this.dataNasc;
    }  
    
   public String toString(){
       StringBuilder s = new StringBuilder();
       s.append("Nome");
       s.append(this.nome);
       
       return s.toString();
    }
    
   public  Ator clone(){
     return new Ator(this);  
    }
    
   
    
    
    
    
    
    
    
    
    
}
