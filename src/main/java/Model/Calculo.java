package Model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Calculo {
    private List<Double> numeros;
    private String operacao;
    private double resultado;
}
