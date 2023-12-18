import static helpers.Constants.SUITS;

public class Deck extends CardList implements DeckInterface {
    Deck() {
        this.addNewDeck();
    }

    public void addNewDeck() {
        for (String suit : SUITS) { this.addSingleSuitCards(suit); }
    }

    private void addSingleSuitCards(String suit) {
        for (int i = 1; i <= 13; i++) {
            this.addCard(new Card(i, suit));
        }
    }

    @Override
    public void addCard(Card card) {
        super.addCard(card);
    }

    @Override
    public void removeCard(int index) {
        super.removeCard(index);
    }

    @Override
    public Card getCardAt(int index) {
        return super.getCardAt(index);
    }

    @Override
    public int size() {
        return super.size();
    }
}
