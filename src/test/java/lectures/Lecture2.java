package lectures;

import beans.Person;
import java.util.List;
import java.util.stream.IntStream;
import mockdata.MockData;
import org.junit.Test;

public class Lecture2 {

  @Test
  public void range() throws Exception {

    System.out.println("With For i");

    for (int i = 0; i <= 10; i++) {
      System.out.println(i);
    }

    System.out.println("Exclusive");

    IntStream.range(0, 10).forEach(System.out::println);

    System.out.println("Inclusive");

    IntStream.rangeClosed(0, 10).forEach(System.out::println);

  }

  @Test
  public void rangeIteratingLists() throws Exception {
    List<Person> people = MockData.getPeople();

    IntStream.range(0, people.size()).forEach(index -> {
      System.out.println(people.get(index));
    });

    //OR
    people.forEach(person -> {
      System.out.println(person);
    });
    //Method reference
    people.forEach(System.out::println);

  }

  @Test
  public void intStreamIterate() throws Exception {
    //SEED => where you begin
    //Operand => result of what you returned
      IntStream.iterate(0, operand -> operand + 1)
          .filter(number -> number % 2 == 0)
          .limit(20)
          .forEach(System.out::println);
  }
}
