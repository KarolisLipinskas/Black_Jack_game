import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        for (int i = 0; i < deck.size(); i++) {
            Card card = deck.getCardAt(i);
            System.out.println(card.getNumber() + " " + card.getSuit() + " " + card.getColor());
        }

        // game
        Random rand = new Random();

        while (true) {
            System.out.println("CARDS IN DECK: " + deck.size() + "/52");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Start - 1,    Exit - 0");
            int answer = scanner.nextInt();
            scanner.nextLine();
            if (answer == 0) break;
            else if (answer == 1) {
                Hand dealer = new Hand();
                Hand player = new Hand();

                if (deck.size() == 0) {
                    deck.addNewDeck();
                    System.out.println("added new deck");
                }
                int randomIndex = rand.nextInt(deck.size());
                dealer.addCard(deck.getCardAt(randomIndex));
                deck.removeCard(randomIndex);

                if (deck.size() == 0) {
                    deck.addNewDeck();
                    System.out.println("added new deck");
                }
                randomIndex = rand.nextInt(deck.size());
                player.addCard(deck.getCardAt(randomIndex));
                deck.removeCard(randomIndex);

                displayScores(dealer, "DEALER");
                displayScores(player, "PLAYER");

                boolean winFlag = false;
                boolean stand = false;

                while (true) {
                    Integer playerScore = player.getScores().get(0);
                    for (Integer score : player.getScores()){
                        if(score > playerScore && score <= 21) playerScore = score;
                    }

                    Integer dealerScore = dealer.getScores().get(0);
                    for (Integer score : dealer.getScores()){
                        if(score > dealerScore && score <= 21) dealerScore = score;
                    }

                    if (stand && playerScore <= 21) {
                        if (playerScore > dealerScore) {
                            winFlag = true;
                            break;
                        }
                        else if (dealerScore > 21) {
                            winFlag = true;
                            break;
                        }
                        else break;
                    }
                    else if(playerScore > 21) break;

                    System.out.println("Hit - 1,   Stand - 2");
                    answer = scanner.nextInt();
                    scanner.nextLine();
                    if (answer == 1) {
                        if (deck.size() == 0) {
                            deck.addNewDeck();
                            System.out.println("added new deck");
                        }
                        randomIndex = rand.nextInt(deck.size());
                        player.addCard(deck.getCardAt(randomIndex));
                        deck.removeCard(randomIndex);

                        System.out.println("PLAYERS turn:");
                        displayScores(dealer, "DEALER");
                        displayScores(player, "PLAYER");
                        System.out.println();
                    }
                    else if (answer == 2) {
                        stand = true;
                    }
                    else continue;

                    if(stand) {
                        while (dealer.getScores().get(0) < 15) {
                            if (deck.size() == 0) {
                                deck.addNewDeck();
                                System.out.println("added new deck");
                            }
                            System.out.println("DEALERS turn:");
                            randomIndex = rand.nextInt(deck.size());
                            dealer.addCard(deck.getCardAt(randomIndex));
                            deck.removeCard(randomIndex);

                            displayScores(dealer, "DEALER");
                            displayScores(player, "PLAYER");
                            System.out.println();
                        }
                    }
                    else if (dealer.getScores().get(0) < 15) {
                        if (deck.size() == 0) {
                            deck.addNewDeck();
                            System.out.println("added new deck");
                        }
                        System.out.println("DEALERS turn:");
                        randomIndex = rand.nextInt(deck.size());
                        dealer.addCard(deck.getCardAt(randomIndex));
                        deck.removeCard(randomIndex);

                        displayScores(dealer, "DEALER");
                        displayScores(player, "PLAYER");
                        System.out.println();
                    }
                }

                if (winFlag) {
                    System.out.println("YOU WIN!!!");
                    System.out.println();
                }
                else {
                    System.out.println("YOU LOSE");
                    System.out.println();
                }
            }
        }
    }

    public static void displayScores(Hand hand, String name) {
        System.out.print(name + ": ");
        for (int i = 0; i < hand.size(); i++) {
            switch (hand.getCardAt(i).getNumber()) {
                case 1: System.out.print("A"); break;
                case 11: System.out.print("J"); break;
                case 12: System.out.print("Q"); break;
                case 13: System.out.print("K"); break;
                default: System.out.print(hand.getCardAt(i).getNumber()); break;
            }
            switch (hand.getCardAt(i).getSuit()) {
                case "heart": System.out.print("♥ "); break;
                case "diamond": System.out.print("♦ "); break;
                case "club": System.out.print("♣ "); break;
                case "spade": System.out.print("♠ "); break;
                default: System.out.println("ERROR"); break;
            }
        }
        System.out.print(" | ");
        for (Integer score : hand.getScores()) {
            System.out.print(score + " ");
        }
        System.out.println();
    }
}