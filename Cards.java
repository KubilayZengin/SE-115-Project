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
        System.out.println("Creating a sequential deck... ");
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
        System.out.println("Creating the sequential deck was succesfull.");
        System.out.println();
    }

    public static void shuffleDeck(Cards[] deck){
        Cards[] newdeck = new Cards[52];
        Random random = new Random(System.currentTimeMillis());

        //Shuffling Part
        System.out.println("Shuffling the sequential deck...");
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
        for (int i=0; i<52 ; i++){ deck[i]=newdeck[i];}

        for (int i=0;i<52;i++)
        {
            if (i==13 || i==26 || i==39)
            {
                System.out.println(" ");
            }
            System.out.print(deck[i].symbol);
            System.out.print(deck[i].number);
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("Shuffling the deck was successfull.");
        System.out.println();

    }
    public static void cutDeck(Cards[] deck){
        System.out.println("Cutting the shuffled deck...");
        Cards[] cutdeck = new Cards[52];
        Random random = new Random(System.currentTimeMillis());
        int max=52;
        int min=1;
        int y = random.nextInt(max - min) + min;;
        int counter=0;
        //Cutting the shuffled deck.
        for (int i=y;i<52;i++)
        {
            cutdeck[counter]=deck[i];
            counter=counter+1;
        }
        for (int i=0;i<y;i++)
        {
            cutdeck[counter]=deck[i];
            counter=counter+1;
        }
        for (int i=0; i<52 ; i++){ deck[i]=cutdeck[i];}

        for (int i=0;i<52;i++)
        {
            if (i==13 || i==26 || i==39)
            {
                System.out.println(" ");
            }
            System.out.print(deck[i].symbol);
            System.out.print(deck[i].number);
        }
        System.out.println();
        System.out.println("Cutting the deck was succesfull.");
        System.out.println();
    }
    public static void dealCards(Cards[] deck){
        System.out.println("Dealing the cards...");
        Cards[] players_Deck = new Cards[4];
        Cards[] computers_Deck = new Cards[4];

        int counter=-1;
        for (int i=0;i<4;i++)
        {
            counter=counter+1;
            players_Deck[i]=deck[counter];
            computers_Deck[i]=deck[counter+1];

            counter=counter+1;
        }
        System.out.println("Player's Hand: ");
        for (int i=0;i<4;i++)
        {
            System.out.print(players_Deck[i].symbol);
            System.out.print(players_Deck[i].number+" ");
        }
        System.out.println();
        System.out.println("Computer's Hand: ");
        for (int i=0;i<4;i++)
        {
            System.out.print(computers_Deck[i].symbol);
            System.out.print(computers_Deck[i].number+" ");
        }
        System.out.println();

        System.out.println("The remaining cards in the deck: ");
        for (int i=0;i<deck.length;i++)
        {
            if (i==8)
            {
                break;
            }
            deck[i].number=null;
            deck[i].symbol=0;

        }
        for (int i=0;i<deck.length;i++)
        {
            if (deck[i].symbol==0 || deck[i].number==null)
            {
                continue;
            }
            else
            {
                System.out.print(deck[i].symbol);
                System.out.print(deck[i].number+" ");
            }
        }






    }
}