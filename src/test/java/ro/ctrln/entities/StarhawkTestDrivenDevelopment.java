package ro.ctrln.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StarhawkTestDrivenDevelopment {

    @Test
    public void starhawkGetBattleshipNameShouldReturnStarhawk4_1() {
        Starhawk starhawk = new Starhawk();
        starhawk.setNumberOfDecks(4);
        assertEquals("Starhawk 4", starhawk.getBattleshipName());
    }

    @Test
    public void starhawkGetBattleshipNameShouldReturnStarhawk4_2() {
        Starhawk starhawk = new Starhawk();
        starhawk.setNumberOfDecks(8);
        assertEquals("Starhawk 4", starhawk.getBattleshipName());
    }

    @Test
    public void starhawkGetBattleshipNameShouldReturnStarhawk7_1() {
        Starhawk starhawk = new Starhawk();
        starhawk.setNumberOfDecks(7);
        assertEquals("Starhawk 7", starhawk.getBattleshipName());
    }

    @Test
    public void starhawkGetBattleshipNameShouldReturnStarhawk7_2() {
        Starhawk starhawk = new Starhawk();
        starhawk.setNumberOfDecks(14);
        assertEquals("Starhawk 7", starhawk.getBattleshipName());
    }

    @Test
    public void starhawkGetBattleshipNameShouldReturnStarhawk28_1() {
        Starhawk starhawk = new Starhawk();
        starhawk.setNumberOfDecks(28);
        assertEquals("Starhawk 28", starhawk.getBattleshipName());
    }

    @Test
    public void starhawkGetBattleshipNameShouldReturnStarhawk28_2() {
        Starhawk starhawk = new Starhawk();
        starhawk.setNumberOfDecks(56);
        assertEquals("Starhawk 28", starhawk.getBattleshipName());
    }

    @Test
    public void starhawkGetBattleshipNameShouldReturnStarhawk209() {
        Starhawk starhawk = new Starhawk();
        starhawk.setNumberOfDecks(209);
        assertEquals("Starhawk 209", starhawk.getBattleshipName());
    }
}
