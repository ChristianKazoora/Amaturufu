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

            if(playedCard==null)
            {

                returner= FirstToPlay();
            }
            else
            {
                returner= SecondToPlay();
            }

            if(Loader.Deck.size() == 0)
                cards.add(new Card("1", "\tH"));

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
       // System.out.println("FirstToPlay - CPU played: "+toReturn);
        cards.remove(toReturn);
        return toReturn;
    }
    private Card SecondToPlay()
    {
    //If CPU play's second,
        //    check to see if the player played a card with the same suite as the Iturufu
        //        if its not of high value, play the card with the least points
        //        if it is of high value, and CPU has one with higher value, play the higher value card and eat

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

                if(toBeReturned.getValue()==Integer.MAX_VALUE)
                    toBeReturned=card;
            }
          //  System.out.println("SecondToPlay (if iturufu suite == played sute) - CPU played: "+toBeReturned);
        }
        else
        {

            if(playedCard.getValue()>2&&playedCard.getValue()<=10&&cardsContainIturufuSuit())
            {
                for(Card card:cards)
                {
                    if(card.getSuite().equals(iturufu.getSuite())&&card.getValue()<toBeReturned.getValue())
                    {
                        toBeReturned=card;
                    }
                }
             //   System.out.println("SecondToPlay (if iturufu suite != played suite but between (2-10)) - CPU played: "+toBeReturned);
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

                        if(toBeReturned.getValue()==Integer.MAX_VALUE)
                            toBeReturned=card;
                    }
                }
             //   System.out.println("SecondToPlay (if iturufu suite != played suite and not between (2-10) play least value) - CPU played: "+toBeReturned);
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