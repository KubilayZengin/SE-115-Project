import java.util.Random;
import java.util.Scanner;

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


//Creating a deck that contains all 52 cards.
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
//Shuffling algorithm.
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
    //Cutting the shuffled deck at a random point chosen by computer.
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
    //Dealing the cards to the player and computer.The order of dealing is 1 to the player and 1 to the computer and so on.
    public static void dealCards(Cards[] deck){
        System.out.println("Dealing the cards...");
        Cards[] players_Deck = new Cards[4];
        Cards[] computers_Deck = new Cards[4];
        Cards[] board_Deck = new Cards[4];

        //Dealing the cards into players hand and computers hand
        int counter=-1;
        for (int i=0;i<4;i++)
        {
            counter=counter+1;
            players_Deck[i]=deck[counter];
            computers_Deck[i]=deck[counter+1];

            counter=counter+1;
//Dealing to the board now...
            if (i==3)
            {
                for (int j=0;j<4;j++)
                {
                    board_Deck[j]=deck[counter+1];
                    counter=counter+1;
                }

            }
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
        System.out.println("Board: ");
        for (int i=0;i<4;i++)
        {
            System.out.print(board_Deck[i].symbol);
            System.out.print(board_Deck[i].number+" ");
        }
        //There are 4 cards on the board but only top of them must be visible.
        //System.out.print(board_Deck[3].symbol);
        //System.out.print(board_Deck[3].number+" ");
        /*for (int i=0;i<deck.length;i++)
        {
            if (i==12)
            {
                break;
            }
            deck[i].number=null;
            deck[i].symbol=0;

        }*/
        //The cards that used in the deck must be abstract from the deck(by making them null).

        /*System.out.println();
        System.out.println("The remaining cards in the deck: ");
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
        */
        //Playing part
        Scanner tarama = new Scanner(System.in);
        int points=0;
        System.out.println();
        System.out.println("Select the card you want to play.");
        System.out.println("Your turn:");
        int input=tarama.nextInt();
        //System.out.println(board_Deck[0].number);
        //System.out.println(board_Deck[0].symbol);


//If your played cards number is equal to boards number...
        if (players_Deck[input-1].number==board_Deck[0].number)
        {
            System.out.println("You collected the card!");
//Setting the point criteria...
            System.out.println("Board:");
            System.out.print(board_Deck[1].symbol);
            System.out.print(board_Deck[1].number+" ");
            System.out.print(board_Deck[2].symbol);
            System.out.print(board_Deck[2].number+" ");
            System.out.print(board_Deck[3].symbol);
            System.out.print(board_Deck[3].number+" ");
           if (Integer.parseInt(board_Deck[0].number) ==10&&  board_Deck[0].symbol=='♦')
            {
                points=points+3;
            }
           else if(Integer.parseInt(board_Deck[0].number)==2 && board_Deck[0].symbol=='♣')
            {
                points=points+2;
            }
            else
           {
               points=points+1;
           }

        }
        else if (players_Deck[input-1].number==board_Deck[1].number)
        {
            System.out.println("You collected the card!");
            System.out.println("Board:");
            System.out.print(board_Deck[0].symbol);
            System.out.print(board_Deck[0].number+" ");
            System.out.print(board_Deck[2].symbol);
            System.out.print(board_Deck[2].number+" ");
            System.out.print(board_Deck[3].symbol);
            System.out.print(board_Deck[3].number+" ");
            if (Integer.parseInt(board_Deck[0].number) ==10&&  board_Deck[0].symbol=='♦')
            {
                points=points+3;
            }
            else if(Integer.parseInt(board_Deck[0].number)==2 && board_Deck[0].symbol=='♣')
            {
                points=points+2;
            }
            else
            {
                points=points+1;
            }

        }
        else if (players_Deck[input-1].number==board_Deck[2].number)
        {
            System.out.println("You collected the card!");
            System.out.println("Board:");
            System.out.print(board_Deck[0].symbol);
            System.out.print(board_Deck[0].number+" ");
            System.out.print(board_Deck[1].symbol);
            System.out.print(board_Deck[1].number+" ");
            System.out.print(board_Deck[3].symbol);
            System.out.print(board_Deck[3].number+" ");
            if (Integer.parseInt(board_Deck[0].number) ==10&&  board_Deck[0].symbol=='♦')
            {
                points=points+3;
            }
            else if(Integer.parseInt(board_Deck[0].number)==2 && board_Deck[0].symbol=='♣')
            {
                points=points+2;
            }
            else
            {
                points=points+1;
            }
        }
        else if (players_Deck[input-1].number==board_Deck[3].number)
        {
            System.out.println("You collected the card!");
            System.out.println("Board:");
            System.out.print(board_Deck[0].symbol);
            System.out.print(board_Deck[0].number+" ");
            System.out.print(board_Deck[1].symbol);
            System.out.print(board_Deck[2].number+" ");
            System.out.print(board_Deck[2].symbol);
            System.out.print(board_Deck[2].number+" ");
            if (Integer.parseInt(board_Deck[0].number) ==10&&  board_Deck[0].symbol=='♦')
            {
                points=points+3;
            }
            else if(Integer.parseInt(board_Deck[0].number)==2 && board_Deck[0].symbol=='♣')
            {
                points=points+2;
            }
            else
            {
                points=points+1;
            }
        }
        else
        {
            System.out.println("Card played.");
        }
        //Computers turn
        //Random random = new Random(System.currentTimeMillis());
        //int x = random.nextInt(4);
        //if (computers_Deck[0].number==board_Deck[3].number)
        //{
            //System.out.println("Computer played.");
        //}
    }
}