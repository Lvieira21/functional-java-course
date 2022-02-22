package lectures;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

    @Test
    public void joiningStrings() throws Exception {
        List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

        StringBuilder allNames = new StringBuilder();

        for (String name : names) {
            allNames.append(name).append(", ");
        }
        String substringAllNames = allNames.substring(0, allNames.length() - 2);

        System.out.println(substringAllNames);

    }

    @Test
    public void joiningStringsWithStream() throws Exception {
        List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");

        String nomes = names.stream().map(String::toUpperCase).collect(Collectors.joining(", "));

        System.out.println(nomes);

    }
}
