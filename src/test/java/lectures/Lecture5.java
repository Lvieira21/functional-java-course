package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

    @Test
    public void understandingFilter() throws Exception {
        ImmutableList<Car> cars = MockData.getCars();

        //    cars.stream().filter(car -> {
        //      return car.getPrice() < 1000;
        //    });

        //Por apenas a função lambda estar retornando uma variável, podemos simplificar e remover a expressao lambda
//        List<Car> carsFiltered = cars.stream().filter(car -> car.getPrice() < 10000).collect(Collectors.toList());

        //No java 8 tb podemos criar uma variavel para o predicate, e com isso podemos usar em varios filtros diferentes.

        final Predicate<Car> carPredicate = (car -> car.getPrice() < 10000);
        List<Car> carsFiltered = cars.stream().filter(carPredicate).collect(Collectors.toList());

        carsFiltered.forEach(System.out::println);

        carsFiltered.forEach(car -> {
            System.out.println(car);
            assertThat(car.getPrice() < 10000).isTrue();
        });

    }

    @Test
    public void ourFirstMapping() throws Exception {
        // transform from one data type to another
        List<Person> people = MockData.getPeople();

//        List<PersonDTO> dtos = people.stream().map(person -> {
//            PersonDTO dto = new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
//            return dto;
//        }).collect(Collectors.toList());

        //Simplificando
//        List<PersonDTO> dtos = people.stream().map(person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge()))
//            .collect(Collectors.toList());

        //Usando Functions
//        Function<Person, PersonDTO> personPersonDTOFunction = person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
//
//        List<PersonDTO> dtos = people.stream().map(personPersonDTOFunction)
//            .collect(Collectors.toList());

        //Usando referencia de método
        List<PersonDTO> dtos = people.stream().map(PersonDTO::map)
            .collect(Collectors.toList());

        dtos.forEach(dto -> {
            System.out.println(dto);
            assertThat(dto).isInstanceOf(PersonDTO.class);
        });

    }

    @Test
    public void averageCarPrice() throws Exception {
        // calculate average of car prices
        ImmutableList<Car> cars = MockData.getCars();

        DoubleStream carPrices = cars.stream().mapToDouble(Car::getPrice);
        System.out.println(carPrices.average().orElse(0));

    }

    @Test
    public void test() throws Exception {

    }
}



