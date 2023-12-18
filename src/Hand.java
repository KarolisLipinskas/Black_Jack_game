import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Hand extends CardList implements HandInterface{
    public List<Integer> getScores() {
        List<Integer> scores = new ArrayList<>();
        scores.add(0);
        for (Card card : this.cardList) {
            addScore(scores, card);
        }
        scores = new ArrayList<>(new LinkedHashSet<>(scores));
        return scores;
    }

    private void addScore(List<Integer> scores, Card card) {
        for (int i = 0; i < scores.size(); i++) {
            if (isAce(card)) {
                addAceScore(i, scores);
                break;
            }
            else addCardScore(i, scores, card);
        }
    }

    private boolean isAce(Card card) {
        return card.getNumber() == 1;
    }

    private void addAceScore(int index, List<Integer> scores) {
        int currentScore = scores.get(index);
        scores.set(index, currentScore + 1);
        scores.add(currentScore + 10);
    }

    private void addCardScore(int index, List<Integer> scores, Card card) {
        int currentScore = scores.get(index);
        scores.set(index, currentScore + card.getNumber());
    }

    @Override
    public void addCard(Card card) {
        super.addCard(card);
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
