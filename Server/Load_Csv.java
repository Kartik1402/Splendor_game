import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Load_Csv {
    public List<Card> loadCardsFromCSV(String filename) {
        List<Card> cards = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String header = br.readLine(); // Skip the header
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int level = Integer.parseInt(parts[0]);
                int points = Integer.parseInt(parts[1]);
                String color = parts[2];

                HashMap<String, Integer> cost = new HashMap<>();
                String[] tokenColors = { "white", "black", "red", "blue", "green" };
                for (int i = 0; i < tokenColors.length; i++) {
                    int tokenCount = Integer.parseInt(parts[3 + i]);
                    if (tokenCount > 0) {
                        cost.put(tokenColors[i], tokenCount);
                    }
                }

                cards.add(new Card(level, points, cost, color));
            }
        } catch (IOException e) {
            System.err.println("Error reading cards from CSV: " + e.getMessage());
        }
        return cards;
    }

}
