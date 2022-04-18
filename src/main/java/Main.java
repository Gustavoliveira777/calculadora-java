import controller.CalculadoraCore;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String numeros;
        int opcao = 0;
        Scanner leitura = new Scanner(System.in);
        while(opcao != 11) {
            System.out.println("Insira um numero; para varios numeros separe por ';'.\nUtilize '.' para separar as casas decimais.");
            System.out.print("Numeros > ");
            numeros = leitura.next();
            System.out.println("================\nJavaCalc\n================");
            System.out.println("Selecione uma opcao:");
            System.out.println("1 : Soma");
            System.out.println("2 : Subtracao");
            System.out.println("3 : Multiplicacao");
            System.out.println("4 : Divisao");
            System.out.println("5 : Elevar ao quadrado");
            System.out.println("6 : Elevar ao cubo");
            System.out.println("7 : Raiz quadrada");
            System.out.println("8 : Raiz cubica");
            System.out.println("9 : Logaritmo");
            System.out.println("10 : Histórico");
            System.out.println("11 : Encerrar");
            System.out.print("Opcao > ");
            opcao = leitura.nextInt();
            new CalculadoraCore().calcular(opcao,numeros);

        }
    }
}
