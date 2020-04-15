import java.util.Stack;


public class War extends Deck {
    player player1;
    player player2;

    public War(){
        Deck deck = new Deck();
        deck.shuffle();
        Stack[] temp = deck.deal();
        player1 = new player(temp[0]);
        player2 = new player(temp[1]);
        WarEngine();
    }


    public void WarEngine(){
        System.out.println("I'm So Glad you decided to play War!");
        while(player1.getTotalCards()!=0 && player2.getTotalCards()!=0) {
            Challange();
        }

        System.out.println("Game Over");

    }






    public void Challange(){
        if(player1.getTotalCards() == 0 || player2.getTotalCards() == 0) throw new NullPointerException("YOU BOOTY");
            card p1 = (card) player1.getMyCards().getMyDeck().pop();
            card p2 = (card) player2.getMyCards().getMyDeck().pop();

            if(p1.getValue() > p2.getValue()) {
                Stack<card> ret = new Stack();
                ret.push(p1);
                ret.push(p2);
                Stack<card> middleMan = new Stack();
                while(!player1.getMyCards().getMyDeck().isEmpty()){
                    middleMan.push((card) player1.getMyCards().getMyDeck().pop());
                }

                while(!middleMan.isEmpty()){
                    ret.push(middleMan.pop());
                }

                player1.updateTotalCards(1);
                player2.updateTotalCards(-1);
                player1.updateMyCards(ret, player1.getTotalCards());

            }


        if(p1.getValue()<p2.getValue()) {
            Stack<card> Ret = new Stack();
            Ret.push(p1);
            Ret.push(p2);
            Stack<card> MiddleMan = new Stack();
            while(!player2.getMyCards().getMyDeck().isEmpty()){
                MiddleMan.push((card) player2.getMyCards().getMyDeck().pop());
            }

            while(!MiddleMan.isEmpty()){
                Ret.push(MiddleMan.pop());
            }

            player1.updateTotalCards(-1);
            player2.updateTotalCards(1);
            player2.updateMyCards(Ret, player2.getTotalCards());

        }

        player2.printPlayer();

        System.out.println("---------------------");
        player1.printPlayer();

    }






    public class player{
        Deck myCards;
        int totalCards;


        public player(Stack cards){
            myCards = new Deck(cards);
            totalCards = 26;
        }

        public Deck getMyCards(){
            return myCards;
        }

        public int getTotalCards() {
            return totalCards;
        }


        public void updateTotalCards(int x){
            totalCards +=x;
        }

        public void updateMyCards(Stack<card> cards, int num){
            totalCards = num;
            myCards = new Deck(cards);
            //`myCards.printStackDeck();
        }



        public void printPlayer(){
            System.out.println("Total Cards: " + getTotalCards());
            myCards.printStackDeck();
        }

    }




    public static void main(String args[]){
        War game = new War();


    }


}
