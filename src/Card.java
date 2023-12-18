public class Card {
    private int number;
    private String suit;

    Card(int number, String suit) {
        this.setNumber(number);
        this.setSuit(suit);
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getNumber() {
        return number;
    }

    public String getSuit() {
        return suit;
    }
}
