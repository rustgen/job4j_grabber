package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere")
                .contains("ph")
                .startsWith("S");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron")
                .endsWith("on")
                .doesNotContain("sfsdvdv");
    }

    @Test
    void isThisUNKNOWN() {
        Box box = new Box(3, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object").contains(" ")
                .contains(" o")
                .startsWithIgnoringCase("u");
    }

    @Test
    void sphereArea() {
        Box box = new Box(0, 10);
        double result = box.getArea();
        assertThat(result).isEqualTo(1256.63d, withPrecision(0.01))
                .isGreaterThanOrEqualTo(1256.6214353453465325235)
                .isLessThanOrEqualTo(1256.638);
    }

    @Test
    void cubeArea() {
        Box box = new Box(8, 13);
        double result = box.getArea();
        assertThat(result).isEqualTo(1014.0d, withPrecision(0.01))
                .isGreaterThan(100)
                .isLessThanOrEqualTo(20000);
    }
}