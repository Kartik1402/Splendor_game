import java.util.*;

public class game {
    List<Player> players;
    List<List<Card>> deck;
    int currentPlayer = 0;

    String[] tokenColors = { "white", "black", "red", "blue", "green" };
    Random rand = new Random();

    public game(List<String> playerNames) {
        players = new ArrayList<>();
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }
        Load_Csv load = new Load_Csv();
        List<Card> cards = load.loadCardsFromCSV("cards.csv");
        for (Card eachCard : cards) {
            deck.add((eachCard.level), Arrays.asList(eachCard));
        }
        System.out.println(deck.get(1));

        Collections.shuffle(deck);
    }

    // public void playRound() {
    // Scanner sc = new Scanner(System.in);

    // for (Player player : players) {
    // System.out.println("\nPlayer " + player.getName() + "'s turn.");
    // System.out.println("Score: " + player.getScore());

    // boolean validActionTaken = false;

    // while (!validActionTaken) {
    // System.out.println("Choose 1 to buy a card, 2 to reserve a card, 3 to add
    // tokens:");
    // int choice = sc.nextInt();

    // switch (choice) {
    // case 1:
    // if (!deck.isEmpty()) {
    // Card card = deck.get(0);
    // if (player.buyCard(card)) {
    // deck.remove(0);
    // validActionTaken = true;
    // } else {
    // System.out.println("You cannot afford this card. Choose another action.");
    // }
    // } else {
    // System.out.println("No cards left to buy. Choose another action.");
    // }
    // break;
    // case 2:
    // if (!deck.isEmpty()) {
    // Card reservedCard = deck.remove(0);
    // player.reserveCard(reservedCard);
    // validActionTaken = true;
    // } else {
    // System.out.println("No cards left to reserve. Choose another action.");
    // }
    // break;
    // case 3:
    // System.out.println("Press 2 for taking two same tokens, or 3 for taking all
    // different tokens:");
    // int ch = sc.nextInt();
    // switch (ch) {
    // case 2:
    // System.out.println("Enter the token you want two of:");
    // String token = sc.next();
    // player.addtoken(token);
    // player.addtoken(token);
    // break;
    // case 3:
    // System.out.println("Enter three different color tokens:");
    // String t1 = sc.next();
    // String t2 = sc.next();
    // String t3 = sc.next();
    // player.addtoken(t1);
    // player.addtoken(t2);
    // player.addtoken(t3);
    // break;
    // default:
    // System.out.println("Invalid token choice.");
    // break;
    // }
    // validActionTaken = true;
    // break;
    // default:
    // System.out.println("Invalid choice. Try again.");
    // break;
    // }
    // }
    // }

    // currentPlayer = (currentPlayer + 1) % players.size();
    // }

    // public boolean gameOver() {
    // for (Player player : players) {
    // if (player.getScore() >= 15) {
    // System.out.println(player.getName() + " wins!");
    // return true;
    // }
    // }
    // return false;
    // }

    // public void startGame() {
    // while (!gameOver()) {
    // playRound();
    // }
    // }

    public static void main(String[] args) {
        List<String> playerNames = new ArrayList<>();
        playerNames.add("Player 1");
        playerNames.add("Player 2");
        System.out.println("Welcome to the game!");

        game g = new game(playerNames);
        // g.startGame();
    }
}
