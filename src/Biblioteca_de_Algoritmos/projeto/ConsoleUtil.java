package Biblioteca_de_Algoritmos.projeto;

import java.util.Scanner;


 //Métodos utilitários para leitura via Scanner,
 //evitando quebra do programa com entradas inválidas.

public class ConsoleUtil {

    public static int lerInt(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida");
            }
        }
    }

    public static void pausar(Scanner scanner) {
        System.out.print("\nPressione enter para continuar...");
        scanner.nextLine();
    }
}
