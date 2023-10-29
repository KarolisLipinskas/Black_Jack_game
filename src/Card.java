public class Card {
    private int number;
    private String suit;
    private String color; //nzn ar reikia

    Card(int number, String suit) {
        this.setNumber(number);
        this.setSuit(suit);
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public void setSuit(String suit) {
        this.suit = suit;
        this.setColor(suit);
    }

    private void setColor(String suit) {
        if (suit.equals("heart") || suit.equals("diamond")) this.color = "red";
        else if (suit.equals("club") || suit.equals("spade")) this.color = "black";
    }

    public int getNumber() {
        return number;
    }

    public String getSuit() {
        return suit;
    }

    public String getColor() {
        return color;
    }
}
