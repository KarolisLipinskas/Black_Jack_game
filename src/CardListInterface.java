public interface CardListInterface {
    void addCard(Card card);
    void removeCard(int index);
    Card getCardAt(int index);
    int size();
}
