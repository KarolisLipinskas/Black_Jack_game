import java.util.ArrayList;
import java.util.List;

public abstract class CardList implements CardListInterface {
    List<Card> cardList;

    CardList() {
        cardList = new ArrayList<>();
    }

    @Override
    public void addCard(Card card) {
        cardList.add(card);
    }

    @Override
    public void removeCard(int index) {
        cardList.remove(index);
    }

    @Override
    public Card getCardAt(int index) {
        return cardList.get(index);
    }

    @Override
    public int size() {
        return cardList.size();
    }
}
