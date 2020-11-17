package FilaBanco;

import java.util.Random;

public class Controller {
  static String novaSenha = "";
  static int countPreferencial, countNormal, valor, limite = 0;
  static boolean size = false;
  static String[] filaPreferencial, filaNormal = new String[10];
  static Random rand = new Random();

  public static String adiciona(String tipo) {
    return tipo == "preferencial" ? "A" + String.valueOf(countPreferencial++) : "B" + String.valueOf(countNormal++);
  }

  public static void adicionaNaFila(String[] tipoFila,String tipo){
    if (limite == tipoFila.length){
      System.out.println("fila cheia! Espere atender uma pessoa");
    }else if (limite < tipoFila.length){
      novaSenha = adiciona(tipo);
      tipoFila[limite++] = novaSenha;
      System.out.println("Sua senha é "+novaSenha);
    }
  }

  public static void mostraPosicoesFila(String[] tipoFila, int i) {
    if (tipoFila[i] != null && tipoFila[i] != "") System.out.println("Senha: " + tipoFila[i]);
  }

  public static void mostraFila(String[] tipoFila) {
    for (int i = 0; i < tipoFila.length; i++) {
      mostraPosicoesFila(tipoFila(tipoFila), i);
    }
  }

  public static String[] tipoFila(String[] tipoFila) {
    return tipoFila == filaPreferencial ? filaPreferencial : filaNormal;
  }

  public static int tamanhoFila(String[] tipoFila){
    for(int i = 0; i< tipoFila.length;i++){
      if (limiteArray(tipoFila, i)) break;
    }
    return limite;
  }

  public static boolean limiteArray(String[] tipoFila, int i){
    if (tipoFila[i] == null || tipoFila[i] == ""){
      limite = i;
      return true;
    }
    return false;
  }

  public static String populaFila(int valor, int i) {
    if (valor == 1) {
      novaSenha = adiciona("preferencial");
      filaPreferencial[tamanhoFila(filaPreferencial)] = novaSenha;
    } else if (valor == 2) {
      novaSenha = adiciona("normal");
      filaNormal[tamanhoFila(filaNormal)] = novaSenha;
    }
    return novaSenha;
  }

  public static void populaCincoPessoas() {
    for (int i = 0; i <= 5; i++) {
      valor = rand.nextInt(2) + 1;
      System.out.println("numero " + populaFila(valor, i));
    }
  }

  public static int clienteAtendido() {
    valor = rand.nextInt(2) + 1;
    for(int i = 0; i < filaPreferencial.length; i++){
      insere(i);
    }
    return valor;
  }

  public static void insere(int i){
    if(valor == 1 ) filaPreferencial[i] = (i == filaPreferencial.length -1) ? "" : filaPreferencial[i+1];
    if(valor == 2) filaNormal[i] = (i == filaNormal.length -1) ? "" : filaNormal[i+1];
  }
}