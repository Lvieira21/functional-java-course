package lectures;

import beans.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.junit.Test;

public class Lecture12 {

    @Test
    public void understandingCollect() throws Exception {
        List<String> emails = MockData.getPeople().stream().map(Person::getEmail).collect(Collectors.toList());

        //Explicando os contrutores do collect()
        List<String> emails2 = MockData.getPeople().stream().map(Person::getEmail)
            .collect(
                () -> new ArrayList<String>(), //Em uma lista
                (list, element) -> list.add(element), //os items devem ser adicionados a lista dessa maneira
                (list1, list2) -> list1.addAll(list2) //Se existirem duas listas, é assim que devem ser concatenadas
                //Esse caso é de quando tivermos multiplos threads processando a stream, no caso teremos multiplas listas, e devem ser concatenadas dessa maneira
            );

        //method reference
        List<String> emails3 = MockData.getPeople().stream().map(Person::getEmail)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        emails.forEach(System.out::println);
    }
}
