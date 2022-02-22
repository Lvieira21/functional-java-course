package lectures;


import com.google.common.collect.Lists;

import java.util.Arrays;

import org.junit.Test;

public class Lecture9 {

    @Test
    public void reduce() throws Exception {
        Integer[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};

        //Zero seria o passo incial, sendo 0+1, depois o resultado disso +3, e assim por diante
//        Integer reduce = Arrays.stream(integers).reduce(0, (a, b) -> a + b);

        //Usando method reference

        Integer reduce = Arrays.stream(integers).reduce(0, Integer::sum);

        System.out.println(reduce);
    }


}

