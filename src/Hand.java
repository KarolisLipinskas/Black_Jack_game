import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Hand {
    List<Card> hand = new ArrayList<>();

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public Card getCardAt(int index) {
        return hand.get(index);
    }

    public int size() {
        return hand.size();
    }

    public List<Integer> getScores() {
        List<Integer> scores = new ArrayList<>();
        scores.add(0);
        for (Card card : hand) {
            for (int i = 0; i < scores.size(); i++) {
                int score = scores.get(i);
                if (card.getNumber() == 1) {
                    scores.set(i, score + 1);
                    scores.add(score + 10);
                    break;
                }
                else {
                    scores.set(i, score + card.getNumber());
                }
            }
        }
        scores = new ArrayList<>(new LinkedHashSet<>(scores));
        return scores;
    }
}
