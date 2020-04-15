import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

//Note if you want to use this class for a different card game, the deal method only works if there are exactly 2 players
public class Deck {
    private card[] myDeck = new card[52];
   private Random myRandom = new Random();
    private String[] suits = {"Diamonds", "Hearts", "Spades", "Clubs"};
    private Stack<card> stackDeck = new Stack<>();

    //for shuffle method, use two arrayLists and then get a random int from one and remove th
    //int at that ind and then add to new arrayList

    public Deck(){
        int dexCount = 0;
        for(int i = 1; i < 14; i++){
            for(String str: suits){
                card add = new card(str,i);
                myDeck[dexCount] = add;
                stackDeck.push(add);
                dexCount++;
            }

        }
    }

    public Deck(Stack<card> cards){
        stackDeck = cards;
    }


    public void changeMyDeck(Stack<card> cards){
        stackDeck = cards;
    }


    public void printDeck(){
        for(card c: myDeck){
            c.printCard();
        }

    }

    public void printStackDeck(){
        Stack prePrint = stackDeck;
        while(!stackDeck.isEmpty()){
            stackDeck.pop().printCard();
        }
        stackDeck = prePrint;
    }

    public Stack getMyDeck(){
        return stackDeck;
    }



    public void shuffle(){
        //void because we're just gonna update myDeck
        ArrayList<card> preShuff = new ArrayList<>();
        for(card c : myDeck){
            preShuff.add(c);
        }

        ArrayList<card> postShuff = new ArrayList<>();
        while(preShuff.size() > 0) {
            int rand = myRandom.nextInt(preShuff.size());
            postShuff.add(preShuff.get(rand));
            preShuff.remove(preShuff.get(rand));
        }

        card[] newDeck = new card[52];
        Stack<card> newStackDeck = new Stack<>();
        for(int x = 0; x<52; x++){
            newDeck[x] = postShuff.get(x);
            newStackDeck.push(postShuff.get(x));
        }
        stackDeck = newStackDeck;
        myDeck = newDeck;
    }



    public Stack[] deal(){
        Stack preDeck = stackDeck;
        Stack<card> Player1 = new Stack<>();
        Stack<card> Player2 = new Stack<>();

        while(!stackDeck.isEmpty()){
            Player1.push(stackDeck.pop());
            Player2.push(stackDeck.pop());

        }

        Stack[] ret = new Stack[2];
        ret[0] = Player1;
        ret[1]= Player2;

        stackDeck = preDeck;
        //stackDeck = ret[0];

        return ret;
    }


    public class card{
        private int value;
        private String suit;

        public card(String Suit, int val){
            value = val;
            suit = Suit;
        }

        public int getValue(){
            return value;
        }

        public String getSuit(){
            return suit;
        }


        public void printCard(){
            System.out.println( value + ", " + suit);
        }



    }


public static void main(String args[]){
        Deck test = new Deck();
        test.shuffle();
        //test.deal();
        test.printStackDeck();

    }


}
