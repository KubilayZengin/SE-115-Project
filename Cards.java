import java.util.Random;

public class Cards {

    private String number;
    private char symbol;

    public Cards(char symbol,String number ) {
        this.number = number;
        this.symbol = symbol;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public char getSymbol() {
        return symbol;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }



    public static void createDeck(Cards[] deck){
        int counter=0;
        char[] char_array = {'♠', '♣', '♥', '♦'};
        String[] string_array = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for(int i=0; i<4; i++){
            for(int j=0; j<13 ; j++ ){
                Cards card = new Cards(char_array[i],string_array[j]);
                deck[counter] = card;
                System.out.print(deck[counter].symbol);
                System.out.print(deck[counter].number);
                counter++;
            }
            System.out.println("");
        }
        System.out.println(" ");
    }

    public static void shuffleDeck(Cards[] deck){
        Cards[] newdeck = new Cards[52];
        Random random = new Random(System.currentTimeMillis());

        //Shuffling Part
        System.out.println("Shuffling the deck...");
        int[] array_backup = new int[52];
        int counter=0;
        boolean isShuffleOver=true;
        while (isShuffleOver)
        {
            int x = random.nextInt(52);
            if (newdeck[x]==null)
            {
                newdeck[x] = deck[counter];
                counter=counter+1;

            }
            if (counter==52)
            {
                isShuffleOver=false;
            }
        }
        System.out.println("Shuffled deck:");
        for (int i=0;i<52;i++)
        {
            if (i==13 || i==26 || i==39)
            {
                System.out.println(" ");
            }
            System.out.print(newdeck[i].symbol);
            System.out.print(newdeck[i].number);
            System.out.print(" ");
        }
    }
}