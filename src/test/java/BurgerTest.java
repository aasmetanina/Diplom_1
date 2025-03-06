import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    private Ingredient cutlet;
    @Mock
    private Ingredient pickles;

    @Before
    public void setUp() throws Exception {
        burger = new Burger();
        Mockito.when(cutlet.getName()).thenReturn("Котлета");
        Mockito.when(cutlet.getPrice()).thenReturn(10.2f);
        Mockito.when(cutlet.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(pickles.getName()).thenReturn("Огурчики");
        Mockito.when(pickles.getPrice()).thenReturn(3.5f);
        Mockito.when(pickles.getType()).thenReturn(IngredientType.FILLING);
        burger.setBuns(new Bun("Мякиш", 4.3f));
    }

    @Test
    public void bunOnly() {
        Assert.assertEquals(
                "(==== Мякиш ====)\n" +
                        "(==== Мякиш ====)\n" +
                        "\n" +
                        "Price: 8.600000\n",
                burger.getReceipt());
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(cutlet);
        Assert.assertEquals(
                "(==== Мякиш ====)\n" +
                        "= filling Котлета =\n" +
                        "(==== Мякиш ====)\n" +
                        "\n" +
                        "Price: 18.799999\n",
                burger.getReceipt());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(cutlet);
        burger.addIngredient(pickles);
        Assert.assertEquals(
                "(==== Мякиш ====)\n" +
                        "= filling Котлета =\n" +
                        "= filling Огурчики =\n" +
                        "(==== Мякиш ====)\n" +
                        "\n" +
                        "Price: 22.299999\n",
                burger.getReceipt());
        burger.moveIngredient(0, 1);
        Assert.assertEquals(
                "(==== Мякиш ====)\n" +
                        "= filling Огурчики =\n" +
                        "= filling Котлета =\n" +
                        "(==== Мякиш ====)\n" +
                        "\n" +
                        "Price: 22.299999\n",
                burger.getReceipt());
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(cutlet);
        burger.addIngredient(pickles);
        Assert.assertEquals(
                "(==== Мякиш ====)\n" +
                        "= filling Котлета =\n" +
                        "= filling Огурчики =\n" +
                        "(==== Мякиш ====)\n" +
                        "\n" +
                        "Price: 22.299999\n",
                burger.getReceipt());
        burger.removeIngredient(0);
        Assert.assertEquals(
                "(==== Мякиш ====)\n" +
                        "= filling Огурчики =\n" +
                        "(==== Мякиш ====)\n" +
                        "\n" +
                        "Price: 12.100000\n",
                burger.getReceipt());
    }
}
