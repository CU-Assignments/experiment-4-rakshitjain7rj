// Card.java
public class Card {
    private String symbol;
    private String name;
    private String rarity;

    public Card(String symbol, String name, String rarity) {
        this.symbol = symbol;
        this.name = name;
        this.rarity = rarity;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getRarity() {
        return rarity;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", rarity='" + rarity + '\'' +
                '}';
    }
}

// CardCollection.java
import java.util.*;

public class CardCollection {
    private Collection<Card> cards;

    public CardCollection() {
        // Using ArrayList as the concrete implementation
        this.cards = new ArrayList<>();
    }

    // Add a new card to the collection
    public void addCard(Card card) {
        cards.add(card);
    }

    // Remove a card from the collection
    public boolean removeCard(Card card) {
        return cards.remove(card);
    }

    // Find all cards with a specific symbol
    public Collection<Card> findCardsBySymbol(String symbol) {
        Collection<Card> matchingCards = new ArrayList<>();
        for (Card card : cards) {
            if (card.getSymbol().equalsIgnoreCase(symbol)) {
                matchingCards.add(card);
            }
        }
        return matchingCards;
    }

    // Get all unique symbols in the collection
    public Set<String> getAllSymbols() {
        Set<String> symbols = new HashSet<>();
        for (Card card : cards) {
            symbols.add(card.getSymbol());
        }
        return symbols;
    }

    // Get total number of cards in collection
    public int getTotalCards() {
        return cards.size();
    }

    // Display all cards in the collection
    public void displayAllCards() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        // Create a new card collection
        CardCollection collection = new CardCollection();

        // Add some sample cards
        collection.addCard(new Card("Fire", "Dragon", "Rare"));
        collection.addCard(new Card("Water", "Mermaid", "Uncommon"));
        collection.addCard(new Card("Fire", "Phoenix", "Legendary"));
        collection.addCard(new Card("Earth", "Golem", "Rare"));
        collection.addCard(new Card("Water", "Kraken", "Legendary"));

        // Display all cards
        System.out.println("All cards in collection:");
        collection.displayAllCards();

        // Find and display all cards with Fire symbol
        System.out.println("\nAll Fire cards:");
        Collection<Card> fireCards = collection.findCardsBySymbol("Fire");
        for (Card card : fireCards) {
            System.out.println(card);
        }

        // Display all unique symbols
        System.out.println("\nAll unique symbols:");
        Set<String> symbols = collection.getAllSymbols();
        System.out.println(symbols);

        // Display total number of cards
        System.out.println("\nTotal number of cards: " + collection.getTotalCards());
    }
}
