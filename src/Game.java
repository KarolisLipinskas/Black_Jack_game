import java.util.Random;
import java.util.Scanner;

import static helpers.Constants.*;

public class Game {
    Deck deck = new Deck();
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public Game() {}

    public void startGame() {
        while (true) {
            System.out.println(CARDS_IN_DECK_MASSAGE + deck.size() + "/52");
            System.out.println(START_MENU);
            int answer = scanner.nextInt();
            scanner.nextLine();

            if (answer == 0) break;
            else if (answer == 1) {
                mainGameLoop();
            }
        }
    }

    private void mainGameLoop() {
        Hand player = new Hand();
        Hand dealer = new Hand();
        makeFirstMove(player, dealer);

        Boolean stand = false;
        while (true) {
            int state = gameState(stand, player, dealer);
            if (state != CONTINUE) {
                gameEndMessage(state);
                return;
            }
            stand = playersTurn(player, dealer);
            if (stand == null) continue;
            else if (stand) allDealersTurns(player, dealer);
            dealersTurn(player, dealer);
        }
    }

    private void allDealersTurns(Hand player, Hand dealer) {
        while (dealersTurn(player, dealer)) continue;
    }

    private boolean dealersTurn(Hand player, Hand dealer) {
        if (dealer.getScores().get(0) < DEALERS_STAND_POINT) {
            addCardToHand(dealer);
            display(player, dealer, DEALERS_TURN_MESSAGE);
            return true;
        }
        return false;
    }

    private Boolean playersTurn(Hand player, Hand dealer) {
        System.out.println(PLAYERS_MOVE_MENU);
        int answer = scanner.nextInt();
        scanner.nextLine();
        if (answer == 2) return true;
        if (answer == 1) {
            addCardToHand(player);
            display(player, dealer, PLAYERS_TURN_MESSAGE);
            return false;
        }
        return null;
    }

    private void gameEndMessage(int state) {
        if (state == WIN) {
            System.out.println(WIN_MESSAGE + "\n");
            return;
        }
        if (state == LOSE) {
            System.out.println(LOSE_MESSAGE + "\n");
            return;
        }
        if (state == DRAW) {
            System.out.println(DRAW_MESSAGE + "\n");
            return;
        }
        System.out.println(GAME_END_ERROR + "\n");
    }

    public int gameState(Boolean stand, Hand player, Hand dealer) {
        Integer playerScore = getCurrentScore(player);
        Integer dealerScore = getCurrentScore(dealer);

        if (stand && playerScore <= 21) {
            if (playerScore > dealerScore) {
                return WIN;
            }
            if (dealerScore > 21) {
                return WIN;
            }
            if (playerScore.equals(dealerScore)){
                return DRAW;
            }
            return LOSE;
        }
        if (playerScore > 21 && dealerScore > 21) return DRAW;
        if (playerScore > 21) return LOSE;
        return CONTINUE;
    }

    private Integer getCurrentScore(Hand hand) {
        Integer currentScore = hand.getScores().get(0);
        for (Integer score : hand.getScores()){
            if(score > currentScore && score <= 21) currentScore = score;
        }
        return currentScore;
    }

    private void makeFirstMove(Hand player, Hand dealer) {
        addCardToHand(dealer);
        addCardToHand(player);
        display(player, dealer, FIRST_MOVE_MESSAGE);
    }

    private void display(Hand player, Hand dealer, String message) {
        System.out.println(message);
        displayScores(dealer, DEALER);
        displayScores(player, PLAYER);
        System.out.println();
    }

    private void checkDeck() {
        if (deck.size() == 0) refreshDeck();
    }

    private void refreshDeck() {
        deck.addNewDeck();
        System.out.println(ADDED_NEW_DECK_MASSAGE + "\n");
    }

    private void addCardToHand(Hand hand) {
        int randomIndex = random.nextInt(deck.size());
        hand.addCard(deck.getCardAt(randomIndex));
        deck.removeCard(randomIndex);
        checkDeck();
    }

    public static void displayScores(Hand hand, String name) {
        System.out.print(name + ": ");
        for (int i = 0; i < hand.size(); i++) {
            switch (hand.getCardAt(i).getNumber()) {
                case 1: System.out.print(ACE); break;
                case 11: System.out.print(JACK); break;
                case 12: System.out.print(QUEEN); break;
                case 13: System.out.print(KING); break;
                default: System.out.print(hand.getCardAt(i).getNumber()); break;
            }
            switch (hand.getCardAt(i).getSuit()) {
                case HEART_SUIT: System.out.print(HEART + " "); break;
                case DIAMOND_SUIT: System.out.print(DIAMOND + " "); break;
                case CLUB_SUIT: System.out.print(CLUB + " "); break;
                case SPADE_SUIT: System.out.print(SPADE + " "); break;
                default: System.out.println(SUIT_ERROR); break;
            }
        }
        System.out.print(" | ");
        for (Integer score : hand.getScores()) {
            System.out.print(score + " ");
        }
        System.out.println();
    }
}
