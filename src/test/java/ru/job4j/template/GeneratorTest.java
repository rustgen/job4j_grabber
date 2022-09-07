package ru.job4j.template;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;

@Disabled
public class GeneratorTest {

    private final static String TEMPLATE = "I am a ${name}, Who are ${subject}? ";

    @Test
    public void whenKeyAndValueExistInMap() {
        Generator generator = new UsersGenerator();
        Map<String, String> args = Map.of("name", "Petr",
                "subject", "you");
        String expected = "I am a Petr, Who are you? ";
        String result = generator.produce(TEMPLATE, args);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenKeyNotInMap() {
        Generator generator = new UsersGenerator();
        Map<String, String> args = Map.of("name", "Petr",
                "kind", "human");
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            generator.produce(TEMPLATE, args);
        });
    }

    @Test
    public void whenExtraKeysInMap() {
        Generator generator = new UsersGenerator();
        Map<String, String> args = Map.of("name", "Petr",
                "kind", "human", "subject", "you", "sex", "male");
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            generator.produce(TEMPLATE, args);
        });
    }
}