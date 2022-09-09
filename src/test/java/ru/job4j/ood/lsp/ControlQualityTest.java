package ru.job4j.ood.lsp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ControlQualityTest {

    Food tuna = new Fish("tuna", LocalDate.now().plusMonths(5),
            LocalDate.now().minusMonths(9), 15, 2);
    Food salmon = new Fish("salmon", LocalDate.now().plusMonths(5),
            LocalDate.now().minusMonths(9), 17, 3);
    Food appleJuice = new Juice("apple", LocalDate.now().plusMonths(8),
            LocalDate.now().minusMonths(14), 5, 2);
    Food grapeJuice = new Juice("grape", LocalDate.now().plusMonths(17),
            LocalDate.now().minusMonths(23), 4, 2);
    Food whiteBread = new Bread("white", LocalDate.now().plusMonths(24),
            LocalDate.now().minusMonths(36), 6, 2);
    Food glutenFreeBread = new Bread("gluten-free", LocalDate.now().plusMonths(3),
            LocalDate.now().minusMonths(24), 9, 3);

    @Test
    public void whenAddProductToShop() {
        Store shop = new Shop();
        shop.add(salmon);
        shop.add(grapeJuice);
        assertEquals(shop.getAll(), List.of(salmon, grapeJuice));
    }

    @Test
    public void whenAddProductToShopAndMakeDiscount() {
        Store shop = new Shop();
        shop.add(salmon);
        shop.add(glutenFreeBread);
        assertThat(shop.get(1).getPrice(), is(6.0));
    }

    @Test
    public void whenAddProductToWarehouse() {
        Store warehouse = new Warehouse();
    }

    @Test
    public void whenAddProductToTrash() {
        Store trash = new Trash();
    }
}