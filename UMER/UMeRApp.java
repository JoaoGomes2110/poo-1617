
import java.util.Scanner;
import java.util.GregorianCalendar;
/**
 * Escreva a descrição da classe UMeR aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class UMeRApp
{
   private UMeRApp(){};
   private static UMeR umer;
   private static Menu menu,menuCliente;
   private static boolean sessao;
   
   
   public static void main(String[] args){
       umer = UMeR.initApp();
       do{
          sessao = umer.sessaoIniciada();
          carregarMenu();
          menu.executa();
          
          switch(menu.getOpcao()){
              case 1:
                    login(1); 
                    sessao = umer.sessaoIniciada();
                    if(sessao) {menuCliente();}
                    break;
              case 2:
                    login(2);  
                    break;
              case 3:
                    registo();
                    break;
                
            }
        }while(menu.getOpcao()!=0);
       System.out.println("A sair...");
    }
    
    public static void carregarMenu(){
        String[] lista = new String[] {"Iniciar Sessao Cliente","Iniciar Sessao Motorista","Registo"};
        
        
        String[] listaCliente = {"Ver quais taxis disponiveis","Solicitar viagem Taxi mais proximo",
                                "Solicitar viagem Taxi em especifico","Ver viagens efetuadas"};
        
        menu = new Menu(lista);
        menuCliente = new Menu(listaCliente);
    }
    
    public static void login(int a){
        String email,nome,pass,morada,dataNasc;
        Scanner input = new Scanner(System.in);
        System.out.println("E-mail:");
        email = input.nextLine();
        System.out.println("Password:");
        pass = input.nextLine();
        
        try{
            umer.iniciaSessao(email,pass,a);
        }catch(SemAutorizacaoException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void registo(){
        String email, nome, pass, morada;
        int dia, mes, ano, opcao;
        GregorianCalendar nascimento;
        Scanner input = new Scanner(System.in);
        
        System.out.println("E-mail:");
        email = input.nextLine();
        System.out.println("Nome");
        nome = input.nextLine();
        System.out.println("Password:");
        pass = input.nextLine();
        System.out.println("Morada:");
        morada = input.nextLine();
        
        System.out.println("Dia de nascimento:");
        dia = input.nextInt();
        System.out.println("Mês de nascimento:");
        mes = input.nextInt();
        System.out.println("Ano de nascimento:");
        ano = input.nextInt();
        
        System.out.println("1 - Cliente ou 2 - Motorista?");
        do{
            opcao = input.nextInt();
        }while((opcao<0) || (opcao>2));
        
        nascimento = new GregorianCalendar(ano,mes,dia);
        
        if(opcao==1){
            Cliente c = new Cliente(email,nome,pass,morada,nascimento);
            try{
                umer.registarAtor(c);
            }catch(UtilizadorExistenteException e){
                System.out.println(e.getMessage());
                return;
            }
        }else{
            Motorista m = new Motorista(email, nome, pass, morada, nascimento);
            try{
                umer.registarAtor(m);
            }catch(UtilizadorExistenteException e){
                System.out.println(e.getMessage());
                return;
            }
        }
    }
    
    public static void menuCliente(){
        
        do{
            menuCliente.executa();
            
        }while(menuCliente.getOpcao() !=0);
        sessao = false;
    }
}
