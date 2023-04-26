package main.backend;
import java.util.ArrayList;
import java.util.Collections;

public class Cpu {
    //CPU cards 
    public ArrayList<Card> cards;
    /**
     * 
     * @param cards 
     * Constructer of the CPU class, it takes in the CPU cards as an arrayList of Type Card then saves them in cards
     */
    public Cpu(ArrayList<Card>cards)
    {
        this.cards=cards;
    }
   /**
    * Shuffles the CPU cards then returns the card in CPU deck at 0 if the deck if empty it returns null
    * @return card in CPU deck at 0 else null
    */
    public Card play()
    {
        if (Loader.Deck.size() == 0) {
            Card returner;
            Card nullCard = new Card("0", "\tH");
            int i=0;
            do {
                // returning the card at 0
                returner = cards.get(i);
                cards.set(i, new Card("0", "\tH"));
                i++;
            } while (returner.getCard().equals(nullCard.getCard()));
            return returner;

        }
        //checking if the CPU card array is empty
       else {
               //shuffling the CPU cards
           Collections.shuffle(cards);
           // returning the card at 0
           return cards.remove(0);
       }
    //else returning null
    }

}//Increased difficulty by checking if the played suit and number  is greater than possible options to play