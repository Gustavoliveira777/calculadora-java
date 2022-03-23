package operacoes;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Calculo {
    private List<double> numeros;
    private String operacao;
    private double resultado;
}
