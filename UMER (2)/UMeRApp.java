import java.util.Scanner;
import java.util.GregorianCalendar;

/**
 * Escreva a descriçao da classe UMeR aqui.
 * 
 * @author (seu nome) 
 * @version (numero de versao ou data)
 */

public class UMeRApp {
   
    // Construtor privado
    private UMeRApp(){};

    // Menus da aplicaçao
    private static Menu menuInicial, menuCliente, menuMotorista;
    
    private static UMeR    umer;
    private static boolean sessao;
   
    // Metodo prinipal
    public static void main(String[] args) {
        
        umer = UMeR.initApp();
        
        do {
            //sessao = umer.sessaoIniciada();
            carregarMenus();
            menuInicial.executa();
          
            switch(menuInicial.getOpcao()){
                case 1:
                    login(1); 
                    sessao = umer.sessaoIniciada();
                    if(sessao) {menuCliente();}
                    break;
                case 2:
                    login(2);
                    sessao = umer.sessaoIniciada();
                    if(sessao) {menuMotorista();}
                    break;
                case 3:
                    registo();
                    break;
                
            }
        } while(menuInicial.getOpcao()!=0);
        System.out.println("\nA sair...");
        
    }
    
    // Outros metodos
    private static void carregarMenus(){
        
        String[] ops1 = {"Iniciar Sessao Cliente",
                         "Iniciar Sessao Motorista",
                         "Registo"};
        
        String[] ops2 = {"Ver Taxis Disponiveis",
                         "Solicitar Viagem Taxi Mais Proximo",
                         "Solicitar Viagem Taxi Especifico",
                         "Fazer Reserva",
                         "Ver Viagens Efetuadas"};
                         
        String[] ops3 = {"Sinalizar Disponibilidade",
                         "Registar Viagem",
                         "Registar Preço",
                         "Ver Viagens Efetuadas"};
        
        menuInicial   = new Menu(ops1);
        menuCliente   = new Menu(ops2);
        menuMotorista = new Menu(ops3);
        
    }
    
    private static void login(int a) {
        
        String email,nome,pass,morada,dataNasc;
        Scanner input = new Scanner(System.in);
        System.out.println("\nE-mail:");
        email = input.nextLine();
        System.out.println("\nPassword:");
        pass = input.nextLine();
        
        try{
            umer.iniciaSessao(email,pass,a);
        }catch(SemAutorizacaoException e) {
            System.out.println("\n"+e.getMessage());
        }
        
    }
    
    private static void registo() {
        
        String email, nome, pass, morada, sopcao;
        int dia, mes, ano, opcao;
        GregorianCalendar nascimento;
        Scanner input = new Scanner(System.in);
        
        System.out.println("\n* * * * * REGISTO * * * * *");
        System.out.println("\n(Aperte 0 para cancelar)");
        do { 
            System.out.println("\nEmail: ");
            email = input.nextLine();
            if (email.equals("0")) {
                System.out.println("\nRegisto cancelado!");
                return;                        /* go back */
            }
            if (email.trim().isEmpty() || email==null)
                System.out.println("Email invalido! Por favor tente outra vez.");
        } while(email.trim().isEmpty() || email==null);
        do {
            System.out.println("\nNome: ");
            nome = input.nextLine();
            if (nome.equals("0")) {
                System.out.println("\nRegisto cancelado!");
                return;                        /* go back */
            }
            if (nome.trim().isEmpty() || nome==null)
                System.out.println("Nome invalido! Por favor tente outra vez.");
        } while(nome.trim().isEmpty() || nome==null);
        do { 
            System.out.println("\nPassword: ");
            pass = input.nextLine();
            if (pass.equals("0")) {
                System.out.println("\nRegisto cancelado!");
                return;                        /* go back */
            }
            if (pass.trim().isEmpty() || pass==null)
                System.out.println("Password invalida! Por favor tente outra vez.");
        } while(pass.trim().isEmpty() || pass==null);
        do { 
            System.out.println("\nMorada: ");
            morada = input.nextLine();
            if (morada.equals("0")) {
                System.out.println("\nRegisto cancelado!");
                return;                        /* go back */
            }
            if (morada.trim().isEmpty() || morada==null)
                System.out.println("Morada invalida! Por favor tente outra vez.");
        } while(morada.trim().isEmpty() || morada==null);
        do { 
            System.out.println("\nDia de nascimento: (1-31)");
            dia = input.nextInt();
            if (dia==0) {
                System.out.println("\nRegisto cancelado!");
                return;                        /* go back */
            }
            if (dia<0 || dia>31) {
                System.out.println("\nDia invalido! Por favor tente outra vez.");
                input.nextLine();
            }
        } while(dia<0 || dia>31);
        do { 
            System.out.println("\nMes de nascimento: (1-12)");
            mes = input.nextInt();
            if (mes==0) {
                System.out.println("\nRegisto cancelado!");
                return;                        /* go back */
            }
            if (mes<0 || mes>12)
                System.out.println("\nMes invalido! Por favor tente outra vez.");
        } while(mes<0 || mes>12);
        do { 
            System.out.println("\nAno de nascimento:");
            ano = input.nextInt();
            if (ano==0) {
                System.out.println("\nRegisto cancelado!");
                return;                        /* go back */
            }
            if (ano<0 || Integer.toString(ano).length()!=4)
                System.out.println("\nAno invalido! Por favor tente outra vez.");
        } while(ano<0 || Integer.toString(ano).length()!=4);
        do {
            System.out.println("\n1 - Cliente ou 2 - Motorista?");
            opcao = input.nextInt();
            if (opcao==0) {
                System.out.println("\nRegisto cancelado!");
                return;                        /* go back */
            }
            if (opcao<0 || opcao>2)
                System.out.println("\nOpçao invalida! Por favor tente outra vez.");
        } while(opcao<0 || opcao>2);

        nascimento = new GregorianCalendar(ano,mes,dia);
        
        if(opcao==1) {
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
    
    private static void menuCliente() {
        
        do {
            menuCliente.executa();
        } while(menuCliente.getOpcao() !=0);
        sessao = false;
        
    }
    
    private static void menuMotorista() {
        
        do {
            menuMotorista.executa();
        } while(menuMotorista.getOpcao() !=0);
        sessao = false;
        
    }
    
}
