import java.util.Scanner;

public class ConversorMoedas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("**********************************");
        System.out.println("   Bem-vindo ao Conversor de Moedas!");
        System.out.println("**********************************");

        while (true) {
            System.out.println("\nConversor de Moedas:");
            System.out.println("1 - Dólar para Real.");
            System.out.println("2 - Real para Dólar.");
            System.out.println("3 - Euro para Real.");
            System.out.println("4 - Real para Euro.");
            System.out.println("5 - Dólar para Euro.");
            System.out.println("6 - Euro para Dólar.");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            if (opcao == 7) break;

            String origem = "", destino = "";

            switch (opcao) {
                case 1 -> { origem = "USD"; destino = "BRL"; }
                case 2 -> { origem = "BRL"; destino = "USD"; }
                case 3 -> { origem = "EUR"; destino = "BRL"; }
                case 4 -> { origem = "BRL"; destino = "EUR"; }
                case 5 -> { origem = "USD"; destino = "EUR"; }
                case 6 -> { origem = "EUR"; destino = "USD"; }
                default -> {
                    System.out.println("Opção inválida.");
                    continue;
                }
            }

            System.out.print("Digite o valor em " + origem + ": ");
            double valor = scanner.nextDouble();

            try {
                double taxa = ApiCliente.buscarTaxa(origem, destino);
                double convertido = valor * taxa;
                System.out.printf("Valor em %s: %.2f\n", destino, convertido);
            } catch (Exception e) {
                System.out.println("Erro ao converter: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

