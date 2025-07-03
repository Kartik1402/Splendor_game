import java.util.ArrayList;
import java.util.HashMap;

class Player {
    String name;
    ArrayList<Card> cards;
    ArrayList<Card> reservedCards;
    HashMap<String, Integer> tokens;
    int score;

    Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
        this.reservedCards = new ArrayList<>();
        this.tokens = new HashMap<>();
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void addtoken(String token) {
        int totalTokens = tokens.getOrDefault(token, 0);
        if (totalTokens >= 10) {
            System.out.println("token limit exceeded");
            return;
        } else {
            tokens.put(token, totalTokens + 1);
            System.out.println("token added");
        }

    }

    public void reserveCard(Card card) {
        this.reservedCards.add(card);
        tokens.put("universal", tokens.getOrDefault("universal", 0) + 1);
    }

    public boolean buyCard(Card card) {
        for (HashMap.Entry<String, Integer> entry : card.getCost().entrySet()) {
            int availableTokens = tokens.getOrDefault(entry.getKey(), 0);
            int requiredTokens = entry.getValue();
            int universalTokens = tokens.getOrDefault("universal", 0);
            if (availableTokens < requiredTokens) {
                if (universalTokens < requiredTokens - availableTokens) {
                    System.out.println("not enough tokens");
                    return false;
                } else {
                    tokens.put("universal", universalTokens - (requiredTokens - availableTokens));
                }
            } else {
                tokens.put(entry.getKey(), availableTokens - requiredTokens);
            }
        }
        this.cards.add(card);
        this.score += card.getPoints();
        return true;
    }
}
