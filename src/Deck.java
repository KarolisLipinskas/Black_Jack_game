import java.util.ArrayList;
import java.util.List;

public class Deck {
    List<Card> deck = new ArrayList<>();

    Deck() {
        this.addNewDeck();
    }

    public void addNewDeck() {
        String[] suits = {"heart", "diamond", "club", "spade"};
        for (String suit : suits) {
            for (int i = 1; i <= 13; i++) {
                this.addCard(new Card(i, suit));
            }
        }
    }

    private void addCard(Card card) {
        this.deck.add(card);
    }

    public void removeCard(int index) {
        this.deck.remove(index);
    }

    public Card getCardAt(int index) {
        return deck.get(index);
    }

    public int size() {
        return deck.size();
    }
}
