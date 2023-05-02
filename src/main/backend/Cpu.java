package main.backend;
import java.util.ArrayList;
import java.util.Collections;
public class Cpu {
    //CPU cards 
    public ArrayList<Card> cards;
    Card iturufu;
    Card playedCard;
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
    public Card play(Card iturufu,Card playedCard)
    {
        this.iturufu=iturufu;
        this.playedCard=playedCard;
        Card returner;

        if (Loader.Deck.size() == 0) {

                if(playedCard==null)
                {
                    System.out.println("CPU's thoughts on the player's played card: "+playedCard);
                    System.out.println("CPU's thoughts on the iturufu: "+iturufu);
                    returner= FirstToPlay();
                }
                else
                {
                    System.out.println("CPU's thoughts on the player's played card: "+playedCard);
                    System.out.println("CPU's thoughts on the iturufu: "+iturufu);
                    returner= SecondToPlay();
                }

                cards.add(new Card("1", "\tH"));


        }
        //checking if the CPU card array is empty
       else {

            if(playedCard==null)
            {
                System.out.println("CPU's thoughts on the player's played card: "+playedCard);
                System.out.println("CPU's thoughts on the iturufu: "+iturufu);
                returner= FirstToPlay();
            }
            else
            {
                System.out.println("CPU's thoughts on the player's played card: "+playedCard);
                System.out.println("CPU's thoughts on the iturufu: "+iturufu);
                returner= SecondToPlay();
            }
       }
       return returner;
    }
    private Card FirstToPlay()
    {

        //cards with same suite as the Iturufu are to be played later when the player plays cards worth more point
        Card toReturn = new Card("1","\tH");
        //If CPU play's winner, play the card with the least points.
        //if there are any other suits that are not the same as the Iturufu, play the card with the least points

        for(Card card:cards)
        {

            if(card.getValue()<toReturn.getValue() && !card.getSuite().equals(iturufu.getSuite())){
                toReturn=card;
            }
            else {
                if(toReturn.getValue()>card.getValue()&&toReturn.getValue()!=Integer.MAX_VALUE)
                    toReturn=card;
            }
        }
        cards.remove(toReturn);
        return toReturn;
    }
    private Card SecondToPlay()
    {
    //If CPU play's second,
        //    check to see if the player played a card with the same suite as the Iturufu
        //        if its not of high value, play the card with the least points
        //        if it is of high value, and CPU has one with higher value, play the higher value card and eat
        //        if it is of high value, and CPU does not have one with higher value, play the card with the least points

        Card toBeReturned=new Card("1","\tH");
        if(playedCard.getSuite().equals(iturufu.getSuite()))
        {
            for(Card card:cards) {

                if (card.getValue() < toBeReturned.getValue() && !card.getSuite().equals(iturufu.getSuite())) {
                    toBeReturned = card;
                }else{
                    if(toBeReturned.getValue()>card.getValue()&&toBeReturned.getValue()!=Integer.MAX_VALUE)
                        toBeReturned=card;
                }
                if(toBeReturned.getValue()==Integer.MAX_VALUE&& !card.getSuite().equals(iturufu.getSuite()))
                    toBeReturned=card;
            }
        }
        else
        {

            if(playedCard.getValue()>2||playedCard.getValue()<=10&&cardsContainIturufuSuit())
            {
                for(Card card:cards)
                {
                    if(card.getSuite().equals(iturufu.getSuite())&&card.getValue()<toBeReturned.getValue())
                    {
                        toBeReturned=card;
                    }
                }
            }
            else
            {
                //play the card with the least points
                for(Card card:cards) {

                    if (card.getValue() < toBeReturned.getValue() && !card.getSuite().equals(iturufu.getSuite())) {
                        toBeReturned = card;
                    }else{
                        if(toBeReturned.getValue()>card.getValue()&&toBeReturned.getValue()!=Integer.MAX_VALUE)
                            toBeReturned=card;

                        if(toBeReturned.getValue()==Integer.MAX_VALUE&& !card.getSuite().equals(iturufu.getSuite()))
                            toBeReturned=card;
                    }
                }
            }


        }
        cards.remove(toBeReturned);
        return toBeReturned;
    }

    private boolean cardsContainIturufuSuit() {
        for(Card card:cards)
        {
            if(card.getSuite().equals(iturufu.getSuite()))
            {
                return true;
            }
        }
        return false;
    }

}
//Increased difficulty by checking if the played suit and number  is greater than possible options to play