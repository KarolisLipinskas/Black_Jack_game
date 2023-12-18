import junit.framework.TestCase;

public class DeckTest extends TestCase {
    public void testDeckSize() {
        //arrange
        Deck deck1 = new Deck();

        //act
        int result = deck1.size();

        //assert
        assertEquals(52, result);
    }
}
