import java.util.Scanner;

public class Temperaturas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] temp = new double[10][3];

        for (int i = 0; i < 10; i++) {
            System.out.println("Dia " + (i + 1) + ":");
            System.out.print("  Temperatura mínima: ");
            temp[i][0] = sc.nextDouble();

            do {
                System.out.print("  Temperatura máxima: ");
                temp[i][1] = sc.nextDouble();
                if (temp[i][1] < temp[i][0]) {
                    System.out.println("  A máxima não pode ser menor que a mínima. Tente novamente.");
                }
            } while (temp[i][1] < temp[i][0]);

            temp[i][2] = (temp[i][0] + temp[i][1]) / 2;
        }

        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Temperatura mínima de todos os dias");
            System.out.println("2 - Temperatura máxima de todos os dias");
            System.out.println("3 - Maior variação de temperatura");
            System.out.println("4 - Sair do programa");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    int diaMenor = 0;
                    System.out.println("\nMínimas de cada dia:");
                    for (int i = 0; i < 10; i++) {
                        System.out.printf("Dia %d: %.1f°C%n", i + 1, temp[i][0]);
                        if (temp[i][0] < temp[diaMenor][0]) {
                            diaMenor = i;
                        }
                    }
                    System.out.printf("Menor mínima: %.1f°C (dia %d)%n", temp[diaMenor][0], diaMenor + 1);
                    break;
                case 2:
                    int diaMaior = 0;
                    System.out.println("\nMáximas de cada dia:");
                    for (int i = 0; i < 10; i++) {
                        System.out.printf("Dia %d: %.1f°C%n", i + 1, temp[i][1]);
                        if (temp[i][1] > temp[diaMaior][1]) {
                            diaMaior = i;
                        }
                    }
                    System.out.printf("Maior máxima: %.1f°C (dia %d)%n", temp[diaMaior][1], diaMaior + 1);
                    break;
                case 3:
                    int diaVar = 0;
                    double maior = temp[0][1] - temp[0][0];
                    for (int i = 1; i < 10; i++) {
                        double variacao = temp[i][1] - temp[i][0];
                        if (variacao > maior) {
                            maior = variacao;
                            diaVar = i;
                        }
                    }
                    System.out.printf("%nMaior variação: %.1f°C (dia %d, média %.1f°C)%n",
                            maior, diaVar + 1, temp[diaVar][2]);
                    break;
                case 4:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }
}
