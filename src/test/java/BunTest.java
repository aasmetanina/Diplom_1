import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void checkNameAndPriceInBun() {
        Bun bun = new Bun("Donat", 4);
        Assert.assertEquals("Donat", bun.getName());
        Assert.assertEquals(4, bun.getPrice(), 0.001);
    }
}
