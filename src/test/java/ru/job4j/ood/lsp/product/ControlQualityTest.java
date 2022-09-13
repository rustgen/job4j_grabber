package ru.job4j.ood.lsp.product;

import org.junit.Test;
import ru.job4j.ood.lsp.product.*;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ControlQualityTest {

    Food tuna = new Fish("tuna", LocalDate.now().plusMonths(-2),
            LocalDate.now().minusMonths(22), 15, 2);
    Food salmon = new Fish("salmon", LocalDate.now().plusMonths(5),
            LocalDate.now().minusMonths(9), 17, 3);
    Food appleJuice = new Juice("apple", LocalDate.now().plusMonths(28),
            LocalDate.now().minusMonths(1), 5, 2);
    Food grapeJuice = new Juice("grape", LocalDate.now().plusMonths(17),
            LocalDate.now().minusMonths(23), 4, 2);
    Food whiteBread = new Bread("white", LocalDate.now().plusMonths(24),
            LocalDate.now().minusMonths(36), 6, 2);
    Food glutenFreeBread = new Bread("gluten-free", LocalDate.now().plusMonths(3),
            LocalDate.now().minusMonths(28), 9, 3);

    @Test
    public void whenAddProductToShop() {
        AbstractStore shop = new Shop();
        shop.add(salmon);
        shop.add(grapeJuice);
        assertEquals(shop.getAll(), List.of(salmon, grapeJuice));
    }

    @Test
    public void whenAddProductToShopAndMakeDiscount() {
        AbstractStore shop = new Shop();
        shop.add(salmon);
        shop.add(glutenFreeBread);
        assertThat(shop.get(1).getPrice(), is(6.0));
    }

    @Test
    public void whenAddProductToWarehouse() {
        AbstractStore warehouse = new Warehouse();
        warehouse.add(appleJuice);
        assertEquals(warehouse.getAll(), List.of(appleJuice));
    }

    @Test
    public void whenAddProductToTrash() {
        AbstractStore trash = new Trash();
        trash.add(tuna);
        assertEquals(trash.getAll(), List.of(tuna));
    }

    @Test
    public void whenAddDifferentProducts() {
        AbstractStore shop = new Shop();
        AbstractStore warehouse = new Warehouse();
        AbstractStore trash = new Trash();
        shop.add(salmon);
        shop.add(glutenFreeBread);
        warehouse.add(appleJuice);
        trash.add(tuna);
        assertEquals(trash.getAll(), List.of(tuna));
        assertEquals(shop.getAll(), List.of(salmon, glutenFreeBread));
        assertEquals(warehouse.getAll(), List.of(appleJuice));
        assertThat(shop.get(1), is(glutenFreeBread));
    }
}