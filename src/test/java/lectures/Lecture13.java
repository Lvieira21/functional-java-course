package lectures;

import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture13 {
  @Test
  public void intermediateAndTerminalOperations() throws Exception {
    System.out.println(
        MockData.getCars()
            .stream()
            .filter(car -> {
              System.out.println("filter car " + car);
              return car.getPrice() < 10000;
            })
            .map(car -> {
              System.out.println("mapping car " + car);
              return car.getPrice();
            })
            .map(price -> {
              System.out.println("mapping price " + price);
              return price + (price * .14);
            })
            //operador terminal, se não o chamarmos, teremos uma pipeline de uma stream, mas os métodos map e filter (Operadores intermediarios), por exemplo, não serão executados
            .collect(Collectors.toList())
            //Streams are Lazy, só viram algum objeto concreto, quando o Operador terminal for chamado
    );
  }
}
