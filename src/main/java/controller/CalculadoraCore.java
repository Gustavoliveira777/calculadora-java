package controller;

import DAO.MongoDAO;
import Model.Calculo;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraCore {
    public void calcular(int opcao, String numeros) {
        String[] nums = numeros.split(";");
        List<Double> numbs = new ArrayList<>();
        MongoDAO dao10 = new MongoDAO();
        Calculo calq = dao10.buscarUltimo(0);
        for (String numero : nums) {
            if (numero.equals("0") && opcao == 4) {
                System.err.println("Impossivel dividir por zero. Tente novamente.");
                return;
            }
            if (numero.equals("ANS") || numero.equals("ans")){
                numbs.add(calq.getResultado());
            }else{
                numbs.add(Double.parseDouble(numero));
            }
        }
        switch (opcao) {
            case 1:
                Calculo calc = somar(numbs);
                System.out.println("\n\nSoma:\nNúmeros: " + calc.getNumeros().toString() + "\nResultado: " + calc.getResultado());
                MongoDAO dao = new MongoDAO();
                dao.adicionar(calc);
                break;
            case 2:
                MongoDAO dao2 = new MongoDAO();
                calc = subtrair(numbs);
                System.out.println("\n\nSubtracao:\nNúmeros: " + calc.getNumeros().toString() + "\nResultado: " + calc.getResultado());
                dao2.adicionar(calc);
                break;
            case 3:
                MongoDAO dao3 = new MongoDAO();
                calc = multiplicar(numbs);
                System.out.println("\n\nMultiplicacao:\nNúmeros: " + calc.getNumeros().toString() + "\nResultado: " + calc.getResultado());
                dao3.adicionar(calc);
                break;
            case 4:
                MongoDAO dao4 = new MongoDAO();
                calc = dividir(numbs);
                System.out.println("\n\nDivisao:\nNúmeros: " + calc.getNumeros().toString() + "\nResultado: " + calc.getResultado());
                dao4.adicionar(calc);
                break;
            case 5:
                MongoDAO dao5 = new MongoDAO();
                calc = elevaQuad(numbs);
                System.out.println("\n\nPotencia ao Quadrado:\nNúmero: " + calc.getNumeros().toString() + "\nResultado: " + calc.getResultado());
                dao5.adicionar(calc);
                break;
            case 6:
                MongoDAO dao6 = new MongoDAO();
                calc = elevaCubo(numbs);
                System.out.println("\n\nPotencia ao Cubo:\nNúmero: " + calc.getNumeros().toString() + "\nResultado: " + calc.getResultado());
                dao6.adicionar(calc);
                break;
            case 7:
                MongoDAO dao7 = new MongoDAO();
                calc = raizq(numbs);
                System.out.println("\n\nRaiz Quadrada:\nNúmero: " + calc.getNumeros().toString() + "\nResultado: " + calc.getResultado());
                dao7.adicionar(calc);
                break;
            case 8:
                MongoDAO dao8 = new MongoDAO();
                calc = raizcub(numbs);
                System.out.println("\n\nRaiz Cubica:\nNúmero: " + calc.getNumeros().toString() + "\nResultado: " + calc.getResultado());
                dao8.adicionar(calc);
                break;
            case 9:
                MongoDAO dao9 = new MongoDAO();
                calc = log(numbs);
                System.out.println("\n\nLogaritmo:\nNúmeros: " + calc.getNumeros().toString() + "\nResultado: " + calc.getResultado());
                dao9.adicionar(calc);
                break;
            case 10:
                MongoDAO dao1 = new MongoDAO();
                List<Calculo> calcs = dao1.buscarTudo();
                for (Calculo calcc : calcs) {
                    System.out.println("Numeros: " + calcc.getNumeros().toString() + "\nOperacao: " + calcc.getOperacao() + "\nResultado: " + calcc.getResultado() + "\n========================");
                }
                break;
            case 11:
                System.err.println("Tchau :(");
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
