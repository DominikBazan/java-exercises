import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BakeryTest {

    private Bakery bakery;

    @BeforeEach
    void setUp() {
        String bakeryName = "London Royal Bakery";
        this.bakery = new Bakery(bakeryName);
    }

    @Test
    void testBakeryNameNotNull() {
        String bakeryName = this.bakery.getName();
        assertNotNull(bakeryName);
    }

    @Test
    void testBakeryNameNotEmpty() {
        String bakeryName = this.bakery.getName();
        assertNotEquals("", bakeryName);
    }

    @Test
    void testSimpleVanillaCakeCreation() {
        new Vanilla();
    }

    @Test
    void testGetVanillaCakeName() {
        assertEquals("Vanilla cake", new Vanilla().getName());
    }

    @Test
    void testMultiLayeredStrawberryCakeWithSprinklesWithSayingEverytime() {
        Cake cake = new WithTheSayingX(new Sprinkles(new MultiLayered(new Strawberry())), "EVERYTIME");
        String cakeName = cake.getName();
        assertEquals("Multi-layered Strawberry cake with sprinkles with saying 'EVERYTIME'", cakeName);
    }
}