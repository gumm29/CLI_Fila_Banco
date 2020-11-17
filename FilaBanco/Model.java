package FilaBanco;

import java.util.Scanner;

public class Model extends View{
  public static void banco() {
    painel();
    Scanner output = new Scanner(System.in);
    int senha = output.nextInt();
    switch (senha) {
      case 1:
        escolhaSenha("preferencial");
        banco();
        break;
      case 2:
        escolhaSenha("normal");
        banco();
        break;
      case 3:
        verFila();
        banco();
        break;
      case 4:
        retiraClienteFIla();
        banco();
        break;
      case 10:
        sair();
        break;
      default:
        numeroValido();
        banco();
    }
  }
}