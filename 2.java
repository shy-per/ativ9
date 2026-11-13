import java.util.Scanner;

public class Triangulos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] lados = new double[10][3];

        for (int i = 0; i < 10; i++) {
            boolean valido;
            do {
                System.out.println("Triângulo " + (i + 1) + ":");
                for (int j = 0; j < 3; j++) {
                    System.out.print("  Aresta " + (j + 1) + ": ");
                    lados[i][j] = sc.nextDouble();
                }
                double a = lados[i][0], b = lados[i][1], c = lados[i][2];
                valido = a > 0 && b > 0 && c > 0 && a < b + c && b < a + c && c < a + b;
                if (!valido) {
                    System.out.println("  Esses valores não formam um triângulo. Digite novamente.");
                }
            } while (!valido);
        }

        int equilateros = 0, isosceles = 0, escalenos = 0;
        for (int i = 0; i < 10; i++) {
            double a = lados[i][0], b = lados[i][1], c = lados[i][2];
            if (a == b && b == c) {
                equilateros++;
            } else if (a == b || a == c || b == c) {
                isosceles++;
            } else {
                escalenos++;
            }
        }

        System.out.println("\n===== RESULTADO =====");
        System.out.printf("Equiláteros: %.1f%%%n", equilateros * 10.0);
        System.out.printf("Isósceles:   %.1f%%%n", isosceles * 10.0);
        System.out.printf("Escalenos:   %.1f%%%n", escalenos * 10.0);
    }
}
