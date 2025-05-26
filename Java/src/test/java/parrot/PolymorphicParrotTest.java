package parrot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolymorphicParrotTest {

    @Test
    public void europeanParrotSpeed() {
        Parrot parrot = new EuropeanParrot();
        assertEquals(12.0, parrot.getSpeed(), 0.01);
    }

    @Test
    public void africanParrotWithNoCoconuts() {
        Parrot parrot = new AfricanParrot(0);
        assertEquals(12.0, parrot.getSpeed(), 0.01);
    }

    @Test
    public void africanParrotWithTwoCoconuts() {
        Parrot parrot = new AfricanParrot(2);
        assertEquals(0.0, parrot.getSpeed(), 0.01);
    }

    @Test
    public void norwegianBlueNotNailedLowVoltage() {
        Parrot parrot = new NorwegianBlueParrot(1.5, false);
        assertEquals(18.0, parrot.getSpeed(), 0.01);
    }

    @Test
    public void norwegianBlueNailed() {
        Parrot parrot = new NorwegianBlueParrot(1.5, true);
        assertEquals(0.0, parrot.getSpeed(), 0.01);
    }

    @Test
    public void norwegianBlueHighVoltageCappedAt24() {
        Parrot parrot = new NorwegianBlueParrot(4.0, false);
        assertEquals(24.0, parrot.getSpeed(), 0.01);
    }
}
