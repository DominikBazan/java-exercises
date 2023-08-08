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
        assertEquals("vanilla cake", new Vanilla().getName());
    }
}