public class Main {
    public static void main(String[] args) {
        Cards[] deck = new Cards[52];

        Cards.createDeck(deck);
        Cards.shuffleDeck(deck);
        Cards.cutDeck(deck);
        Cards.dealCards(deck);
    }
}