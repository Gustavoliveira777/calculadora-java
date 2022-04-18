package controller;

import Model.Calculo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculadoraCore {
    public void calcular(int opcao, String numeros) {
        String[] nums = numeros.split(";");
        List<Double> numbs = new ArrayList<>();
        for (String numero : nums) {
            numbs.add(Double.parseDouble(numero));
        }
        switch (opcao) {
            case 1:
                Calculo calc = somar(numbs);
                System.out.println("\n\nSoma:\nNúmeros: " + calc.getNumeros().toString() + "\nResultado: " + calc.getResultado());
                break;
            case 2:
                calc = subtrair(numbs);
                System.out.println("\n\nSubtracao:\nNúmeros: " + calc.getNumeros().toString() + "\nResultado: " + calc.getResultado());
                break;
            case 3:
                calc = multiplicar(numbs);
                System.out.println("\n\nMultiplicacao:\nNúmeros: " + calc.getNumeros().toString() + "\nResultado: " + calc.getResultado());
                break;
            case 4:
                calc = dividir(numbs);
                System.out.println("\n\nDivisao:\nNúmeros: " + calc.getNumeros().toString() + "\nResultado: " + calc.getResultado());
                break;
            case 5:
                calc = elevaQuad(numbs);
                System.out.println("\n\nPotencia ao Quadrado:\nNúmero: " + calc.getNumeros().toString() + "\nResultado: " + calc.getResultado());
                break;
            case 6:
                calc = elevaCubo(numbs);
                System.out.println("\n\nPotencia ao Cubo:\nNúmero: " + calc.getNumeros().toString() + "\nResultado: " + calc.getResultado());
                break;
            case 7:
                calc = raizq(numbs);
                System.out.println("\n\nRaiz Quadrada:\nNúmero: " + calc.getNumeros().toString() + "\nResultado: " + calc.getResultado());
                break;
            case 8:
                calc = raizcub(numbs);
                System.out.println("\n\nRaiz Cubica:\nNúmero: " + calc.getNumeros().toString() + "\nResultado: " + calc.getResultado());
                break;
            case 9:
                calc = log(numbs);
                System.out.println("\n\nLogaritmo:\nNúmeros: " + calc.getNumeros().toString() + "\nResultado: " + calc.getResultado());
                break;
            default:
                System.err.println("\n\nOpcao inexistente");
        }

    }

    private Calculo somar(List<Double> nums) {
        double resultado = nums.get(0);
        List<Double> nPubli = new ArrayList<>();
        nPubli.addAll(nums);
        nums.remove(0);
        for (double num : nums) {
            resultado += num;
        }
        Calculo calc = Calculo.builder()
                .numeros(nPubli)
                .operacao("+")
                .resultado(resultado)
                .build();
        return calc;
    }

    private Calculo subtrair(List<Double> nums) {
        double resultado = nums.get(0);
        List<Double> nPubli = new ArrayList<>();
        nPubli.addAll(nums);
        nums.remove(0);
        for (double num : nums) {
            resultado -= num;
        }
        Calculo calc = Calculo.builder()
                .numeros(nPubli)
                .operacao("-")
                .resultado(resultado)
                .build();
        return calc;
    }

    private Calculo multiplicar(List<Double> nums) {
        double resultado = nums.get(0);
        List<Double> nPubli = new ArrayList<>();
        nPubli.addAll(nums);
        nums.remove(0);
        for (double num : nums) {
            resultado *= num;
        }
        Calculo calc = Calculo.builder()
                .numeros(nPubli)
                .operacao("*")
                .resultado(resultado)
                .build();
        return calc;
    }

    private Calculo dividir(List<Double> nums) {
        double resultado = nums.get(0);
        List<Double> nPubli = new ArrayList<>();
        nPubli.addAll(nums);
        nums.remove(0);
        for (double num : nums) {
            resultado /= num;
        }
        Calculo calc = Calculo.builder()
                .numeros(nPubli)
                .operacao("/")
                .resultado(resultado)
                .build();
        return calc;
    }

    private Calculo elevaQuad(List<Double> nums) {
        double resultado = Math.pow(nums.get(0), 2);
        List<Double> finalN = new ArrayList<>();
        finalN.add(nums.get(0));
        Calculo calc = Calculo.builder()
                .numeros(finalN)
                .operacao("^2")
                .resultado(resultado)
                .build();
        return calc;
    }

    private Calculo elevaCubo(List<Double> nums) {
        double resultado = Math.pow(nums.get(0), 3);
        List<Double> finalN = new ArrayList<>();
        finalN.add(nums.get(0));
        Calculo calc = Calculo.builder()
                .numeros(finalN)
                .operacao("^3")
                .resultado(resultado)
                .build();
        return calc;
    }

    private Calculo raizq(List<Double> nums) {
        double resultado = Math.sqrt(nums.get(0));
        List<Double> finalN = new ArrayList<>();
        finalN.add(nums.get(0));
        Calculo calc = Calculo.builder()
                .numeros(finalN)
                .operacao("sqrt")
                .resultado(resultado)
                .build();
        return calc;
    }

    private Calculo raizcub(List<Double> nums) {
        double resultado = Math.cbrt(nums.get(0));
        List<Double> finalN = new ArrayList<>();
        finalN.add(nums.get(0));
        Calculo calc = Calculo.builder()
                .numeros(finalN)
                .operacao("cbrt")
                .resultado(resultado)
                .build();
        return calc;
    }

    private Calculo log(List<Double> nums) {
        double resultado = Math.log(nums.get(0));
        List<Double> finalN = new ArrayList<>();
        finalN.add(nums.get(0));
        Calculo calc = Calculo.builder()
                .numeros(finalN)
                .operacao("log")
                .resultado(resultado)
                .build();
        return calc;
    }

}
