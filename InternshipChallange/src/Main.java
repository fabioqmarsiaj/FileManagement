import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner teclado = new Scanner(System.in);

        String key;

        String continuar = "S";

        Lista lista = new Lista();

        System.out.println("OBS: Adicione alguma URL nas listas antes de usar outros métodos!");

        while (continuar.equals("S")) {

            System.out.println("##########################################################");
            System.out.println("  Bem vindo, usuário.");
            System.out.println("  Selecione uma das seguintes opções:");
            System.out.println("  1) Verify {url};");
            System.out.println("  2) Add-whitelist {url};");
            System.out.println("  3) Add-blacklist {url};");
            System.out.println("  4) Show-whitelist;");
            System.out.println("  5) Show-blacklist;");
            System.out.println("  6) Remove-whitelist {url}");
            System.out.println("  7) Remove-blacklist {url}");
            System.out.println("##########################################################");
            System.out.println("Escolha uma das opções: ");

            key = teclado.nextLine();

            switch (key) {
                case "1":

                    lista.verify();
                    break;

                case "2":

                    lista.addWhitelist();
                    break;

                case "3":

                    lista.addBlacklist();
                    break;

                case "4":

                    lista.showWhitelist();
                    break;

                case "5":
                    lista.showBlacklist();
                    break;


                case "6":

                    lista.removeWhiteList();
                    break;

                case "7":


                    lista.removeBlackList();
                    break;

                default:

                    System.out.println("Digite uma opção válida.");
                    break;
            }

            System.out.println("Deseja continuar? [S/N]");
            continuar = teclado.nextLine().toUpperCase();

        }

        teclado.close();
    }
}
