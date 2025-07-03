import java.util.*;

class Card {
    int level;
    int points;
    HashMap<String, Integer> cost = new HashMap<>();
    String color;

    public Card(int level, int points, HashMap<String, Integer> cost, String color) {
        this.level = level;
        this.points = points;
        this.cost = cost;
        this.color = color;
    }

    public int getPoints() {
        return points;
    }

    public HashMap<String, Integer> getCost() {
        return cost;
    }

    public String getColor() {
        return color;
    }
}