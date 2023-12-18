import junit.framework.TestCase;

import static helpers.Constants.*;

public class GameTest extends TestCase {
    public void testDraw() {
        //arrange
        Hand player = new Hand();
        Hand dealer = new Hand();
        player.addCard(new Card(10, DIAMOND_SUIT));
        dealer.addCard(new Card(10, SPADE_SUIT));
        Boolean stand = true;

        //act
        int result = new Game().gameState(stand, player, dealer);

        //assert
        assertEquals(DRAW, result);
    }

    public void testDrawByBothOver21() {
        //arrange
        Hand player = new Hand();
        Hand dealer = new Hand();
        player.addCard(new Card(11, DIAMOND_SUIT));
        player.addCard(new Card(12, CLUB_SUIT));
        dealer.addCard(new Card(10, SPADE_SUIT));
        dealer.addCard(new Card(12, HEART_SUIT));
        Boolean stand = true;

        //act
        int result = new Game().gameState(stand, player, dealer);

        //assert
        assertEquals(DRAW, result);
    }

    public void testWinByHigherPoints() {
        //arrange
        Hand player = new Hand();
        Hand dealer = new Hand();
        player.addCard(new Card(10, DIAMOND_SUIT));
        player.addCard(new Card(8, CLUB_SUIT));
        dealer.addCard(new Card(8, SPADE_SUIT));
        dealer.addCard(new Card(8, HEART_SUIT));
        Boolean stand = true;

        //act
        int result = new Game().gameState(stand, player, dealer);

        //assert
        assertEquals(WIN, result);
    }

    public void testWinByDealerOver21() {
        //arrange
        Hand player = new Hand();
        Hand dealer = new Hand();
        player.addCard(new Card(10, DIAMOND_SUIT));
        dealer.addCard(new Card(12, SPADE_SUIT));
        dealer.addCard(new Card(10, HEART_SUIT));
        Boolean stand = true;

        //act
        int result = new Game().gameState(stand, player, dealer);

        //assert
        assertEquals(WIN, result);
    }

    public void testLoseByLowerPoints() {
        //arrange
        Hand player = new Hand();
        Hand dealer = new Hand();
        player.addCard(new Card(10, DIAMOND_SUIT));
        player.addCard(new Card(10, CLUB_SUIT));
        dealer.addCard(new Card(12, SPADE_SUIT));
        dealer.addCard(new Card(9, HEART_SUIT));
        Boolean stand = true;

        //act
        int result = new Game().gameState(stand, player, dealer);

        //assert
        assertEquals(LOSE, result);
    }

    public void testLoseByPointsOver21() {
        //arrange
        Hand player = new Hand();
        Hand dealer = new Hand();
        player.addCard(new Card(10, DIAMOND_SUIT));
        player.addCard(new Card(12, CLUB_SUIT));
        dealer.addCard(new Card(10, SPADE_SUIT));
        dealer.addCard(new Card(9, HEART_SUIT));
        Boolean stand = true;

        //act
        int result = new Game().gameState(stand, player, dealer);

        //assert
        assertEquals(LOSE, result);
    }
}
