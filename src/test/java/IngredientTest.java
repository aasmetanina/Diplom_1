import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType ingredientType;

    public IngredientTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {SAUCE},
                {FILLING}
        };
    }

    @Test
    public void checkIngredientTypeAndNameAndPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, "Chili", 1);
        Assert.assertEquals(ingredientType, ingredient.getType());
        Assert.assertEquals("Chili", ingredient.getName());
        Assert.assertEquals(1, ingredient.getPrice(), 0.001);
    }
}
