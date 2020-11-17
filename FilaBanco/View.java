package FilaBanco;

public class View extends Controller {
  public static void painel(){
    System.out.println("Bem vindo ao banco!");
    System.out.println("Pegue uma senha");
    System.out.println("1 - Prefencial");
    System.out.println("2 - Comum");
    System.out.println("3 - Ver Filas");
    System.out.println("4 - Cliente Atentido (esvazia 1 da fila)");
    System.out.println("10 - Sair");
  }

  public static void popula(){
    populaCincoPessoas();
    System.out.println("");
    System.out.println("Adicionamos 5 pessoas na fila");
    System.out.println("");
  }

  public static void escolhaSenha(String tipo){
    String[] fila = tipo == "preferencial" ? filaPreferencial : filaNormal;
    tamanhoFila(fila);
    adicionaNaFila(fila, tipo);
  }

  public static void verFila(){
    System.out.println("");
    System.out.println("Fila preferencial");
    mostraFila(filaPreferencial);
    System.out.println("");
    System.out.println("Fila normal");
    mostraFila(filaNormal);
  }

  public static void retiraClienteFIla(){
    System.out.println("Retirando um cliente de uma fila - aleatório");
    String fila = clienteAtendido() == 1 ? "preferencial" : "normal";
    System.out.println("");
    System.out.println("Foi atendido alguém da fila "+fila);
    verFila();
  }

  public static void numeroValido(){
    System.out.println("Digite um numero válido");
  }

  public static void sair(){
    System.out.println("Até mais!");
  }
}